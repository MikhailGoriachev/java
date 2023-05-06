package app.models.dao.entitiesDao;
import app.models.dao.BaseDao;
import app.models.dao.entities.Doctor;
import app.models.dao.entities.Patient;

import java.util.List;


// Интерфейс Доктор DAO
public interface PatientDao extends BaseDao<Long, Patient> {

    // 1	Запрос с параметрами	Выбирает информацию о пациентах с фамилиями, начинающимися на заданную 
    //                              последовательность символов
    List<Patient> query01(String surnameStartWith) throws Exception;
}
