package helper;

import database.InMemoryDatabase;
import dto.StudentDTO;

import java.util.Set;

public class DBHelper {

    private DBHelper() {
    }

    public static void generate(InMemoryDatabase imd) {
        for (int i = 0; i < 1000; i++) {
            imd.create(i, new StudentDTO("name" + i, "surname" + i));
        }
    }

    public static void print(InMemoryDatabase imd) {
        Set<Integer> keySet = imd.getKeys();
        for (Integer i : keySet) {
            System.out.println(imd.read(i));
        }
    }

    public static void remove(InMemoryDatabase imd) {
        for (int i = 0; i < imd.size(); i += 5)
            imd.delete(i);
    }

    public static void update(InMemoryDatabase imd) {
        for (int i = 0; i < imd.size(); i += 9)
            imd.update(i, new StudentDTO("XXXX" + i, "YYYY" + i));
    }

}
