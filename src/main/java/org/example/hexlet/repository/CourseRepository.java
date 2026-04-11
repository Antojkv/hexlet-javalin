package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    public static void save(Course course) {
        courses.add(course);
    }

    public static List<Course> all() {
        return courses;
    }
}
