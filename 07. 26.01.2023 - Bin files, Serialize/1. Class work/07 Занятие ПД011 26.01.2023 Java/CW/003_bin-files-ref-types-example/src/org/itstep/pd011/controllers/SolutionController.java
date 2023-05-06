package org.itstep.pd011.controllers;

import org.itstep.pd011.models.Appliance;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionController {
    // Имя папки для хранения файлов
    private String dirName = "data";

    // имя файла для хранения данных по электроприборам
    private String fileName;

    // коллекция приборов (м.б. произвольные объекты)
    List<Appliance> applianceList;

    public SolutionController() {
        this("data", "appliance.bin");
    } // SolutionController
    public SolutionController(String dirName, String fileName) {

        check(dirName);
        check(fileName);

        // присваивание корректных значений имен файлов
        this.dirName   = dirName;
        this.fileName = fileName;

        // создание папки, если еще нет
        File dir = new File(dirName);
        if (!dir.exists()) dir.mkdir();

        applianceList = new ArrayList<>();

        // если файла с электроприборами нет, создание файла,
        // иначе читаем коллекцию из файла
        String pathName = dirName + "/" + fileName;
        if (!(new File(pathName).exists())) {
            initialize();
        } else {
            readFromFile();
        } // if
    } // SolutionController

    // чтение из бинарного файла в коллекцию applianceLisr
    private void readFromFile() {
        String pathName = dirName + "/" + fileName;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            while (dis.available() > 0) {
                Appliance appliance = new Appliance();  // создать объект
                appliance.read(dis);                    // читать из файла его поля
                applianceList.add(appliance);           // добавить объект в колекцию

                // альтернативный вариант - требует открыть больше информации об объекте
                // надо сделать public буфер строк Appliance.LEN_NAME, Appliance.LEN_BRAND
                // String name = Files.readString(dis, Appliance.LEN_NAME);
                // String brand = Files.readString(dis, Appliance.LEN_BRAND);
                // double power = dis.readDouble();
                // boolean state = dis.readBoolean();
                // applianceList.add(new Appliance(name, brand, power, state));
            } // while
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // readFromFile

    // начальное создание файла данных, содержащего сведения об электроприборах
    // заодно заполним коллекцию электроприборов
    private void initialize() {
        applianceList.addAll(Arrays.asList(
            new Appliance("светильник", "Phillips", 300, false),
            new Appliance("светильник", "МакСвет", 300, true),
            new Appliance("светильник", "ГорСвет", 200, false),
            new Appliance("светильник", "ГорСвет", 200, false),
            new Appliance("электрочайник", "Elite", 1900, true),
            new Appliance("светильник", "Phillips", 250, false),
            new Appliance("ночник", "Akai", 15, false),
            new Appliance("ионизатор", "МакСвет", 15, false),
            new Appliance("светильник", "ГорСвет", 500, false),
            new Appliance("обогреватель", "Сибиряк", 2100, false),
            new Appliance("микроволновка", "Phillips", 1800, false),
            new Appliance("стиральная машина", "Samsung", 2100, true),
            new Appliance("бойлер", "Samsung", 2100, false),
            new Appliance("распред. щиток", "Akai", 50, true),
            new Appliance("миксер", "Phillips", 600, false),
            new Appliance("утюг", "Samsung", 1200, false)
        ));

        // последовательная запись коллекции в бинарный файл
        writeToFile();
    } // initilize

    // запись коллекции в файл, при каждом вызове файл пересоздается
    private void writeToFile() {
        String pathName = dirName + "/" + fileName;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathName))) {

            // собственно запись коллекции приборов в файл
            for(Appliance appliance: applianceList)
                appliance.write(dos);
        } catch (Exception ex) {
            System.out.printf("\n\033[31;1mОшибка \"%s\" при записи в файл %s\n\033[0m", ex.getMessage(), pathName);
        } // try-catch
    } // writeToFile

    // проверка строки на допустимость - не пустая строка, не null
    private void check(String name) {
        if (name == null) throw new IllegalArgumentException("Имя не может быть null");
        if (name.isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
    } // check


    // вывести электроприборы из коллекции в консоль
    public void showAppliance(String title) {
        // формируем строку - таблицу приборов и выводим ее в консоль
        StringBuilder sbr = new StringBuilder(title);
        sbr
           .append(Appliance.SPLITTER)
           .append(Appliance.HEADER)
           .append(Appliance.SPLITTER);

        for(Appliance appliance: applianceList) {
            // включенные приборы выделяем цветом фона и полужирным шрифтом
            if (appliance.isState()) sbr.append("\033[47;1m");
            sbr.append(appliance.toTableRow()).append("\033[0m\n");
        } // while

        // вывод в консоль
        System.out.println(sbr.append(Appliance.SPLITTER));
    } // showAppliance

    // добавить электроприбор в коллекцию электроприборов и в файл данных
    public void addAppliance() {
        Appliance appliance = new Appliance();
        appliance.input();

        applianceList.add(appliance);
        addToFile(appliance);
    } // addAppliance

    // добавить прибор appliance в бинарный файл
    private void addToFile(Appliance appliance) {
        String pathName = dirName + "/" + fileName;
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            raf.seek(raf.length());  // перейти в конец файла
            appliance.write(raf);    // добавить данные в файл
        } catch (Exception ex) {
            System.out.printf("\n\033[31;1mОшибка \"%s\" при добавлении в файл %s\n\033[0m", ex.getMessage(), pathName);
        } // try-catch
    } // addToFile


    // упорядочить электроприборы в файле данных по возрастанию мощности
    public void orderByPower() {
        // сортировка по заданию
        applianceList.sort(Comparator.comparingDouble(Appliance::getPower));

        // сохранить новую коллекцию
        writeToFile();
    } // orderByPower

} // class SolutionController
