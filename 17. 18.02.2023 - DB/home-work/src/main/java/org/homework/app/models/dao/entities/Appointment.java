package org.homework.app.models.dao.entities;

import org.homework.app.models.dao.Entity;

import java.util.Date;

// Класс Приём
public class Appointment extends Entity {
    
    // id 
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // дата приёма
    public Date appointmentDate;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // id доктора
    public int doctorId;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    // фамилия доктора
    public String doctorSurname;

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    // имя доктора
    public String doctorName;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // отчество доктора
    public String doctorPatronymic;

    public String getDoctorPatronymic() {
        return doctorPatronymic;
    }

    public void setDoctorPatronymic(String doctorPatronymic) {
        this.doctorPatronymic = doctorPatronymic;
    }

    // название специальности
    public String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    // стоимость приёма
    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // процент отчисления врачу
    public int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    // id пациента
    public int patientId;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    // фамилия доктора
    public String patientSurname;

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    // имя доктора
    public String patientName;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // отчество доктора
    public String patientPatronymic;

    public String getPatientPatronymic() {
        return patientPatronymic;
    }

    public void setPatientPatronymic(String patientPatronymic) {
        this.patientPatronymic = patientPatronymic;
    }

    // дата рождения
    public Date bornDate;

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    // адрес
    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // паспорт
    public String passport;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

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
}
