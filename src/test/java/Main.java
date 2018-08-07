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

        for (int i = 0; i < 25; i++) {
            tasks.add(() -> {
                DBHelper.remove(imd);
                return null;
            });
        }

        for (int i = 0; i < 25; i++) {
            tasks.add(() -> {
                DBHelper.update(imd);
                return null;
            });
        }

        System.out.println(tasks.size());

        executorService.invokeAll(tasks);
        DBHelper.print(imd);
        executorService.shutdown();
    }

}
