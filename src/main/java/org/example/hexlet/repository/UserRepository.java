package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();

    public static void save(User user) {
        users.add(user);
    }

    public static List<User> all() {
        return users;
    }
}