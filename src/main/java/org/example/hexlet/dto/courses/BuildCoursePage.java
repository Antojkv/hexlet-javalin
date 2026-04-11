package org.example.hexlet.dto.courses;

import java.util.Map;
import java.util.List;
import io.javalin.validation.ValidationError;

public class BuildCoursePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildCoursePage() {
        this.name = "";
        this.description = "";
        this.errors = null;
    }

    public BuildCoursePage(String name, String description, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.description = description;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }
}
