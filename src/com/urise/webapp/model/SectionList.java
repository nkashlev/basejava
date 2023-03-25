package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;
public class SectionList extends Section {
    private final List<String> items;

    public SectionList(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionList groupList = (SectionList) o;

        return Objects.equals(items, groupList.items);
    }

    @Override
    public int hashCode() {
        return items != null ? items.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SectionList{" +
                "items=" + items +
                '}';
    }
}
