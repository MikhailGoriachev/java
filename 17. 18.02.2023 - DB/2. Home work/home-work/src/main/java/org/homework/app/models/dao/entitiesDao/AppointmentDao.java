package org.homework.app.models.dao.entitiesDao;
import org.homework.app.models.dao.BaseDao;
import org.homework.app.models.dao.entities.Appointment;

import java.util.Date;
import java.util.List;

// Интерфейс Приёмы DAO
public interface AppointmentDao extends BaseDao<Long, Appointment> {
    // 3	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    List<Appointment> query03(Date dateBegin, Date dateEnd) throws Exception;
    
}
