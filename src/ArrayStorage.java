/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResume = 0;

    void clear() {
        int j = 0;
        while (j < countResume) {
            storage[j] = null;
            j++;
        }
        countResume = 0;
    }

    void save(Resume r) {
        storage[countResume] = r;
        countResume++;
    }

    Resume get(String uuidRef) {

        Resume res = null;

        for (int j = 0; j < countResume; j++) {
            if (storage[j].uuid.equals(uuidRef)) {
                res = storage[j];
                break;
            }
        }
        return res;
    }

    void delete(String uuidRef) {
        int numDelete = 0;
        for (int j = 0; j < countResume; j++) {
            if (storage[j].uuid.equals(uuidRef)) {
                numDelete = j;
                break;
            }
        }

        if (countResume - 1 - numDelete >= 0) {
            System.arraycopy(storage, numDelete + 1, storage, numDelete, countResume - 1 - numDelete);
        }
        countResume--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resultRes = new Resume[countResume];
        System.arraycopy(storage, 0, resultRes, 0, countResume);
        return resultRes;
    }

    int size() {
        return countResume;
    }
}
