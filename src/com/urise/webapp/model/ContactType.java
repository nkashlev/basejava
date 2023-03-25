package com.urise.webapp.model;

public enum ContactType {
    PHONE("Тел."),
    SKYPE("Skype"),
    MAIL("email"),
    LINKEDIN("LinkedIn"),
    GITHUB("Github"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
