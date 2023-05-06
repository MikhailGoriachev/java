package app.models.task02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// Класс Список людей
public class PeopleList {

    // коллекция персон
    public List<Person> personList;

    // название файла данных
    public final String SAVE_FILE_NAME = "app_data/people.csv";


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


    // выбрать жителей заданного города с заданным диапазоном возраста
    public List<Person> selectByCityAndAgeRange(String city, int min, int max) {
        return personList
                .stream()
                .filter(a -> a.city.equals(city) && a.age >= min && a.age <= max)
                .toList();
    }

    // выбрать жителей с заданной фамилией
    public List<Person> selectBySurname(String surname) {
        return personList
                .stream()
                .filter(a -> a.surname.equals(surname))
                .toList();
    }

    // выбрать города, в которых есть жители с заданной фамилией
    public List<String> selectCitiesBySurname(String surname) {
        return personList
                .stream()
                .filter(a -> a.surname.equals(surname))
                .map(a -> a.city)
                .distinct()
                .toList();
    }

    // выбрать города, в которых есть жители с заданным диапазоном роста
    public List<String> selectCitiesByHeightRange(int min, int max) {
        return personList
                .stream()
                .filter(a -> a.height >= min && a.height <= max)
                .map(a -> a.city)
                .distinct()
                .toList();
    }

    // вывести список городов, упорядоченный по алфавиту
    public List<String> citiesOrderBy() {
        return personList
                .stream()
                .map(a -> a.city)
                .distinct()
                .sorted()
                .toList();
    }

    // вывести список жителей, упорядоченный по алфавиту
    public List<Person> orderByFullName() {
        return personList
                .stream()
                .sorted(Comparator.comparing(a -> a.surname + a.name))
                .toList();
    }

    // вывести список жителей, упорядоченный по убыванию возраста
    public List<Person> orderByAgeDesc() {
        return personList
                .stream()
                .sorted((a, b) -> Integer.compare(b.age, a.age))
                .toList();
    }

    // вывести список жителей по росту
    public List<Person> orderByHeight() {
        return personList
                .stream()
                .sorted(Comparator.comparing(a -> a.height))
                .toList();
    }

    // добавить жителя
    public void addPerson(Person person) throws IOException {
        person.id = !personList.isEmpty()
                ? personList.stream().max(Comparator.comparing(p -> p.id)).get().id + 1
                : 1;

        personList.add(person);
        saveData(personList);
    }

    // удалить жителя
    public void removePerson(int index) throws IOException {
        personList.remove(index);
        saveData(personList);
    }

    // запись данных в файл
    public void saveData(List<Person> people) throws IOException {
        Files.writeString(Path.of(SAVE_FILE_NAME),
                personList
                        .stream()
                        .map(Person::toCsv)
                        .reduce("", (prev, cur) -> prev + cur)
        );
    }

    // чтение данных из файла
    public boolean loadData() throws IOException {

        var path = Path.of(SAVE_FILE_NAME);

        if (!Files.exists(path))
            return false;

        personList = Files
                .readAllLines(path)
                .stream()
                .map(Person::getFromCsv)
                .collect(Collectors.toList()); // если использовать .toList(), то будет immutable коллекция

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
                .append("<th>Рост (см)</th>")
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
