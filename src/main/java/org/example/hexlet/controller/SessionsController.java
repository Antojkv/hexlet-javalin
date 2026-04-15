package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.NamedRoutes;


public class SessionsController {

    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        String nickname = ctx.formParam("nickname");

        if (nickname != null && !nickname.isEmpty()) {
            ctx.sessionAttribute("currentUser", nickname);
        }

        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
}
