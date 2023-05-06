package org.homework.app.models.dao.entities;

import org.homework.app.models.dao.Entity;


public class Doctor extends Entity {
    
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
    
    // персона
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

    // id специальности
    public int specialityId;

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
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

    // процент отчисления доктору
    public int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    

    // конструктор по умолчанию
    public Doctor() {
    }

    // конструктор инициализирующий
    public Doctor(
            int id,
            int personId,
            String surname,
            String name,
            String patronymic,
            int specialityId,
            String specialityName,
            int price,
            int percent) {
        this.id = id;
        this.personId = personId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.specialityId = specialityId;
        this.specialityName = specialityName;
        this.price = price;
        this.percent = percent;
    }
}
