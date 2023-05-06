package org.homework.app.models.dao.entitiesDaoImpl;

import org.homework.app.middleware.ConnectionCreator;
import org.homework.app.models.dao.entities.Patient;
import org.homework.app.models.dao.entitiesDao.PatientDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// Класс Доктор DAO реализация
public class PatientDaoImpl implements PatientDao {

    // все записи
    @Override
    public List<Patient> all() throws Exception {

        final String sql = "select * from view_patients";

        try (var state = ConnectionCreator.createConnection().createStatement()) {
            return toPatientList(state.executeQuery(sql));
        }
    }

    // поиск по id
    @Override
    public Patient find(Long id) throws Exception {
        final String sql = "select * from view_patients where id = ?";

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setLong(1, id);
            return toPatientList(state.executeQuery()).get(0);
        }
    }

    // создание записи
    @Override
    public boolean create(Patient patient) throws Exception {

        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        try (var state = connection.createStatement()) {

            final String sql = String.format(
                    "insert into patients (id_person, born_date, passport, address) values (%1$d, '%2$tY-%2$tm-%2$td', '%3$s', '%4$s')",
                    patient.personId,
                    patient.bornDate,
                    patient.passport,
                    patient.address
            );

            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }

        return true;
    }

    // изменение записи
    @Override
    public Patient update(Patient patient) throws Exception {
        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        try (var state = connection.createStatement()) {
            final String sql = String.format("update patients set id_person = %1$d, born_date = '%2$tY-%2$tm-%2$td', passport = '%3$s', address = '%4$s' where id = %5$d",
                    patient.personId,
                    patient.bornDate,
                    patient.passport,
                    patient.address,
                    patient.id
            );

            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
            return patient;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }

        return patient;
    }

    // удаление по записи
    @Override
    public boolean delete(Patient item) throws Exception {
        throw new UnsupportedOperationException();
    }

    // удаление по id
    @Override
    public boolean delete(Long id) throws Exception {
        throw new UnsupportedOperationException();
    }

    // 1	Запрос с параметрами	Выбирает информацию о пациентах с фамилиями, начинающимися на заданную 
    //                              последовательность символов
    public List<Patient> query01(String surnameStartWith) throws Exception {
        var sql = """
                select
                    *
                from
                    view_patients
                where
                    view_patients.patient_surname regexp concat('^', ?);
                """;

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setString(1, surnameStartWith);
            return toPatientList(state.executeQuery());
        }
    }

    // чтение данных о пациентах в коллекцию
    public List<Patient> toPatientList(ResultSet sqlResult) throws Exception {
        var collection = new ArrayList<Patient>();

        while (sqlResult.next()) {
            collection.add(new Patient(
                    sqlResult.getInt("id"),
                    sqlResult.getInt("id_person"),
                    sqlResult.getString("patient_surname"),
                    sqlResult.getString("patient_name"),
                    sqlResult.getString("patient_patronymic"),
                    sqlResult.getDate("born_date"),
                    sqlResult.getString("address"),
                    sqlResult.getString("passport")
            ));
        }

        return collection;
    }
}
