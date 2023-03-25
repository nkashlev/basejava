import com.urise.webapp.model.*;
import java.util.ArrayList;
import java.util.List;


public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid1", "Григорий Кислин");

        for (ContactType type : ContactType.values()) {
            if (ContactType.SKYPE.equals(type)) {
                resume.getContacts().put(ContactType.SKYPE, "Skype: skype:grigory.kislin");
            } else if (ContactType.PHONE.equals(type)) {
                resume.getContacts().put(ContactType.PHONE, "Тел.: +7(921) 855-0482");
            } else if (ContactType.MAIL.equals(type)) {
                resume.getContacts().put(ContactType.MAIL, "Почта: gkislin@yandex.ru");
            } else if (ContactType.LINKEDIN.equals(type)) {
                resume.getContacts().put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
            } else if (ContactType.GITHUB.equals(type)) {
                resume.getContacts().put(ContactType.GITHUB, "https://github.com/gkislin");
            } else if (ContactType.STACKOVERFLOW.equals(type)) {
                resume.getContacts().put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
            } else {
                resume.getContacts().put(ContactType.HOME_PAGE, "https://gkislin.ru/");
            }
        }

        System.out.println(resume.getContacts().values());
        System.out.println();

        List<String> listAchievement = new ArrayList<>();
        listAchievement.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: "  + "\n" + "приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        listAchievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA). Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.\"");



        List<String> listQualification = new ArrayList<>();
        listQualification.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        listQualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listQualification.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");




        Organisation organisation1 = new Organisation("Alcatel", "https://www.alcatel.ru",  "09/1997", "01/2005", "\n" +
                "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Organisation organisation2 = new Organisation("Siemens AG", "https://www.siemens.com/global/en.html",  "01/2005", "02/2007", "\n" +
                "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");

        List<Organisation> listExperience = new ArrayList<>();
        listExperience.add(organisation1);
        listExperience.add(organisation2);

        List<Organisation> listEducation = new ArrayList<>();
        listEducation.add(new Organisation("Заочная физико-техническая школа при МФТИ", "https://mipt.ru/", "09/1984", "06/1987", "", "Закончил с отличием"));
        listEducation.add(new Organisation("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/", "09/1993", "07/1996", "Аспирантура (программист С, С++)", ""));


        for (SectionType type : SectionType.values()) {
            switch (type) {
                case PERSONAL -> resume.getSections().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

                case OBJECTIVE -> resume.getSections().put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям."));

                case ACHIEVEMENT -> resume.getSections().put(SectionType.ACHIEVEMENT, new SectionList(listAchievement));

                case QUALIFICATION -> resume.getSections().put(SectionType.QUALIFICATION , new SectionList(listQualification));

                case EXPERIENCE -> resume.getSections().put(SectionType.EXPERIENCE , new OrganisationList(listExperience));

                case EDUCATION -> resume.getSections().put(SectionType.EDUCATION, new OrganisationList(listEducation));

                default -> System.out.println("Введены некорректные данные");
            }
        }
        System.out.println(resume.getSections().values());
    }
}