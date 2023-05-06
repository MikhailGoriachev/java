package app.models.dao;

import java.util.List;

// Интерфейс Базовый DAO
// K - ключ
// E - сущность
public interface BaseDao<K, E extends Entity> {

    // добавление
    boolean create(E e) throws Exception;
    
    // редактирование
    E update(E e) throws Exception;
    
    // удаление по записи
    boolean delete(E e) throws Exception;
    
    // удаление по ключу
    boolean delete(K id) throws Exception;
    
    // все записи
    List<E> all() throws Exception;      
    
    // поиск записи по id
    E find(K id) throws Exception;
    
} // interface BaseDao
