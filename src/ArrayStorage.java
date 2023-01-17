/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResume = 0;

    void clear() {
        for (int i = 0; i < countResume; i++) {
            storage[i] = null;
        }
        countResume = 0;
    }

    void save(Resume r) {
        storage[countResume] = r;
        countResume++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int indexForDelete;
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                indexForDelete = i;
                if (countResume - 1 - indexForDelete > 0) {
                    System.arraycopy(storage, indexForDelete + 1, storage, indexForDelete, countResume - 1 - indexForDelete);
                }
                countResume--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[countResume];
        System.arraycopy(storage, 0, allResume, 0, countResume);
        return allResume;
    }

    int size() {
        return countResume;
    }
}
