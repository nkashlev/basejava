package com.urise.webapp.util;

import com.urise.webapp.model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class ResumeTestData {
    public static void main(String[] args) {
        resumeShow("name1", "full name1");
    }

    public static Resume resumeTestData(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.addContact(ContactType.MAIL, "mail1@ya.ru");
        resume.addContact(ContactType.PHONE, "11111");
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        resume.addSection(SectionType.QUALIFICATION, new ListSection("Java", "SQL", "JavaScript"));
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization("Organization11", "http://Organization11.ru", new Organization.Period(2005, Month.JANUARY, "position1", "content1"), new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        resume.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization("Institute", null, new Organization.Period(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null), new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")), new Organization("Organization12", "http://Organization12.ru")));
        resume.addContact(ContactType.SKYPE, "skype2");
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization("Organization2", "http://Organization2.ru", new Organization.Period(2015, Month.JANUARY, "position1", "content1"))));
        return resume;
    }

    private static void resumeShow(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        for (ContactType type : ContactType.values()) {
            if (ContactType.SKYPE.equals(type)) {
                resume.addContact(ContactType.SKYPE, "Skype: @skype");
            } else if (ContactType.PHONE.equals(type)) {
                resume.addContact(ContactType.PHONE, "Тел.: +7(921)-855-04-82");
            } else if (ContactType.MAIL.equals(type)) {
                resume.addContact(ContactType.MAIL, "Почта: @yandex.ru");
            } else if (ContactType.LINKEDIN.equals(type)) {
                resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com");
            } else if (ContactType.GITHUB.equals(type)) {
                resume.addContact(ContactType.GITHUB, "https://github.com");
            } else if (ContactType.STACKOVERFLOW.equals(type)) {
                resume.addContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com");
            } else {
                resume.addContact(ContactType.HOME_PAGE, "https://hhhhhh.ru/");
            }
            System.out.println(resume.getContact(type));
        }
        System.out.println();

        List<String> listAchievement;
        listAchievement = new ArrayList<>();
        listAchievement.add("Achievement #1");
        listAchievement.add("Achievement #2");
        listAchievement.add("Achievement #3");

        List<String> listQualification = new ArrayList<>();
        listQualification.add("Tomcat");
        listQualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listQualification.add("DB: Postgres, Oracle, MySQL");


        List<Organization> listOrganizationsExperience = new ArrayList<>();
        listOrganizationsExperience.add(new Organization("Компания1", "https://www.xxxxxxxxx.ru", new Organization.Period(2018, Month.JULY, 2019, Month.MARCH, "Разработчик ПО1", "Разработка ПО1"),
                new Organization.Period(2019, Month.MARCH, 2020, Month.OCTOBER, "title", "description")));
        listOrganizationsExperience.add(new Organization("Компания2", "https://www.xxxxxxxxxxx.com", new Organization.Period(2020, Month.NOVEMBER, 2021, Month.OCTOBER, "Разработчик ПО2", "Разработка ПО2")));

        List<Organization> listOrganizationsEducation = new ArrayList<>();
        listOrganizationsEducation.add(new Organization("Школа", "https://www.SHxxxxxxxx.ru", new Organization.Period(2003, Month.SEPTEMBER, 2014, Month.MAY, "ученик", "-----")));
        listOrganizationsEducation.add(new Organization("Университет", "https://www.Vxxxxxxxxx.ru", new Organization.Period(2014, Month.SEPTEMBER, 2018, Month.MAY, "студент", "бакалавр"),
                new Organization.Period(2018, Month.SEPTEMBER, 2020, Month.MAY, "студент", "магистр")));

        for (SectionType type : SectionType.values()) {
            switch (type) {
                case PERSONAL ->
                        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность"));

                case OBJECTIVE -> resume.addSection(SectionType.OBJECTIVE, new TextSection("стажер"));

                case ACHIEVEMENT -> resume.addSection(SectionType.ACHIEVEMENT, new ListSection(listAchievement));

                case QUALIFICATION -> resume.addSection(SectionType.QUALIFICATION, new ListSection(listQualification));

                case EXPERIENCE ->
                        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(listOrganizationsExperience));

                case EDUCATION ->
                        resume.addSection(SectionType.EDUCATION, new OrganizationSection(listOrganizationsEducation));

                default -> System.out.println("Введены некорректные данные");
            }
            System.out.println(resume.getSection(type));
        }
    }
}