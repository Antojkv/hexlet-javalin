package org.example.hexlet.dto;

public class MainPage {
    private boolean visited;
    private String currentUser;

    // Конструктор для главной страницы (только visited)
    public MainPage(boolean visited) {
        this.visited = visited;
        this.currentUser = null;
    }

    // Конструктор с пользователем
    public MainPage(boolean visited, String currentUser) {
        this.visited = visited;
        this.currentUser = currentUser;
    }

    public boolean isVisited() {
        return visited;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
