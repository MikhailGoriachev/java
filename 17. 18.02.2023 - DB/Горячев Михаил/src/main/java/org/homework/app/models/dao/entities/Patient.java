package org.homework.app.models.dao.entities;

import org.homework.app.models.dao.Entity;

import java.sql.Date;

public class Patient extends Entity {
    
    // id
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // id персоны
    public int personId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    // фамилия
    public String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // имя
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // отчество
    public String patronymic;

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
    public Patient() {
    }
    
    // конструктор инициализирующий
    public Patient(
            int id,
            int personId,
            String surname,
            String name,
            String patronymic,
            Date bornDate,
            String address,
            String passport) {
        this.id = id;
        this.personId = personId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.bornDate = bornDate;
        this.address = address;
        this.passport = passport;
    }
}
