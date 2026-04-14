package org.example.hexlet;

public class NamedRoutes {

    // ===== МАРШРУТЫ ДЛЯ ГЛАВНОЙ СТРАНИЦЫ =====
    public static String rootPath() {
        return "/";
    }

    // ===== МАРШРУТЫ ДЛЯ КУРСОВ =====
    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String editCoursePath(String id) {
        return "/courses/" + id + "/edit";
    }

    public static String editCoursePath(Long id) {
        return "/courses/" + id + "/edit";
    }


    // ===== МАРШРУТЫ ДЛЯ ПОЛЬЗОВАТЕЛЕЙ =====
    public static String usersPath() {
        return "/users";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String editUserPath(String id) {
        return "/users/" + id + "/edit";
    }

    public static String editUserPath(Long id) {
        return "/users/" + id + "/edit";
    }


    // ===== ТЕСТОВЫЕ МАРШРУТЫ =====
    public static String escapedPath(String id) {
        return "/users/escaped/" + id;
    }

    public static String safePath(String id) {
        return "/users/safe/" + id;
    }

    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
