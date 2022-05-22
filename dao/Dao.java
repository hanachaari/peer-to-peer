package peer_to_peer.dao;

import java.util.List;

public interface Dao<T> {
    
    T get(int index);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(int index, T t);
    
    void delete(T t);
}
