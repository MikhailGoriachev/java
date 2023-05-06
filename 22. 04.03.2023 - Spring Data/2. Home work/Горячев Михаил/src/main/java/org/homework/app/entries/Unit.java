package org.homework.app.entries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Единица измерения
@Entity
@Table(name = "units")
@Getter
@Setter
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // сокращенное название
    @Column(name = "short")
    private String shortName;
    
    // полное название
    @Column(name = "long")
    private String longName;

    
    // вывод с троку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td></tr>",
                id,
                longName,
                shortName
        );
    }

    // вывод html таблицы
    public static String toTableHtml(List<Unit> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='2'>")
                .append(title)
                .append("</th>")
                .append("<th>")
                .append("Количество:").append(list.size())
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Полное название</th>")
                .append("<th>Сокращённое название</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
