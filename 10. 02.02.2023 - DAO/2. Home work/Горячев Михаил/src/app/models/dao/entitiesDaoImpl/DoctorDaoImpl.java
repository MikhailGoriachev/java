package app.models.dao.entitiesDaoImpl;

import app.middleware.ConnectionCreator;
import app.models.dao.entities.Doctor;
import app.models.dao.entitiesDao.DoctorDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// Класс Доктор DAO реализация
public class DoctorDaoImpl implements DoctorDao {

    // все записи
    @Override
    public List<Doctor> all() throws Exception {

        final String sql = "select * from view_doctors";

        try (var state = ConnectionCreator.createConnection().createStatement()) {
            return toDoctorList(state.executeQuery(sql));
        }
    }

    // поиск по id
    @Override
    public Doctor find(Long id) throws Exception {
        final String sql = "select * from view_doctors where id = ?";

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setLong(1, id);
            return toDoctorList(state.executeQuery()).get(0);
        }
    }

    // создание записи
    @Override
    public boolean create(Doctor doctor) throws Exception {
        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        try (var state = connection.createStatement()) {
            final String sql = String.format(
                    "insert into doctors (id_person, id_speciality, price, percent) values (%d, %d, %d, %d)",
                    doctor.personId,
                    doctor.specialityId,
                    doctor.price,
                    doctor.percent
            );

            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
            return false;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }

        return true;
    }

    // изменение записи
    @Override
    public Doctor update(Doctor doctor) throws Exception {
        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        try (var state = connection.createStatement()) {

            final String sql = String.format(
                    "update doctors set id_person = %d, id_speciality = %d, price = %d, percent = %d where id = %d",
                    doctor.personId,
                    doctor.specialityId,
                    doctor.price,
                    doctor.percent,
                    doctor.id
            );
            
            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
            return doctor;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }

        return doctor;
    }

    // удаление по записи
    @Override
    public boolean delete(Doctor item) throws Exception {
        throw new UnsupportedOperationException();
    }

    // удаление по id
    @Override
    public boolean delete(Long id) throws Exception {
        throw new UnsupportedOperationException();
    }

    // 2	Запрос с параметрами	Выбирает информацию о врачах, для которых значение в поле Процент отчисления 
    //                              на зарплату, больше заданного
    public List<Doctor> query02(int percent) throws Exception {
        var sql = """
                select
                    *
                from
                    view_doctors
                where
                    view_doctors.percent > ?;
                """;

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setInt(1, percent);
            return toDoctorList(state.executeQuery());
        }
    }

    // 4	Запрос с параметрами	Выбирает из таблицы информацию о врачах с заданной специальностью
    public List<Doctor> query04(String speciality) throws Exception {
        var sql = """
                select
                    *
                from
                    view_doctors
                where
                    view_doctors.speciality_name like ?;
                """;

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setString(1, speciality);
            return toDoctorList(state.executeQuery());
        }
    }

    // чтение данных о врачах в коллекцию
    public List<Doctor> toDoctorList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Doctor>();

        while (sqlResult.next()) {
            collection.add(new Doctor(
                    sqlResult.getInt("id"),
                    sqlResult.getInt("id_person"),
                    sqlResult.getString("doctor_surname"),
                    sqlResult.getString("doctor_name"),
                    sqlResult.getString("doctor_patronymic"),
                    sqlResult.getInt("id_speciality"),
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("price"),
                    sqlResult.getInt("percent")
            ));
        }

        return collection;
    }
}
