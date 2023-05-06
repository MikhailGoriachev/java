package org.homework.app.models.dao.entitiesDao;
import org.homework.app.models.dao.BaseDao;
import org.homework.app.models.dao.entities.Appointment;
import org.homework.app.models.dao.entities.Doctor;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


// Интерфейс Доктор DAO
public interface DoctorDao extends BaseDao<Long, Doctor> {

    // 2	Запрос с параметрами	Выбирает информацию о врачах, для которых значение в поле Процент отчисления 
    //                              на зарплату, больше заданного
    List<Doctor> query02(int percent) throws Exception;
    
    // 4	Запрос с параметрами	Выбирает из таблицы информацию о врачах с заданной специальностью
    List<Doctor> query04(String speciality) throws Exception;
}
