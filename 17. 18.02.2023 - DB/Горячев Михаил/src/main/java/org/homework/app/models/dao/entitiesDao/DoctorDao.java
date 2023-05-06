package org.homework.app.models.dao.entitiesDao;
import org.homework.app.models.dao.BaseDao;
import org.homework.app.models.dao.entities.Appointment;
import org.homework.app.models.dao.entities.Doctor;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


// Интерфейс Доктор DAO
public interface DoctorDao extends BaseDao<Long, Doctor> {
    
}
