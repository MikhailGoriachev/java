package org.homework.app.models.dao.entitiesDaoImpl;

import org.homework.app.middleware.ConnectionCreator;
import org.homework.app.models.dao.entities.Appointment;
import org.homework.app.models.dao.entitiesDao.AppointmentDao;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Класс Приём DAO реализация
public class AppointmentDaoImpl implements AppointmentDao {

    // все записи
    @Override
    public List<Appointment> all() throws Exception {

        final String sql = "select * from view_appointments";

        try (var state = ConnectionCreator.createConnection().createStatement()) {
            return toAppointmentList(state.executeQuery(sql));
        }
    }

    // поиск по id
    @Override
    public Appointment find(Long id) throws Exception {
        final String sql = "select * from view_appointments where id = ?";

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setLong(1, id);
            return toAppointmentList(state.executeQuery()).get(0);
        }
    }

    // создание записи
    @Override
    public boolean create(Appointment appointment) throws Exception {
        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        try (var state = connection.createStatement()) {
            final String sql = String.format(
                    "insert into appointments (appointment_date, id_patient, id_doctor) values ('%1$tY-%1$tm-%1$td', %2$d, %3$d)",
                    appointment.appointmentDate,
                    appointment.patientId,
                    appointment.doctorId
            );

            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }

        return true;
    }

    // изменение записи
    @Override
    public Appointment update(Appointment appointment) throws Exception {
        var connection = ConnectionCreator.createConnection();

        connection.setAutoCommit(false);

        System.out.printf("%1$tY-%1$tm-%1$td%n", appointment.appointmentDate);
        
        try (var state = connection.createStatement()) {
            final String sql = String.format(
                    "update appointments set appointment_date = '%1$tY-%1$tm-%1$td', id_patient = %2$d, id_doctor = %3$d where id = %4$d",
                    appointment.appointmentDate,
                    appointment.patientId,
                    appointment.doctorId,
                    appointment.id
            );

            state.executeUpdate(sql);

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }

        return appointment;
    }

    // удаление по записи
    @Override
    public boolean delete(Appointment item) throws Exception {
        final String sql = "delete from appointments where id = ?";

        try (var connection = ConnectionCreator.createConnection();
             var state = connection.prepareStatement(sql)) {

            state.setLong(1, item.id);

            state.executeQuery();
        }


        return true;
    }

    // удаление по id
    @Override
    public boolean delete(Long id) throws Exception {
        final String sql = "delete from appointments where id = ?";

        try (var connection = ConnectionCreator.createConnection();
             var state = connection.prepareStatement(sql)) {

            state.setLong(1, id);

            state.executeQuery();
        }

        return true;
    }

    // 3	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    public List<Appointment> query03(Date dateBegin, Date dateEnd) throws Exception {
        var sql = """
                select
                    *
                from
                    view_appointments
                where
                    view_appointments.appointment_date between ? and ?;
                """;

        try (var state = ConnectionCreator.createConnection().prepareStatement(sql)) {
            state.setString(1, String.format("%1$tY-%1$tm-%1$td", dateBegin));
            state.setString(2, String.format("%1$tY-%1$tm-%1$td", dateEnd));
            return toAppointmentList(state.executeQuery());
        }
    }

    // чтение данных о приёмах в коллекцию
    public List<Appointment> toAppointmentList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Appointment>();

        while (sqlResult.next()) {
            collection.add(new Appointment(
                    sqlResult.getInt("id"),
                    sqlResult.getDate("appointment_date"),
                    sqlResult.getInt("id_doctor"),
                    sqlResult.getString("doctor_surname"),
                    sqlResult.getString("doctor_name"),
                    sqlResult.getString("doctor_patronymic"),
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("price"),
                    sqlResult.getInt("percent"),
                    sqlResult.getInt("id_patient"),
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
