package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();
    private static Long nextId = 1L;

    public static void save(User user) {
        if (user.getId() == null) {
            user.setId(nextId);
            nextId++;
            users.add(user);
        }
    }

    public static List<User> all() {
        return new ArrayList<>(users);
    }

    public static User find(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static void delete(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public static boolean existsByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}