package database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabaseImpl implements InMemoryDatabase {

    private Map<Integer, Object> map = new ConcurrentHashMap<>();

    public void create(int key, Object object) {
        map.put(key, object);
    }

    public Object read(Integer key) {
        return map.get(key);
    }

    public void update(Integer key, Object object) {
        map.put(key, object);
    }

    public Object delete(Integer key) {
        return map.remove(key);
    }

}
