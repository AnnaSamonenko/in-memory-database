package database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase implements IMemoryDatabase {

    private Map<Integer, Object> map = new ConcurrentHashMap();
    // int counter;

    public void create(int counter, Object object) {
        map.put(counter, object);
    }

    public Object read(Integer key) {
        return map.get(key);
    }

    public void update(Integer key, Object object) {
        map.put(key, object);
    }

    public void delete(Integer key) {
        map.remove(key);
    }

}
