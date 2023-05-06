package app.models.task01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static app.models.task01.Person.loadFromBinData;

/*
    Задача 1. Для коллекции жителей некоторых городов (фамилия, имя, возраст, название города, профессия, оклад)
    cоставьте и выполните запросы к коллекции с использованием StreamAPI. Храните коллекцию в текстовом файле 
    в формате CSV:
        1. статистика по городам – название городов, количество жителей из этих городов в коллекции, средний возраст, 
            минимальный возраст, максимальный возраст жителя
        2. жители с заданной профессией, фамилия которых начинается с заданной строки 
        3. список фамилий и жители с такой фамилией
        4. список профессий и жители с такой профессией
        5. список городов по убыванию количества проживающих в них людей
        6. статистика по профессиям – количество жителей с заданной профессией, минимальный оклад, средний оклад, 
            максимальный оклад, сумма окладов
        7. среднее количество жителей города и города с количеством жителей ниже среднего
*/

// Класс Список людей
public class PeopleList {

    // коллекция персон
    public List<Person> personList;

    // название файла данных
    public final String SAVE_FILE_NAME = "app_data/people.bin";

    // конструктор по умолчанию
    public PeopleList() throws IOException {
        if (!loadData())
            saveData(this.personList = IntStream.range(1, 13).mapToObj(Person::factory).toList());
    }

    // конструктор инициализирующий
    public PeopleList(List<Person> personList) throws IOException {
        this.personList = personList;

        saveData(this.personList);
    }


    // получить список фамилий
    public List<String> surnameList() {
        return personList
                .stream()
                .map(Person::surname)
                .distinct()
                .toList();
    }

    // получить список профессий
    public List<String> professionList() {
        return personList
                .stream()
                .map(Person::surname)
                .distinct()
                .toList();
    }

