package org.homework.app.models.dao.entitiesDao;
import org.homework.app.models.dao.BaseDao;
import org.homework.app.models.dao.entities.Doctor;
import org.homework.app.models.dao.entities.Patient;

import java.util.List;


// Интерфейс Доктор DAO
public interface PatientDao extends BaseDao<Long, Patient> {

    // 1	Запрос с параметрами	Выбирает информацию о пациентах с фамилиями, начинающимися на заданную 
    //                              последовательность символов
    List<Patient> query01(String surnameStartWith) throws Exception;
}
