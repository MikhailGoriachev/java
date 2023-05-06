package org.itstep.pd011;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// реализация DAO уровня метода - работа c таблицей abonents
public class AbonentDaoImpl implements AbonentDao {
    // типичная Java - тексты запросов в константах
    private static final String SQL_SELECT_ALL_ABONENTS =
            "SELECT id, surname_np, phone FROM phones";
    private static final String SQL_SELECT_ABONENT_BY_LASTNAME =
            "SELECT id, surname_np, phone FROM phones WHERE surname_np like ?";


    // получить абонентов по фамилии
    @Override
    public List<Abonent> findAbonentByLastname(String namePattern) throws DaoException {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ABONENT_BY_LASTNAME);
            statement.setString(1, namePattern);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("id"));
                abonent.setPhone(resultSet.getString("phone"));
                abonent.setName(resultSet.getString("surname_np"));
                abonents.add(abonent);
            } // while
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            // вызов реализаций по умолчанию
            close(statement);
            close(connection);
        } // try-catch-finally

        return abonents;
    } // findAbonentByLastname


    @Override
    public List<Abonent> findAll() throws DaoException {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            // получение соединения из фабрики соединенй
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while(resultSet.next()){
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("id"));
                abonent.setPhone(resultSet.getString("phone"));
                abonent.setName(resultSet.getString("surname_np"));
                abonents.add(abonent);
            } // while
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            // вызов реализаций по умолчанию
            close(statement);
            close(connection);
        }
        return abonents;
    } // findAll

    // методы, которые не нужны по логике работы, но мы обязаны их реализовать
    @Override
    public Abonent findEntityById(Long id) throws DaoException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean delete(Abonent abonent) throws DaoException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean delete(Long id) throws DaoException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean create(Abonent abonent) throws DaoException {
        throw new UnsupportedOperationException();
    }
    @Override
    public Abonent update(Abonent abonent) throws DaoException {
        throw new UnsupportedOperationException();
    }
} // class AbonentDaoImpl
