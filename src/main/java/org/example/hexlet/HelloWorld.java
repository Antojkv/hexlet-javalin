package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.repository.BaseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) throws SQLException {
        // Настройка подключения к базе данных
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);

        // Инициализация схемы базы данных
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines()
                .collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }

        // Сохраняем dataSource в BaseRepository
        BaseRepository.dataSource = dataSource;

        // Создаем приложение с поддержкой jte
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.router.treatMultipleSlashesAsSingleSlash = true;
        });

        // Мидлвара для логирования
        app.before(ctx -> {
            System.out.println("[" + java.time.LocalDateTime.now() + "] " + ctx.method() + " " + ctx.path());
        });

        // ===== ТЕСТОВЫЕ МАРШРУТЫ =====
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
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

        // ===== МАРШРУТЫ ДЛЯ ПОЛЬЗОВАТЕЛЕЙ =====
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.userPath("{id}"), UsersController::destroy);

        // ===== МАРШРУТЫ ДЛЯ СЕССИЙ =====
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.post(NamedRoutes.sessionsPath() + "/delete", SessionsController::destroy);

        // ===== МАРШРУТЫ ДЛЯ КУРСОВ =====
        app.get(NamedRoutes.rootPath(), ctx -> {
            String visitedCookie = ctx.cookie("visited");
            boolean visited = Boolean.parseBoolean(visitedCookie);
            String currentUser = ctx.sessionAttribute("currentUser");
            var page = new MainPage(visited, currentUser);
            ctx.render("index.jte", model("page", page));
            if (!visited) {
                ctx.cookie("visited", "true");
            }
        });

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);
        app.post("/users/{id}/delete", UsersController::destroy);

        app.start(7070);
        System.out.println("Сервер запущен! Откройте: http://localhost:7070/");
    }
}