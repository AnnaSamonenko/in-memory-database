package helper;

import database.InMemoryDB;
import entity.StudentDTO;

import java.util.Random;
import java.util.Set;

public class DBHelper {

    private static final int INITIAL_SIZE = 10;
    private static Random r = new Random();

    private DBHelper() {
    }

    public static void generate(InMemoryDB imd) {
        for (int i = 0; i < INITIAL_SIZE; i++) {
            imd.create(i, new StudentDTO("name" + i, "surname" + i));
        }
    }

    public static void print(InMemoryDB imd) {
        Set<Integer> keySet = imd.getKeys();
        for (Integer i : keySet) {
            System.out.println(imd.read(i));
        }
    }

    public static void remove(InMemoryDB imd) {
        imd.delete(r.nextInt(imd.size()));
    }

    public static void read(InMemoryDB imd) {
        imd.read(r.nextInt(imd.size()));
    }

    public static void update(InMemoryDB imd) {
        int i = r.nextInt(imd.size());
        imd.update(i, new StudentDTO("XXXX" + i, "YYYY" + i));
    }

}
