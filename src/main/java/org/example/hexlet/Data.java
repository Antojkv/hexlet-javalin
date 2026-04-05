package org.example.hexlet;

import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Course> courses = new ArrayList<>();

    static {
        // Добавляем тестовые данные
        courses.add(new Course(1L, "Java для начинающих", "Изучите основы Java программирования с нуля"));
        courses.add(new Course(2L, "Python для анализа данных", "Научитесь обрабатывать данные с помощью Python"));
        courses.add(new Course(3L, "Веб-разработка на JavaScript", "Создавайте современные веб-приложения"));
        courses.add(new Course(4L, "Spring Boot", "Освойте популярный фреймворк для Java"));
        courses.add(new Course(5L, "SQL и базы данных", "Научитесь работать с базами данных"));
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static Course getCourseById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }
}
