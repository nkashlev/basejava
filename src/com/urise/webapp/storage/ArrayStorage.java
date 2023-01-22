package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    private final String ERROR = "ERROR: was not found resume - ";

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if ((size >= 0) && (size <= storage.length)) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved");
        }
    }

    public void update(Resume resume) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (size > 0) {
            try {
                resume.setUuid(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(ERROR + resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        check(uuid);
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        check(uuid);
        int indexForDelete;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                indexForDelete = i;
                if (size - 1 - indexForDelete > 0) {
                    System.arraycopy(storage, indexForDelete + 1, storage, indexForDelete, size - 1 - indexForDelete);
                }
                size--;
            }
        }
    }

    public void check(String uuid) {
        if (size <= 0) {
            System.out.println(ERROR + uuid);
        }
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
