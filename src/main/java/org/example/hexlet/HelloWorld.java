package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
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
        app.start(7070); // Стартуем веб-сервер
    }
}
