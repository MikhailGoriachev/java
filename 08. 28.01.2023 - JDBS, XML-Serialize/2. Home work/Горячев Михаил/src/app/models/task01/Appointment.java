package app.models.task01;

import java.util.Date;

// Класс Приём
public record Appointment(
        int id,
        Date appointmentDate,
        String doctorSurname,
        String doctorName,
        String doctorPatronymic,
        String specialityName,
        int price,
        int percent,
        String patientSurname,
        String patientName,
        String patientPatronymic,
        Date bornDate,
        String address,
        String passport) {


    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%2$td.%2$tm.%2$tY</td>" +
                        "<td>%3$s</td>" +
                        "<td>%4$s</td>" +
                        "<td>%5$s</td>" +
                        "<td>%6$s</td>" +
                        "<td align='right'>%7$d</td>" +
                        "<td align='right'>%8$d</td>" +
                        "<td>%9$s</td>" +
                        "<td>%10$s</td>" +
                        "<td>%11$s</td>" +
                        "<td>%12$td.%12$tm.%12$tY</td>" +
                        "<td>%13$s</td>" +
                "</tr>",
                id,
                appointmentDate,
                doctorSurname,
                doctorName,
                doctorPatronymic,
                specialityName,
                price,
                percent,
                patientSurname,
                patientName,
                patientPatronymic,
                bornDate,
                passport
        );
    }
}
