package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.apache.commons.text.StringEscapeUtils;

// Импортируем наши DTO классы
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

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

        app.get(NamedRoutes.userPath("{id}") + "/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        // ===== МАРШРУТЫ ДЛЯ КУРСОВ =====

        // Главная страница
        app.get(NamedRoutes.rootPath(), ctx -> {
            ctx.render("index.jte");
        });

        // 1. КОНКРЕТНЫЙ маршрут - форма создания курса
        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        // 2. Обработчик создания курса (POST)
        app.post(NamedRoutes.coursesPath(), ctx -> {
            String name = ctx.formParam("name");
            String description = ctx.formParam("description");

            if (name != null) name = name.trim();
            if (description != null) description = description.trim();

            try {
                // Валидация названия (длиннее 2 символов)
                if (name == null || name.length() <= 2) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("name", List.of(new io.javalin.validation.ValidationError<>("Название должно быть длиннее 2 символов")))
                    );
                }

                // Валидация описания (длиннее 10 символов)
                if (description == null || description.length() <= 10) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("description", List.of(new io.javalin.validation.ValidationError<>("Описание должно быть длиннее 10 символов")))
                    );
                }

                // Сохраняем курс
                Course course = new Course(null, name, description);
                Data.addCourse(course);
                ctx.redirect(NamedRoutes.coursesPath());

            } catch (io.javalin.validation.ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        // 3. Список всех курсов с поиском
        app.get(NamedRoutes.coursesPath(), ctx -> {
            String term = ctx.queryParam("term");
            var allCourses = Data.getCourses();
            ArrayList<Course> filteredCourses = new ArrayList<>();

            if (term != null && !term.isEmpty()) {
                for (var course : allCourses) {
                    String lowerTerm = term.toLowerCase();
                    if (course.getName().toLowerCase().contains(lowerTerm) ||
                            course.getDescription().toLowerCase().contains(lowerTerm)) {
                        filteredCourses.add(course);
                    }
                }
            } else {
                filteredCourses = new ArrayList<>(allCourses);
                term = "";
            }

            var header = "Все курсы по программированию";
            var page = new CoursesPage(filteredCourses, header, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        // 4. ДИНАМИЧЕСКИЙ маршрут - страница отдельного курса
        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
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

        // Страница со списком пользователей
        app.get(NamedRoutes.usersPath(), ctx -> {
            var users = UserRepository.all();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // Страница с формой создания пользователя
        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        // Обработчик создания пользователя (с валидацией)
        app.post(NamedRoutes.usersPath(), ctx -> {
            String name = ctx.formParam("name");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");

            // Нормализация
            if (name != null) name = name.trim();
            if (email != null) email = email.trim().toLowerCase();

            try {
                // 1. Проверка имени
                if (name == null || name.isEmpty()) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("name", List.of(new io.javalin.validation.ValidationError<>("Имя не может быть пустым")))
                    );
                }

                // 2. Проверка email (уникальность)
                if (UserRepository.existsByEmail(email)) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("email", List.of(new io.javalin.validation.ValidationError<>("Пользователь с таким email уже существует")))
                    );
                }

                // 3. Проверка пароля
                if (password == null || !password.equals(passwordConfirmation)) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("password", List.of(new io.javalin.validation.ValidationError<>("Пароли не совпадают")))
                    );
                }

                if (password.length() < 3) {
                    throw new io.javalin.validation.ValidationException(
                            Map.of("password", List.of(new io.javalin.validation.ValidationError<>("Пароль должен быть не короче 3 символов")))
                    );
                }

                // Все проверки пройдены - сохраняем
                User user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());

            } catch (io.javalin.validation.ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        app.start(7070);
        System.out.println("Сервер запущен! Откройте: http://localhost:7070/");
    }
}