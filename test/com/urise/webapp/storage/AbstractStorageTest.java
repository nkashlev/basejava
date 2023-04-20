package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public abstract class AbstractStorageTest {
    protected final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    private static final String UUID_NOT_EXIST = "dummy";

    static {
        RESUME_1 = new Resume(UUID_1, "Pushkin");
        RESUME_2 = new Resume(UUID_2, "Lermontov");
        RESUME_3 = new Resume(UUID_3, "Tolstoi");
        RESUME_4 = new Resume(UUID_4, "Dostoevskiy");
        RESUME_1.addContact(ContactType.MAIL, "mail1@ya.ru");
        RESUME_1.addContact(ContactType.PHONE, "11111");
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        RESUME_1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        RESUME_1.addSection(SectionType.QUALIFICATION, new ListSection("Java", "SQL", "JavaScript"));
        RESUME_1.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization("Organization11", "http://Organization11.ru", new Organization.Period(2005, Month.JANUARY, "position1", "content1"), new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        RESUME_1.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization("Institute", null, new Organization.Period(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null), new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")), new Organization("Organization12", "http://Organization12.ru")));
        RESUME_1.addContact(ContactType.SKYPE, "skype2");
        RESUME_2.addContact(ContactType.PHONE, "22222");
        RESUME_1.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization("Organization2", "http://Organization2.ru", new Organization.Period(2015, Month.JANUARY, "position1", "content1"))));
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        assertEquals(0, storage.getAllSorted().size());
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    public void saveAlreadyExist() {
        Throwable exception = assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
        {
            assertEquals("Resume uuid1 already exist", exception.getMessage());
        }
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_2, " new Lermontov");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_2));
    }

    @Test
    public void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
    }

    @Test
    public void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void getAllSorted() {
        List<Resume> expected = storage.getAllSorted();
        for (int i = 0; i < 3; i++) {
            assertEquals(expected.get(i), storage.getAllSorted().get(i));
        }
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}