    // 1. статистика по городам – название городов, количество жителей из этих городов в коллекции, средний возраст,
    // минимальный возраст, максимальный возраст жителя
    public Map<String, IntSummaryStatistics> point01() {
        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.summarizingInt(Person::age)));
    }

    // вывод пункта 1
    public static String point01ToTable(Map<String, IntSummaryStatistics> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Город</th>")
                .append("<th>Минимальный возраст</th>")
                .append("<th>Средний возраст</th>")
                .append("<th>Максимальный возраст</th>")
                .append("<th>Количество</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        data.forEach((k, v) -> sb
                .append("<tr><td>").append(k).append("</td>")
                .append("<td align='right'>").append(v.getMin()).append("</td>")
                .append("<td align='right'>").append(v.getAverage()).append("</td>")
                .append("<td align='right'>").append(v.getMax()).append("</td>")
                .append("<td align='right'>").append(v.getCount()).append("</td></tr>"));


        sb.append("</tbody></table>");

        return sb.toString();
    }

    // 2. жители с заданной профессией, фамилия которых начинается с заданной строки 
    public List<Person> point02(String profession, String startSurname) {
        return personList.stream()
                .filter(p -> p.profession().equals(profession) && p.surname().startsWith(startSurname))
                .toList();
    }

    // 3. список фамилий и жители с такой фамилией
    public Map<String, List<Person>> point03() {
        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::surname));
    }

    // вывод пункта 3
    public static String point03ToTable(Map<String, List<Person>> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th rowspan='2'>Фамилия группы</th>")
                .append("<th colspan='7'>Персоны</th>")
                .append("</tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Город</th>")
                .append("<th>Возраст (год)</th>")
                .append("<th>Профессия</th>")
                .append("<th>Оклад (&#8381;)</th>")
                .append("</tr>")
                .append("</thead><tbody>");


        data.forEach((k, v) -> {
            sb.append("<tr><td rowspan='").append(v.size()).append("'>").append(k).append("</td>");

            var first = v.get(0);

            sb.append(String.format(
                    "<th>%d</th><td>%s</td><td>%s</td><td>%s</td><td align='right'>%d</td><td>%s</td><td align='right'>%d</td>",
                    first.id(), first.surname(), first.name(), first.city(), first.age(), first.profession(), first.salary()));

            if (v.size() > 1) {
                v.stream().skip(1).forEach(c -> sb.append(c.toTableRow()));
            } else
                sb.append("</tr>");
        });


        sb.append("</tbody></table>");

        return sb.toString();
    }

    // 4. список профессий и жители с такой профессией
    public Map<String, List<Person>> point04() {
        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::profession));
    }

    // вывод пункта 4
    public static String point04ToTable(Map<String, List<Person>> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th rowspan='2'>Профессия группы</th>")
                .append("<th colspan='7'>Персоны</th>")
                .append("</tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Город</th>")
                .append("<th>Возраст (год)</th>")
                .append("<th>Профессия</th>")
                .append("<th>Оклад (&#8381;)</th>")
                .append("</tr>")
                .append("</thead><tbody>");


        data.forEach((k, v) -> {
            sb.append("<tr><td rowspan='").append(v.size()).append("'>").append(k).append("</td>");

            var first = v.get(0);

            sb.append(String.format(
                    "<th>%d</th><td>%s</td><td>%s</td><td>%s</td><td align='right'>%d</td><td>%s</td><td align='right'>%d</td>",
                    first.id(), first.surname(), first.name(), first.city(), first.age(), first.profession(), first.salary()));

            if (v.size() > 1) {
                v.stream().skip(1).forEach(c -> sb.append(c.toTableRow()));
            } else
                sb.append("</tr>");
        });

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // 5. список городов по убыванию количества проживающих в них людей
    public List<Map.Entry<String, Long>> point05() {
        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .toList();
    }

    // вывод пункта 5
    public static String point05ToTable(List<Map.Entry<String, Long>> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Город</th>")
                .append("<th>Количество жителей</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        data.forEach(d -> sb
                .append("<tr><td>").append(d.getKey()).append("</td>")
                .append("<td align='right'>").append(d.getValue()).append("</td></tr>"));


        sb.append("</tbody></table>");

        return sb.toString();
    }

    // 6. статистика по профессиям – количество жителей с заданной профессией, минимальный оклад, средний оклад,
    // максимальный оклад, сумма окладов
    public Map<String, IntSummaryStatistics> point06() {
        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::profession, Collectors.summarizingInt(Person::salary)));
    }

    // вывод пункта 6
    public static String point06ToTable(Map<String, IntSummaryStatistics> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Профессия</th>")
                .append("<th>Количество жителей</th>")
                .append("<th>Минимальный оклад (&#8381;)</th>")
                .append("<th>Средний оклад (&#8381;)</th>")
                .append("<th>Максимальный оклад (&#8381;)</th>")
                .append("<th>Сумма окладов (&#8381;)</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        data.forEach((k, v) -> sb
                .append("<tr><td>").append(k).append("</td>")
                .append("<td align='right'>").append(v.getCount()).append("</td>")
                .append("<td align='right'>").append(v.getMin()).append("</td>")
                .append("<td align='right'>").append(v.getAverage()).append("</td>")
                .append("<td align='right'>").append(v.getMax()).append("</td>")
                .append("<td align='right'>").append(v.getSum()).append("</td></tr>"));


        sb.append("</tbody></table>");

        return sb.toString();
    }

    // среднее количество жителей
    public double avgAmountPeople() {
        var result = personList
                .stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.counting()))
                .entrySet();

        return result
                .stream()
                .mapToLong(Map.Entry::getValue)
                .average()
                .getAsDouble();
    }

    // 7. среднее количество жителей города и города с количеством жителей ниже среднего
    public List<Map.Entry<String, Long>> point07() {
        var result = personList
                .stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.counting()))
                .entrySet();

        var avg = result
                .stream()
                .mapToLong(Map.Entry::getValue)
                .average()
                .getAsDouble();

        return result
                .stream()
                .filter(e -> e.getValue() < avg)
                .toList();
    }

    // вывод пункта 7
    public static String point07ToTable(List<Map.Entry<String, Long>> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Город</th>")
                .append("<th>Среднее количество жителей</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        data.forEach(d -> sb
                .append("<tr><td>").append(d.getKey()).append("</td>")
                .append("<td align='right'>").append(d.getValue()).append("</td></tr>"));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // запись данных в файл
    public void saveData(List<Person> people) throws IOException {
        try (var stream = new DataOutputStream(new FileOutputStream(SAVE_FILE_NAME))) {
            personList.forEach(p -> p.saveToBinData(stream));
        }
    }

    // чтение данных из файла
    public boolean loadData() throws IOException {

        var path = Path.of(SAVE_FILE_NAME);

        if (!Files.exists(path))
            return false;

        personList = new ArrayList<>();
        
        try (var stream = new DataInputStream(new FileInputStream(SAVE_FILE_NAME))) {
            while (stream.available() > 0) {
                personList.add(Person.loadFromBinData(stream));
            }
        }

        return true;
    }

    // вывод данных о людях в таблицу
    public static String peopleToTable(Collection<Person> people) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Город</th>")
                .append("<th>Возраст (год)</th>")
                .append("<th>Профессия</th>")
                .append("<th>Оклад (&#8381;)</th>")
                .append("</thead><tbody>");

        people.forEach(p -> sb.append(p.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о людях в таблицу
    public static String citiesToTable(Collection<String> cities) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Название</th>")
                .append("</thead><tbody>");

        cities.forEach((p) -> sb.append("<tr><td>").append(p).append("</td></tr>"));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
