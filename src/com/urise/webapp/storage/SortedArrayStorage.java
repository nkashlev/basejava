package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveIndex(int index, Resume resume) {
        int saveIndex = -index - 1;
        System.arraycopy(storage, saveIndex, storage, saveIndex + 1, size - saveIndex);
        storage[saveIndex] = resume;
    }

    @Override
    protected void deleteIndex(int index) {
        if (size - 1 - index > 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
