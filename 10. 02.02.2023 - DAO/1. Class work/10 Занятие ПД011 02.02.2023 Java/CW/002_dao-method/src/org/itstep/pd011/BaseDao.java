package org.itstep.pd011;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// Базовые методы DAO
// K - тип для первичного ключа
// E - тип для сущности
public interface BaseDao <K, E extends Entity> {
	// {C}RUD
    boolean create(E e) throws DaoException;
	
	// C{R}UD
    List<E> findAll() throws DaoException;      // getAll()
    E findEntityById(K id) throws DaoException; // getById()

    // CR{U}D
    E update(E e) throws DaoException;

    // CRU{D}
    boolean delete(E e) throws DaoException;
    boolean delete(K id) throws DaoException;


    // закрытие оператора
    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // log
            System.err.println(e.getMessage());
        } // try-catch
    } // close

    // закрытие подключения
    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close(); // or connection return code to the pool
            }
        } catch (SQLException e) {
            // log
            System.err.println(e.getMessage());
        } // try-catch
    } // close
} // interface BaseDao
