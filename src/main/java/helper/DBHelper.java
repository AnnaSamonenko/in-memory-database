package helper;

import database.InMemoryDatabase;
import dto.StudentDTO;

import java.util.Random;
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
        Random r = new Random();
        imd.delete(r.nextInt(imd.size()));
    }

    public static void update(InMemoryDatabase imd) {
        Random r = new Random();
        int i = r.nextInt(imd.size());
        imd.update(i, new StudentDTO("XXXX" + i, "YYYY" + i));
    }

}
