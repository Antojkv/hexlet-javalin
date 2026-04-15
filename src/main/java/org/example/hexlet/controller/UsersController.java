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

    public static void index(Context ctx) {
        var users = UserRepository.all();
        var page = new UsersPage(users);

        // Читаем флеш-сообщение из сессии
        String flash = ctx.consumeSessionAttribute("flash");
        String flashType = ctx.consumeSessionAttribute("flashType");
        if (flash != null) {
            page.setFlash(flash);
            page.setFlashType(flashType != null ? flashType : "success");
        }

        ctx.render("users/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String passwordConfirmation = ctx.formParam("passwordConfirmation");

        if (name != null) name = name.trim();
        if (email != null) email = email.trim().toLowerCase();

        try {
            if (name == null || name.isEmpty()) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("name", List.of(new io.javalin.validation.ValidationError<>("Имя не может быть пустым")))
                );
            }

            if (UserRepository.existsByEmail(email)) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("email", List.of(new io.javalin.validation.ValidationError<>("Пользователь с таким email уже существует")))
                );
            }

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

            User user = new User(name, email, password);
            UserRepository.save(user);

            // Устанавливаем флеш-сообщение об успехе
            ctx.sessionAttribute("flash", "Пользователь \"" + name + "\" успешно зарегистрирован!");
            ctx.sessionAttribute("flashType", "success");
            ctx.redirect(NamedRoutes.usersPath());

        } catch (io.javalin.validation.ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
        }
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);

        if (user == null) {
            throw new NotFoundResponse("Пользователь с ID " + id + " не найден");
        }

        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);

        if (user == null) {
            throw new NotFoundResponse("Пользователь с ID " + id + " не найден");
        }

        ctx.render("users/edit.jte", model("user", user));
    }

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

        // Устанавливаем флеш-сообщение об успешном обновлении
        ctx.sessionAttribute("flash", "Пользователь \"" + user.getName() + "\" успешно обновлен!");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);
        String userName = user != null ? user.getName() : "";

        UserRepository.delete(id);

        // Устанавливаем флеш-сообщение об успешном удалении
        ctx.sessionAttribute("flash", "Пользователь \"" + userName + "\" успешно удален!");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect(NamedRoutes.usersPath());
    }
}