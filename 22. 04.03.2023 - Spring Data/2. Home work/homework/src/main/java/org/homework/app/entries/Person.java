package org.homework.app.entries;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// Класс Персона
@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    // фамилия
    @Column(name = "surname", length = 60)
    private String surname;
    
    // имя
    @Column(name = "name", length = 50)
    private String name;
    
    // отчество
    @Column(name = "patronymic", length = 60)
    private String patronymic;
    
    // паспорт
    @Column(name = "passport", length = 15)
    private String passport;

    
    // вывод с троку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s</td></tr>",
                id,
                surname,
                name,
                patronymic
        );
    }

    // вывод html таблицы
    public static String toTableHtml(List<Person> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='3'>")
                .append(title)
                .append("</th>")
                .append("<th>")
                .append("Количество:").append(list.size())
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
