package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.Data;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class CoursesController {

    // GET /courses - список всех курсов
    public static void index(Context ctx) {
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
    }

    // GET /courses/build - форма создания курса
    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    // POST /courses - создание курса
    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String description = ctx.formParam("description");

        if (name != null) name = name.trim();
        if (description != null) description = description.trim();

        try {
            // Валидация названия
            if (name == null || name.length() <= 2) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("name", List.of(new io.javalin.validation.ValidationError<>("Название должно быть длиннее 2 символов")))
                );
            }

            // Валидация описания
            if (description == null || description.length() <= 10) {
                throw new io.javalin.validation.ValidationException(
                        Map.of("description", List.of(new io.javalin.validation.ValidationError<>("Описание должно быть длиннее 10 символов")))
                );
            }

            Course course = new Course(null, name, description);
            Data.addCourse(course);
            ctx.redirect(NamedRoutes.coursesPath());

        } catch (io.javalin.validation.ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    // GET /courses/{id} - страница конкретного курса
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = Data.getCourseById(id);

        if (course == null) {
            throw new NotFoundResponse("Курс с ID " + id + " не найден");
        }

        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    // GET /courses/{id}/edit - форма редактирования курса
    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = Data.getCourseById(id);

        if (course == null) {
            throw new NotFoundResponse("Курс с ID " + id + " не найден");
        }

        ctx.render("courses/edit.jte", model("course", course));
    }

    // PATCH /courses/{id} - обновление курса
    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = Data.getCourseById(id);

        if (course == null) {
            throw new NotFoundResponse("Курс с ID " + id + " не найден");
        }

        String name = ctx.formParam("name");
        String description = ctx.formParam("description");

        if (name != null) course.setName(name.trim());
        if (description != null) course.setDescription(description.trim());

        ctx.redirect(NamedRoutes.coursesPath());
    }

    // DELETE /courses/{id} - удаление курса
    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Data.deleteCourseById(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
