package org.homework.app.models;

public class Speciality {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Speciality() {
    }

    public Speciality(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                "</tr>",
                id,
                name
        );
    }
}
