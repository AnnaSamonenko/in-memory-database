import database.InMemoryDB;
import database.InMemoryDBImpl;
import helper.DBHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static final int AMOUNT_OF_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        final InMemoryDB imd = new InMemoryDBImpl();
        DBHelper.generate(imd);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Collection<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            tasks.add(() -> {
                DBHelper.remove(imd);
                return null;
            });
        }

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            tasks.add(() -> {
                DBHelper.update(imd);
                return null;
            });
        }

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
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
