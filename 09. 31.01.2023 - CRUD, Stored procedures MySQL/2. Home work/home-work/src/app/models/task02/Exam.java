package app.models.task02;


import java.util.Date;

// Класс Экзамен
public record Exam(
        int id,
        String academicSubjectName,
        int examTypeId,
        String examTypeName,
        int examinerId,
        String examinerLastName,
        String examinerFirstName,
        String examinerPatronymic,
        int examinerExamFee,
        int studentId,
        String studentLastName,
        String studentFirstName,
        String studentPatronymic,
        String studentsAddress,
        int studentYearOfBirth,
        String studentPassport,
        Date date,
        int score
) {
    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<th>%1$d</th>" +
                "<td>%2$s</td>" +
                "<td>%3$s</td>" +
                "<td>%4$s %5$s. %6$s.</td>" +
                "<td align='right'>%7$d</td>" +
                "<td>%8$s %9$s. %10$s.</td>" +
                "<td>%11$s</td>" +
                "<td>%12$d</td>" +
                "<td>%13$s</td>" +
                "<td>%14$td.%14$tm.%14$tY</td>" +
                "<td align='right'>%15$d</td>" +
                "</tr>",
                id,
                academicSubjectName,
                examTypeName,
                examinerLastName,
                examinerFirstName.charAt(0),
                examinerPatronymic.charAt(0),
                examinerExamFee,
                studentLastName,
                studentFirstName.charAt(0),
                studentPatronymic.charAt(0),
                studentsAddress,
                studentYearOfBirth,
                studentPassport,
                date,
                score
        );
    }

    // вывод персоны в строку таблицы
    public String toTableRowWithTaxAndSalary() {
        return String.format(
                "<tr>" +
                "<th>%1$d</th>" +
                "<td>%2$s</td>" +
                "<td>%3$s</td>" +
                "<td>%4$s %5$s. %6$s.</td>" +
                "<td align='right'>%7$d</td>" +
                "<td>%8$s %9$s. %10$s.</td>" +
                "<td>%11$s</td>" +
                "<td>%12$d</td>" +
                "<td>%13$s</td>" +
                "<td>%14$td.%14$tm.%14$tY</td>" +
                "<td align='right'>%15$d</td>" +
                "<td align='right'>%16$.2f</td>" +
                "<td align='right'>%17$.2f</td>" +
                "</tr>",
                id,
                academicSubjectName,
                examTypeName,
                examinerLastName,
                examinerFirstName.charAt(0),
                examinerPatronymic.charAt(0),
                examinerExamFee,
                studentLastName,
                studentFirstName.charAt(0),
                studentPatronymic.charAt(0),
                studentsAddress,
                studentYearOfBirth,
                studentPassport,
                date,
                score,
                tax(),
                salary()
        );
    }

    // налог (Налог=Размер оплаты*13%)
    public double tax() {
        return examinerExamFee * 0.13;
    }

    // зарплата (Зарплата=Размер оплаты - Налог)
    public double salary() {
        return examinerExamFee - tax();
    }
}
