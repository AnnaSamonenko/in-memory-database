package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InMemoryDBImpl implements InMemoryDB {

    private Map<Integer, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public Object create(int key, Object object) {
        writeLock.lock();
        try {
            return map.put(key, object);
        } finally {
            writeLock.unlock();
        }
    }

    public Object read(Integer key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Object update(Integer key, Object object) {
        writeLock.lock();
        try {
            return map.put(key, object);
        } finally {
            writeLock.unlock();
        }

    }

    public Object delete(Integer key) {
        writeLock.lock();
        try {
            return map.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public Set<Integer> getKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public int size() {
        readLock.lock();
        try {
            return map.size();
        } finally {
            readLock.unlock();
        }
    }

}
