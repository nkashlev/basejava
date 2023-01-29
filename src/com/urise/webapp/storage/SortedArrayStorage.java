package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveIndex(Resume resume, int index) {
        if (size == STORAGE_LIMIT) {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved storage is overflow");
        } else if (index < 0) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("ERROR: resume-" + resume.getUuid() + " cannot be saved was not found resume");
        }
    }

    @Override
    protected void deleteIndex(String uuid, int index) {
        if (index > -1) {
            if (size - 1 - index > 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            }
            size--;
        } else {
            System.out.println(ERROR + uuid);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


}
