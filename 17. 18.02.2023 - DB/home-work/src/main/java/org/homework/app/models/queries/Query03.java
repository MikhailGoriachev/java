package org.homework.app.models.queries;


import java.sql.Date;

public class Query03 {
    
    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // дата приёма
    private Date appointmentDate;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // фамилия
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    // имя 
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // фамилия
    private String patronymic;

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    // название специальности
    private String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    // стоимость приёма
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // процент отчисления
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    // зарплата
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    // конструктор по умолчанию
    public Query03() {
    }

    // конструктор инициализирующий
    public Query03(
            int id,
            Date appointmentDate,
            String surname,
            String name,
            String patronymic,
            String specialityName,
            int price,
            int percent,
            double salary) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.specialityName = specialityName;
        this.price = price;
        this.percent = percent;
        this.salary = salary;
    }
}
