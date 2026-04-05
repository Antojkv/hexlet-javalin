package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

// Импортируем наши DTO классы
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение с поддержкой jte
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // ===== СУЩЕСТВУЮЩИЕ МАРШРУТЫ =====

        app.get("/users", ctx -> {
            // Теперь используем шаблон вместо простого текста
            ctx.render("users/index.jte");
        });

        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class)
                    .getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        // ===== МАРШРУТЫ ДЛЯ КУРСОВ =====

        // Главная страница (использует макет через index.jte)
        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        // Список всех курсов
        app.get("/courses", ctx -> {
            var courses = Data.getCourses();
            var header = "Все курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        // Страница отдельного курса
        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var course = Data.getCourseById(id);

            if (course == null) {
                ctx.status(404);
                ctx.result("Курс с ID " + id + " не найден");
                return;
            }

            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.start(7070);
        System.out.println("Сервер запущен! Откройте: http://localhost:7070/");
    }
}
