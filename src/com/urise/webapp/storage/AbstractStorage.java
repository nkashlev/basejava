package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

}
