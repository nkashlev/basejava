package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected void saveResume(Resume resume, int index) {

    }

    @Override
    protected void updateResume(Resume resume, int index) {

    }

    @Override
    protected void deleteResume(int index) {

    }

    @Override
    protected Resume getResume(int index) {
        return null;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }


    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
