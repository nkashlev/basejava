import com.urise.webapp.model.*;

import java.util.ArrayList;
import java.util.List;


public class ResumeTestData {
  /*  public static void main(String[] args) {
        resumeTestData("name1", "full name1");
    }

    private static void resumeTestData(String uuid, String fullName) {

        Resume resume = new Resume(uuid, fullName);


        for (ContactType type : ContactType.values()) {
            if (ContactType.SKYPE.equals(type)) {
                resume.getContacts().put(ContactType.SKYPE, "Skype: @skype");
            } else if (ContactType.PHONE.equals(type)) {
                resume.getContacts().put(ContactType.PHONE, "Тел.: +7(921)-855-04-82");
            } else if (ContactType.MAIL.equals(type)) {
                resume.getContacts().put(ContactType.MAIL, "Почта: @yandex.ru");
            } else if (ContactType.LINKEDIN.equals(type)) {
                resume.getContacts().put(ContactType.LINKEDIN, "https://www.linkedin.com");
            } else if (ContactType.GITHUB.equals(type)) {
                resume.getContacts().put(ContactType.GITHUB, "https://github.com");
            } else if (ContactType.STACKOVERFLOW.equals(type)) {
                resume.getContacts().put(ContactType.STACKOVERFLOW, "https://stackoverflow.com");
            } else {
                resume.getContacts().put(ContactType.HOME_PAGE, "https://hhhhhh.ru/");
            }
        }

        System.out.println(resume.getContacts().values());
        System.out.println();

        List<String> listAchievement = new ArrayList<>();
        listAchievement.add("Achievement #1");
        listAchievement.add("Achievement #2");
        listAchievement.add("Achievement #3");

        List<String> listQualification = new ArrayList<>();
        listQualification.add("Tomcat");
        listQualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listQualification.add("DB: Postgres, Oracle, MySQL");

        List<ListOrganization> listOrganizationsExperience1 = new ArrayList<>();
        listOrganizationsExperience1.add(new ListOrganization("09/2017", "01/2019", "инженер-разработчик", "Тестирование, отладка, внедрение ПО"));
        Organization organisation1 = new Organization("Компания1", "https://www.xxxxxxxxx.ru", listOrganizationsExperience1);

        List<ListOrganization> listOrganizationsExperience2 = new ArrayList<>();
        listOrganizationsExperience2.add(new ListOrganization("01/2019", "02/2022", "Разработчик ПО", "Разработка ПО"));
        Organization organisation2 = new Organization("Компания2", "https://www.xxxxxxxxxxx.com", listOrganizationsExperience2);

        List<Organization> listExperience = new ArrayList<>();
        listExperience.add(organisation1);
        listExperience.add(organisation2);


        List<ListOrganization> listOrganizationsEducation1 = new ArrayList<>();
        listOrganizationsEducation1.add(new ListOrganization("09/2003", "06/2014", "", "Закончил!"));
        List<Organization> listEducation = new ArrayList<>();
        listEducation.add(new Organization("Школа", "https://xxxxxx.ru/", listOrganizationsEducation1));

        List<ListOrganization> listOrganizationsEducation2 = new ArrayList<>();
        listOrganizationsEducation2.add(new ListOrganization("09/2014", "07/2018", "студент", ""));
        listOrganizationsEducation2.add(new ListOrganization("09/2020", "07/2022", "Инженер", ""));
        listEducation.add(new Organization("Национальный исследовательский университет информационных технологий", "https://xxxxx.ru/", listOrganizationsEducation2));


        for (SectionType type : SectionType.values()) {
            switch (type) {
                case PERSONAL ->
                        resume.getSections().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность"));

                case OBJECTIVE -> resume.getSections().put(SectionType.OBJECTIVE, new TextSection("Учусь"));

                case ACHIEVEMENT -> resume.getSections().put(SectionType.ACHIEVEMENT, new ListSection(listAchievement));

                case QUALIFICATION ->
                        resume.getSections().put(SectionType.QUALIFICATION, new ListSection(listQualification));

                case EXPERIENCE ->
                        resume.getSections().put(SectionType.EXPERIENCE, new OrganizationSection(listExperience));

                case EDUCATION ->
                        resume.getSections().put(SectionType.EDUCATION, new OrganizationSection(listEducation));

                default -> System.out.println("Введены некорректные данные");
            }
        }
        System.out.println(resume.getSections().values());

    }*/
}