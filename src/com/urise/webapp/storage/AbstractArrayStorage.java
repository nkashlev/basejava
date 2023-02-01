package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;
    protected final String ERROR = "ERROR: was not found resume - ";

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved storage is overflow");
        } else if (index < 0) {
            saveIndex(index, resume);
            size++;
        } else {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved was not found resume");
        }
    }

    protected abstract void saveIndex(int index, Resume resume);

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println(ERROR + resume.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            deleteIndex(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println(ERROR + uuid);
        }
    }

    protected abstract void deleteIndex(int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        } else {
            System.out.println(ERROR + uuid);
            return null;
        }
    }

    protected abstract int getIndex(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}
