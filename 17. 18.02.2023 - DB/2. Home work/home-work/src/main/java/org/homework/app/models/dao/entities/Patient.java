package org.homework.app.models.dao.entities;

import org.homework.app.models.dao.Entity;

import java.sql.Date;

public final class Patient extends Entity {
    public int id;
    public int personId;
    public String surname;
    public String name;
    public String patronymic;
    public Date bornDate;
    public String address;
    public String passport;

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

    
    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<th>%d</th>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%5$td.%5$tm.%5$tY</td>" +
                "<td>%6$s</td>" +
                "<td>%7$s</td>" +
                "</tr>",
                id,
                surname,
                name,
                patronymic,
                bornDate,
                address,
                passport
        );
    }
}
