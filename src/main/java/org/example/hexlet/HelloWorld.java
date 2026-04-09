package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.apache.commons.text.StringEscapeUtils;


// Импортируем наши DTO классы
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение с поддержкой jte
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // ===== СУЩЕСТВУЮЩИЕ МАРШРУТЫ =====

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
            // Получаем поисковый запрос
            String term = ctx.queryParam("term");

            // Получаем все курсы
            var allCourses = Data.getCourses();

            // Список для результатов
            ArrayList<Course> filteredCourses = new ArrayList<>();

            // Если есть поисковый запрос
            if (term != null && !term.isEmpty()) {
                // Ищем курсы
                for (var course : allCourses) {
                    String lowerTerm = term.toLowerCase();
                    if (course.getName().toLowerCase().contains(lowerTerm) ||
                            course.getDescription().toLowerCase().contains(lowerTerm)) {
                        filteredCourses.add(course);
                    }
                }
            } else {
                // Если поиска нет - показываем все
                filteredCourses = new ArrayList<>(allCourses);
                term = "";
            }

            var header = "Все курсы по программированию";
            var page = new CoursesPage(filteredCourses, header, term);
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

        app.get("/users/escaped/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result("<h1>User ID: " + escapedId + "</h1>");
        });

        // Автоматическое экранирование через шаблонизатор JTE
        app.get("/users/safe/{id}", ctx -> {
            var id = ctx.pathParam("id");
            ctx.render("user/show.jte", model("userId", id));
        });

        // ===== МАРШРУТЫ ДЛЯ ПОЛЬЗОВАТЕЛЕЙ (НОВЫЕ) =====

        // Страница со списком пользователей
        app.get("/users", ctx -> {
            var users = UserRepository.all();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // Страница с формой создания пользователя
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        // Обработчик создания пользователя (POST запрос)
        app.post("/users", ctx -> {
            // Получаем данные из формы
            String name = ctx.formParam("name");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");

            // Простая проверка: пароль и подтверждение должны совпадать
            if (password == null || !password.equals(passwordConfirmation)) {
                ctx.status(400);
                ctx.result("Пароли не совпадают!");
                return;
            }

            // Нормализация email: обрезаем пробелы и приводим к нижнему регистру
            email = email.trim().toLowerCase();

            // Нормализация имени: обрезаем пробелы
            name = name.trim();

            // Создаем пользователя
            User user = new User(name, email, password);
            UserRepository.save(user);

            // Перенаправляем на страницу со списком пользователей
            ctx.redirect("/users");
        });

        app.start(7070);
        System.out.println("Сервер запущен! Откройте: http://localhost:7070/");
    }
}