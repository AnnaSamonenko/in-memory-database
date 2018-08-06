package database;

public interface IMemoryDatabase {

    void create(int counter, Object object);

    Object read(Integer key);

    void update(Integer key, Object object);

    void delete(Integer key);

}
