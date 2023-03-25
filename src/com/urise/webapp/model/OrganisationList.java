package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganisationList extends Section {
    private final List<Organisation> organisationList;

    public OrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationList that = (OrganisationList) o;

        return Objects.equals(organisationList, that.organisationList);
    }

    @Override
    public int hashCode() {
        return organisationList != null ? organisationList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrganisationList{" +
                "organisationList=" + organisationList +
                '}';
    }
}
