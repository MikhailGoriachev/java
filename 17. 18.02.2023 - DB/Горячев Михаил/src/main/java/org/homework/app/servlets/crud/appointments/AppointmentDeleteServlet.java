package org.homework.app.servlets.crud.appointments;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.models.dao.entities.Appointment;
import org.homework.app.models.dao.entitiesDaoImpl.AppointmentDaoImpl;
import org.homework.app.utils.Utils;

import java.sql.Date;

@WebServlet("/crud/appointments/delete")
public class AppointmentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            new AppointmentDaoImpl().delete(Long.parseLong(req.getParameter("id")));
            
            resp.sendRedirect(req.getContextPath() + "/tables/appointments");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            var surname = req.getParameter("startSurname");
            req.setAttribute("startSurname", surname);
            
            var item = new Appointment();
            
            item.setId(Integer.parseInt(req.getParameter("id")));
            item.setDoctorId(Integer.parseInt(req.getParameter("idDoctor")));
            item.setPatientId(Integer.parseInt(req.getParameter("idPatient")));
            item.setAppointmentDate((Date) Utils.parseFormDate(req.getParameter("appointmentDate")));

            new AppointmentDaoImpl().update(item);
            
            resp.sendRedirect(req.getContextPath() + "/tables/appointments");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
