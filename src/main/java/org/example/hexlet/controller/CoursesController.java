package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class CoursesController {

    public static void index(Context ctx) {
        String term = ctx.queryParam("term");

        try {
            var allCourses = CourseRepository.all();
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

            String flash = ctx.consumeSessionAttribute("flash");
            String flashType = ctx.consumeSessionAttribute("flashType");
            if (flash != null) {
                page.setFlash(flash);
                page.setFlashType(flashType != null ? flashType : "success");
            }

            ctx.render("courses/index.jte", model("page", page));
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.status(500);
            ctx.result("Ошибка базы данных: " + e.getMessage());
        }
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String description = ctx.formParam("description");

        if (name != null) name = name.trim();
        if (description != null) description = description.trim();

        try {
            if (name == null || name.length() <= 2) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("name", List.of(new io.javalin.validation.ValidationError<>("Название должно быть длиннее 2 символов")))
                );
            }

            if (description == null || description.length() <= 10) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("description", List.of(new io.javalin.validation.ValidationError<>("Описание должно быть длиннее 10 символов")))
                );
            }

            Course course = new Course(null, name, description);
            CourseRepository.save(course);

            ctx.sessionAttribute("flash", "Курс \"" + name + "\" успешно создан!");
            ctx.sessionAttribute("flashType", "success");
            ctx.redirect(NamedRoutes.coursesPath());

        } catch (io.javalin.validation.ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.sessionAttribute("flash", "Ошибка базы данных: " + e.getMessage());
            ctx.sessionAttribute("flashType", "error");
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Курс с ID " + id + " не найден"));

            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.status(500);
            ctx.result("Ошибка базы данных: " + e.getMessage());
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Курс с ID " + id + " не найден"));

            ctx.render("courses/edit.jte", model("course", course));
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.status(500);
            ctx.result("Ошибка базы данных: " + e.getMessage());
        }
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Курс с ID " + id + " не найден"));

            String name = ctx.formParam("name");
            String description = ctx.formParam("description");

            if (name != null) course.setName(name.trim());
            if (description != null) course.setDescription(description.trim());

            CourseRepository.update(course);

            ctx.sessionAttribute("flash", "Курс \"" + course.getName() + "\" успешно обновлен!");
            ctx.sessionAttribute("flashType", "success");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.sessionAttribute("flash", "Ошибка базы данных: " + e.getMessage());
            ctx.sessionAttribute("flashType", "error");
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            CourseRepository.delete(id);

            ctx.sessionAttribute("flash", "Курс успешно удален!");
            ctx.sessionAttribute("flashType", "success");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.sessionAttribute("flash", "Ошибка базы данных: " + e.getMessage());
            ctx.sessionAttribute("flashType", "error");
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }
}