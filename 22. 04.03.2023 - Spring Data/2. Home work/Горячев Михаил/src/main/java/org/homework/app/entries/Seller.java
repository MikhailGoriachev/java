package org.homework.app.entries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Продавец
@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // персона
    @ManyToOne
    private Person person;
    
    // процент комиссии
    @Column(name = "interest")
    private int interest;

    
    // вывод с троку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s</td><td>%d</td></tr>",
                id,
                person.getSurname(),
                person.getName(),
                person.getPatronymic(),
                interest
        );
    }

    // вывод html таблицы
    public static String toTableHtml(List<Seller> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='4'>")
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
                .append("<th>Процент комиссии</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
