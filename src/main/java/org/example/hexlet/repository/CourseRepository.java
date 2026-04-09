package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();
    private static Long nextId = 6L; // У вас уже есть курсы с id 1-5

    static {
        // Добавляем начальные курсы (если нужно)
        // courses.add(new Course(1L, "Java", "Описание"));
    }

    public static void save(Course course) {
        course.setId(nextId);
        nextId++;
        courses.add(course);
    }

    public static List<Course> all() {
        return new ArrayList<>(courses);
    }

    public static Course find(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }
}
