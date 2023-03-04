package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage.set((Integer) index, resume);
    }

    @Override
    protected void doDelete(Object index) {
        storage.remove(((Integer) index).intValue());
    }

    @Override
    protected Resume doGet(Object index) {
        return storage.get((Integer) index);
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage);
    }


    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}

