package org.itstep.pd011.controllers;

import org.itstep.pd011.models.Person;
import org.itstep.pd011.utils.FileName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionController extends FileName {
    private List<Person> persons;

    public SolutionController(String fileName) {
        super(fileName);

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

    // вывод коллекции в файл формата CSV
    public void write(String path) throws IOException {

        List<String> lines = new ArrayList<>();
        persons.forEach(p -> lines.add(
            String.format(Locale.UK, "%s; %d; %.0f; %s", p.getName(), p.getAge(), p.getWeight(), p.getCity()))
        );

        Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
    } // write


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
