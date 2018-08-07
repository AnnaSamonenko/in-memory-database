package util;

import database.InMemoryDatabase;
import dto.StudentDTO;

public class DBUtil {

    public static void generate(InMemoryDatabase imd) {
        for (int i = 0; i < 10; i++) {
            imd.create(i, new StudentDTO("name" + i, "surname" + i));
        }
    }

    public static void print(InMemoryDatabase imd) {
        for (int i = 0; i < 10; i++) {
            System.out.println(imd.read(i));
        }
    }

}
