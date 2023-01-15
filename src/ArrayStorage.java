
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    static int i = 0;

    void clear() {
        int j = 0;
        while (storage[j] != null) {
            storage[j] = null;
            j++;
        }
        i = 0;
    }

    void save(Resume r) {
        storage[i] = r;
        i++;
    }

    Resume get(String uuidRef) {

        Resume res = null;

        for (int j = 0; j < storage.length - 1; j++) {
            if (storage[j] == null) {
                break;
            }
            if (storage[j].uuid.equals(uuidRef)) {
                res = storage[j];
                break;
            }
        }
        return res;
    }

    void delete(String uuidRef) {
        int numDelete = 0;
        for (int j = 0; j < storage.length - 1; j++) {
            if (storage[j].uuid.equals(uuidRef)) {
                numDelete = j;
                break;
            }
        }

        if (storage.length - 1 - numDelete >= 0) {
            System.arraycopy(storage, numDelete + 1, storage, numDelete, storage.length - 1 - numDelete);
        }

        i--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resultRes = new Resume[size()];
        int j = 0;
        while (j < size()) {
            resultRes[j] = storage[j];
            j++;
        }
        return resultRes;
    }

    int size() {
        int size = 0;
        while (storage[size] != null) {
            size++;
        }
        return size;
    }
}
