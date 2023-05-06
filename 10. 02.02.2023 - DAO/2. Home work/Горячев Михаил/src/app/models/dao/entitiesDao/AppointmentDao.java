package app.models.dao.entitiesDao;
import app.models.dao.BaseDao;
import app.models.dao.entities.Appointment;

import java.util.Date;
import java.util.List;

// Интерфейс Приёмы DAO
public interface AppointmentDao extends BaseDao<Long, Appointment> {
    // 3	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    List<Appointment> query03(Date dateBegin, Date dateEnd) throws Exception;
    
}
