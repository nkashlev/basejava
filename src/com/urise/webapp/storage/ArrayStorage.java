package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveIndex(Resume resume, int index) {
        if (size == STORAGE_LIMIT) {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved storage is overflow");
        } else if (index == -1) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved was not found resume");
        }
    }

    @Override
    protected void deleteIndex(String uuid, int index) {
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println(ERROR + uuid);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
