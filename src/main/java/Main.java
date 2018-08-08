import database.InMemoryDatabase;
import database.InMemoryDatabaseImpl;
import helper.DBHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final InMemoryDatabase imd = new InMemoryDatabaseImpl();
        DBHelper.generate(imd);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Collection<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            tasks.add(() -> {
                DBHelper.remove(imd);
                return null;
            });
        }

        for (int i = 0; i < 50; i++) {
            tasks.add(() -> {
                DBHelper.update(imd);
                return null;
            });
        }

        for (int i = 0; i < 50; i++) {
            tasks.add(() -> {
                DBHelper.read(imd);
                return null;
            });
        }

        executorService.invokeAll(tasks);
        DBHelper.print(imd);
        System.out.println(imd.size());
        executorService.shutdown();
    }

}
