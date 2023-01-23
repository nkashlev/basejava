package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    private final String ERROR = "ERROR: was not found resume - ";

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size > storage.length) {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved storage is full");
        } else if (getIndex(resume.getUuid()) > -1) {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved was not found resume");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) > -1) {
            resume.setUuid("newUuid");
        } else {
            System.out.println(ERROR + resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) > -1) {
            return storage[getIndex(uuid)];
        } else {
            System.out.println(ERROR + uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int indexForDelete = getIndex(uuid);
        if (indexForDelete > -1) {
            if (size - 1 - indexForDelete > 0) {
                System.arraycopy(storage, indexForDelete + 1, storage, indexForDelete, size - 1 - indexForDelete);
            }
            size--;
        } else {
            System.out.println(ERROR + uuid);
        }
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
