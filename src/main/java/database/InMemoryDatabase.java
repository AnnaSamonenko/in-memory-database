package database;

import java.util.Set;

public interface InMemoryDatabase {

    Object create(int counter, Object object);

    Object read(Integer key);

    Object update(Integer key, Object object);

    Object delete(Integer key);

    Set getKeys();

    int size();

}
