package app.models.dao.entities;

import app.models.dao.Entity;

import java.util.Objects;

public class Doctor extends Entity {
    public int id;
    public int personId;
    public String surname;
    public String name;
    public String patronymic;
    public int specialityId;
    public String specialityName;
    public int price;
    public int percent;
    
    
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

    
    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<th>%d</th>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td align='right'>%d</td>" +
                "<td align='right'>%d</td>" +
                "</tr>",
                id,
                surname,
                name,
                patronymic,
                specialityName,
                price,
                percent
        );
    }
}
