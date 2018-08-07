package database;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabaseImpl implements InMemoryDatabase {

    private Map<Integer, Object> map = new ConcurrentHashMap<>();

    public Object create(int key, Object object) {
        return map.put(key, object);
    }

    public Object read(Integer key) {
        return map.get(key);
    }

    public Object update(Integer key, Object object) {
        return map.put(key, object);
    }

    public Object delete(Integer key) {
        return map.remove(key);
    }

    public Set<Integer> getKeys() {
        return map.keySet();
    }

    public int size() {
        return map.size();
    }

}
