package com.urise.webapp.model;

public enum ContactType {
    PHONE("���."),
    SKYPE("Skype"),
    MAIL("email"),
    LINKEDIN("LinkedIn"),
    GITHUB("Github"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("�������� ��������");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
