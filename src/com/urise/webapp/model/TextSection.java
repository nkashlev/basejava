package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {
    private final String textField;

    public TextSection(String textField) {
        this.textField = textField;
    }

    public String getTextField() {
        return textField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection textField1 = (TextSection) o;

        return Objects.equals(textField, textField1.textField);
    }

    @Override
    public int hashCode() {
        return textField != null ? textField.hashCode() : 0;
    }

        @Override
    public String toString() {
        return "TextSection{" +
                "textField='" + textField + '\'' +
                '}';
    }
}
