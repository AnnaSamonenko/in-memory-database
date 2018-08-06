import database.IMemoryDatabase;
import database.InMemoryDatabase;
import dto.StudentDTO;

public class Main {

    public static void main(String[] args)  throws InterruptedException {
        final IMemoryDatabase imd = new InMemoryDatabase();
        generate(imd);

        imd.delete(3);

        Thread th = new Thread(new Runnable() {
            public void run() {
                imd.delete(3);
            }
        });
        th.start();

        Thread th2 = new Thread(new Runnable() {
            public void run() {
                imd.read(3);
            }
        });

        th2.start();

        print(imd);
        th.join();
        th2.join();

    }

    static void generate(IMemoryDatabase imd) {
        for (int i = 0; i < 10; i++) {
            imd.create(i, new StudentDTO("name" + i, "surname" + i));
        }
    }

    static void print(IMemoryDatabase imd) {
        for (int i = 0; i < 10; i++) {
            System.out.println(imd.read(i));
        }
    }

}
