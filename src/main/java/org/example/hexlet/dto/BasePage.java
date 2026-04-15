package org.example.hexlet.dto;

public class BasePage {
    private String flash;
    private String flashType; // "success" или "error"

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getFlashType() {
        return flashType;
    }

    public void setFlashType(String flashType) {
        this.flashType = flashType;
    }

    // Удобный метод для установки успешного сообщения
    public void setSuccessFlash(String message) {
        this.flash = message;
        this.flashType = "success";
    }

    // Удобный метод для установки сообщения об ошибке
    public void setErrorFlash(String message) {
        this.flash = message;
        this.flashType = "error";
    }
}
