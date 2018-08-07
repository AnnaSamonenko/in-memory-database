package database;

public interface InMemoryDatabase {

    void create(int counter, Object object);

    Object read(Integer key);

    void update(Integer key, Object object);

    Object delete(Integer key);

}
