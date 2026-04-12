package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;


import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.Map;
import java.util.List;

public class UsersController {

    // GET /users - список всех пользователей
    public static void index(Context ctx) {
        var users = UserRepository.all();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", model("page", page));
    }

    // GET /users/build - форма создания пользователя
    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    // POST /users - создание пользователя
    public static void create(Context ctx) {
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
    }

    // GET /users/{id} - страница конкретного пользователя
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);

        if (user == null) {
            throw new NotFoundResponse("Пользователь с ID " + id + " не найден");
        }

        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    // GET /users/{id}/edit - форма редактирования пользователя
    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);

        if (user == null) {
            throw new NotFoundResponse("Пользователь с ID " + id + " не найден");
        }

        ctx.render("users/edit.jte", model("user", user));
    }

    // PATCH /users/{id} - обновление пользователя
    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);

        if (user == null) {
            throw new NotFoundResponse("Пользователь с ID " + id + " не найден");
        }

        String name = ctx.formParam("name");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        if (name != null) user.setName(name.trim());
        if (email != null) user.setEmail(email.trim().toLowerCase());
        if (password != null && !password.isEmpty()) user.setPassword(password);

        ctx.redirect(NamedRoutes.usersPath());
    }

    // DELETE /users/{id} - удаление пользователя
    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
