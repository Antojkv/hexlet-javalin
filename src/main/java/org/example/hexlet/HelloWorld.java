package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;  // ← ДОБАВИТЬ ЭТОТ ИМПОРТ
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.controller.CoursesController;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение с поддержкой jte
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.router.treatMultipleSlashesAsSingleSlash = true;
        });

        // ===== ТЕСТОВЫЕ МАРШРУТЫ =====
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class)
                    .getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });

        app.get(NamedRoutes.userPath("{id}") + "/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        // ===== ТЕСТЫ XSS =====
        app.get(NamedRoutes.escapedPath("{id}"), ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result("<h1>User ID: " + escapedId + "</h1>");
        });

        app.get(NamedRoutes.safePath("{id}"), ctx -> {
            var id = ctx.pathParam("id");
            ctx.render("user/show.jte", model("userId", id));
        });

        // ===== МАРШРУТЫ ДЛЯ ПОЛЬЗОВАТЕЛЕЙ (CRUD) =====
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.userPath("{id}"), UsersController::destroy);

        // ===== МАРШРУТЫ ДЛЯ КУРСОВ (CRUD) =====
        app.get(NamedRoutes.rootPath(), ctx -> ctx.render("index.jte"));
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);

        app.start(7070);
        System.out.println("Сервер запущен! Откройте: http://localhost:7070/");
    }
}