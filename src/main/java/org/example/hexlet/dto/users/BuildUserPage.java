package org.example.hexlet.dto.users;

import java.util.Map;
import java.util.List;
import io.javalin.validation.ValidationError;

public class BuildUserPage {
    private String name;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;

    // Конструктор для пустой формы
    public BuildUserPage() {
        this.name = "";
        this.email = "";
        this.errors = null;
    }

    // Конструктор с данными и ошибками
    public BuildUserPage(String name, String email, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.email = email;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }
}
