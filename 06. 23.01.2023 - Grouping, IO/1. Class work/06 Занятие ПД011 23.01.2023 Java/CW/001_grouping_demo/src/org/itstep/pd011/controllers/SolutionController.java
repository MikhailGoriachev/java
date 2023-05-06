package org.itstep.pd011.controllers;

import org.itstep.pd011.models.Person;
import org.itstep.pd011.utils.FileName;
import org.itstep.pd011.utils.Utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionController {
    private List<Person> persons;

    private String fileName;

    // геттер/сеттер для имени файла
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) {
        if (!Utils.isValidFile(fileName))
            throw new InvalidParameterException(
                    String.format("\"%s\" не является корректным именем файла", fileName));
        this.fileName = fileName;
    } // setFileName

    public SolutionController(String fileName) {
        this.fileName = fileName;

        persons = new ArrayList<>();
        load(fileName);  // загрузка коллекции из файла в формате CSV
    } // Solution

    // загрузка данных из файла в формате CSV
    private void load(String fileName) {
        List<String> text = null;
        persons.clear();  // формируем новую коллекцию

        try {
            // читаем текстовый файл одной операцией
            text = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

            // для каждой строки - разбить строку на токены, сформировать объект класса Person
            text.forEach(str -> persons.add(parsePerson(str)));
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // load

    // фабричный метод - формируем объект Person из строки файла данных
    private Person parsePerson(String str) {
        String[] tokens = str.split("; ");
        return new Person(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
    } // parsePerson

    // Запросы для демонстрации группировки ------------------------------------------

    // Сгруппировать людей по городам проживания
    // Вывести города группировки
    // Вывести людей, проживающих в каждом городе группировки

    // Для группировки - метод Collectors.groupingBy() из метода collect(), который создает словарь
    // ключ     - поле группировки
    // значение - задается пользователем/программистом, значением м.б. скаляр или коллекция
    public void query01() {
        //  Пары ключ    ->    значение
        //  город              список персон
        //  ключ группировки
        Map<String, List<Person>> personsByCity = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getCity));

        System.out.println("\nСписок городов нашей коллекции:");
        // минимальный результат - вывести города группировки
        for (var city : personsByCity.keySet()) {
           System.out.printf("%s\n", city);
        } // foreach

        System.out.println("\nСписок городов нашей коллекции и проживающие в них персоны:");

        // более сложный вариант вывода - и города и список людей,
        // в них проживающих
        // for (Map.Entry<String, List<Person>> entry : personsByCity.entrySet()) {
        for (var entry : personsByCity.entrySet()) {
            // вывести город
            System.out.printf("\033[34;1m%s\033[0m\n", entry.getKey());

            // getValue() - список Person
            for (Person person : entry.getValue()) {
                System.out.printf("\t\t%s, возраст: %d\n", person.getName(), person.getAge());
            } // for entry
        } // for entrySet

    } // query01

    // Группировка по возрасту, вывести состав возрастных групп, количество персон
    // в возрастных группах
    public void query02() {
        // Группировка по возрасту - для получения списка персон, входящих в группировку
        Map<Integer, List<Person>> personsByAge = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getAge));

        // Группировка по возрасту - для получения количества персон в группировке
        // !!! groupingBy() имеет перегруженные варианты
        // !!! первый параметр это поле группировки,
        // !!! второй параметр - обработка.
        // В данном случае обработка - это счетчик

        //  возраст  количество в группе
        Map<Integer, Long> personsByAgeCount = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        System.out.println("\nГруппировка по возрасту:");

        // Вывод результата - в одном цикле по двум коллекциям - эти коллекции
        // имеют одинаковый набор ключей - т.е. связь 1:1
        // personsByAge  --- personsByAgeCount
        // for (Map.Entry<Integer, List<Person>> entry : personsByAge.entrySet()) {
        for (var entry : personsByAge.entrySet()) {
            // вывести возраст и количество
            int age = entry.getKey();

            System.out.printf("Возраст в годах: %d, количество в категории: %d\n",
                age, personsByAgeCount.get(age)); // метод get() - получить значение для ключа группы
            // конечно, так менее эффективно, но мы должны продемонстрировать работу с группировкой
            // для агрегатных функций
            // age, entry.getValue().size()); // метод get() - получить значение для ключа группы

            // Вывести состав возрастной категории
            List<Person> personList = entry.getValue();
            for (Person person : personList) {
                System.out.printf("\t\t%s; %.2f кг; %s\n",
                person.getName(), person.getWeight(), person.getCity());
            } // person

            System.out.println();
        } // personsByAge
    } // query02


    // Вывести суммарный вес персон по городам
    // обрабатывающий метод - summingDouble
    public void query03() {
        //  ключ    значение
        //  город   суммарный вес, поле типа double в Person
        Map<String, Double> personsByCityWeight = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.summingDouble(Person::getWeight)));

        System.out.print("\nСуммарный вес по городам:\n");
        // for (Map.Entry<String, Double> entry : personsByCityWeight.entrySet()) {
        for (var entry : personsByCityWeight.entrySet()) {
            System.out.printf("Город %s -- суммарный вес %.2f кг\n", entry.getKey(), entry.getValue());
        } // for entry
    } // query03

    // Найти самого легкого, самого тяжелого и самого старого в городе
    // методы Collectors.maxBy, Collectors.minBy
    public void query04() {
        // коллекция с персонами имеющими минимальный вес по городам
        //  ключ    значение
        //  город   специальный тип для min, max
        Map<String, Optional<Person>> personsMinByCity = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getCity,
                    Collectors.minBy(Comparator.comparing(Person::getWeight)))
            );

        // коллекция с персонами имеющими максимальный вес по городам
        //  ключ    значение
        //  город   специальный тип для min, max
        Map<String, Optional<Person>> personsMaxByCity = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getCity,
                     Collectors.maxBy(Comparator.comparing(Person::getWeight)))
            );

        // коллекция с персонами имеющими максимальный возраст по городам
        Map<String, Optional<Person>> personsOldestByCity = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.maxBy(Comparator.comparing((Person::getAge))))
        );

        System.out.println("\nСамый легкий, самый тяжелый, самый старый по городам");
        // вывод результата одним циклом - т.к. три коллекции связаны 1:1 по ключу
        // группировки  -  название города
        for (Map.Entry<String, Optional<Person>> entry : personsMinByCity.entrySet()) {
            // метод get() - возвращает значение из типа Optional
            Person min = entry.getValue().get();                       // самый лекгий

            //  самый тяжелый выбирается из другой коллекции по ключу - названию города
            String cityKey =  entry.getKey();
            Person max = personsMaxByCity.get(cityKey).get();       // самый тяжелый
            Person oldest = personsOldestByCity.get(cityKey).get(); // самый старый
            System.out.printf("%s: %.2f кг - %s; %.2f кг - %s; %d лет - %s\n",
                cityKey, // город
                min.getWeight(), min.getName(),    // самый легкий - вес, имя
                max.getWeight(), max.getName(),    // самый тяжелый - вес, имя
                oldest.getAge(), oldest.getName()  // самый старыи - возраст, имя
            );
        } // for entry
    } // query04

    // Вывод суммарной (итоговой) статистики по весу при группировке персон по городу
    // количество персон в городе, суммарный, минимальный, средний, максимальный вес
    //
    // 2-й параметр группировки Collectors.summarizingТип() - создает объект
    // типа ТипSummaryStatistics
    // Объект содержит пять значений (аналог агрегатных функций)
    //    getSum()     - сумма
    //    getCount()   - количество
    //    getAverage() - среднее
    //    getMin()     - минимальное
    //    getMax()     - максимальное
    public void query05() {
        //  ключ    значение
        //  город   итоговая статистика
        Map<String, DoubleSummaryStatistics> weightStatisticsByCity = persons
            .stream()
            .collect(
                Collectors.groupingBy(Person::getCity,             // группа по городам
                Collectors.summarizingDouble(Person::getWeight))   // статистика по весу
            );
        System.out.println("\nСтатистика - вес по городам");
        String SPLITTER = "+—————————————————+————————+———————————————+————————————————+————————————————+———————————————+\n";
        String HEADER   = "| Город           | Кол-во | Общий вес, кг | Миним. вес, кг | Средн. вес, кг | Макс. вес, кг |\n";

        System.out.print(SPLITTER + HEADER + SPLITTER);

        // for (Map.Entry<String, DoubleSummaryStatistics> entry : weightStatisticsByCity.entrySet()) {
        for (var entry : weightStatisticsByCity.entrySet()) {
            DoubleSummaryStatistics value = entry.getValue();  // ключ - значение
            System.out.printf("| %-15s | %6d | %13.2f | %14.2f | %14.2f | %13.2f |\n",
                 entry.getKey(),       // ключ группировки - город
                 value.getCount(),     // количество
                 value.getSum(),       // сумма
                 value.getMin(),       // минимум
                 value.getAverage(),   // среднее
                 value.getMax()        // максимум
            );
        } // for entry
        System.out.print(SPLITTER);
    } // query05


    // Вывод суммарной (итоговой) статистики по возрасту при группировке персон по городу
    // количество персон в городе, суммарный, минимальный, средний, максимальный возраст
    public void query06() {
        Map<String, IntSummaryStatistics> ageStatisticsByCity = persons
            .stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.summarizingInt(Person::getAge))
        );

        // for (Map.Entry<String, IntSummaryStatistics> entry : ageStatisticsByCity.entrySet()) {
        for (var entry : ageStatisticsByCity.entrySet()) {
            IntSummaryStatistics value = entry.getValue();
            System.out.printf(Locale.UK, "%s %d %d %d %d %.2f\n",
                    entry.getKey(),
                    value.getCount(),
                    value.getMin(),
                    value.getSum(),
                    value.getMax(),
                    value.getAverage() );
        }
    } // query06


    // --------------------------------------------------------------------------------


    // возвращает строку, содержащую таблицу результатов
    @Override public String toString() {
        StringBuffer  sbf = new StringBuffer(Person.header());

        persons  // формируем строку при помощи потока данных
            .stream()
            .forEach(p -> sbf.append(p).append("\n"));
        sbf.append(Person.footer());

        return sbf.toString();
    } // toString
}
