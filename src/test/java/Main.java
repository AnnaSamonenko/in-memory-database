import database.InMemoryDatabase;
import database.InMemoryDatabaseImpl;
import util.DBUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        final InMemoryDatabase imd = new InMemoryDatabaseImpl();
        DBUtil.generate(imd);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable task1 = new Callable() {
            public Object call() {
                return imd.delete(3);
            }
        };

        Callable task2 = new Callable() {
            public Object call() {
                return imd.read(3);
            }
        };

        Collection<Callable> tasks = Arrays.asList(new Callable[]
                {task1, task2});


        tasks.add(task1);
        tasks.add(task2);
        executorService.invokeAll(tasks);

        DBUtil.print(imd);
    }

}
