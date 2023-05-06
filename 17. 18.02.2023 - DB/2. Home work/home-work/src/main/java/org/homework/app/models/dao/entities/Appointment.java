package org.homework.app.models.dao.entities;

import org.homework.app.models.dao.Entity;

import java.sql.Date;

// Класс Приём
public class Appointment extends Entity {
    public int id;
    public Date appointmentDate;
    public int doctorId;
    public String doctorSurname;
    public String doctorName;
    public String doctorPatronymic;
    public String specialityName;
    public int price;
    public int percent;
    public int patientId;
    public String patientSurname;
    public String patientName;
    public String patientPatronymic;
    public Date bornDate;
    public String address;
    public String passport;

    
    // конструктор по умолчанию
    public Appointment() {
    }

    // конструктор инициализирующий
    public Appointment(
            int id,
            Date appointmentDate,
            int doctorId,
            String doctorSurname,
            String doctorName,
            String doctorPatronymic,
            String specialityName,
            int price,
            int percent,
            int patientId,
            String patientSurname,
            String patientName,
            String patientPatronymic,
            Date bornDate,
            String address,
            String passport) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
        this.doctorSurname = doctorSurname;
        this.doctorName = doctorName;
        this.doctorPatronymic = doctorPatronymic;
        this.specialityName = specialityName;
        this.price = price;
        this.percent = percent;
        this.patientId = patientId;
        this.patientSurname = patientSurname;
        this.patientName = patientName;
        this.patientPatronymic = patientPatronymic;
        this.bornDate = bornDate;
        this.address = address;
        this.passport = passport;
    }


    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<th>%d</th>" +
                "<td>%2$td.%2$tm.%2$tY</td>" +
                "<td>%3$s</td>" +
                "<td>%4$s</td>" +
                "<td>%5$s</td>" +
                "<td>%6$s</td>" +
                "<td align='right'>%7$d</td>" +
                "<td align='right'>%8$d</td>" +
                "<td>%9$s</td>" +
                "<td>%10$s</td>" +
                "<td>%11$s</td>" +
                "<td>%12$td.%12$tm.%12$tY</td>" +
                "<td>%13$s</td>" +
                "</tr>",
                id,
                appointmentDate,
                doctorSurname,
                doctorName,
                doctorPatronymic,
                specialityName,
                price,
                percent,
                patientSurname,
                patientName,
                patientPatronymic,
                bornDate,
                passport
        );
    }
}
