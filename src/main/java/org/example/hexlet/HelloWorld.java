package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            // Получаем параметр name из запроса
            String name = ctx.queryParamAsClass("name", String.class)
                    .getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });
        app.get("/users/{id}/post/{postId}", ctx -> {

            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");

            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

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

        app.start(7070); // Стартуем веб-сервер
    }
}
