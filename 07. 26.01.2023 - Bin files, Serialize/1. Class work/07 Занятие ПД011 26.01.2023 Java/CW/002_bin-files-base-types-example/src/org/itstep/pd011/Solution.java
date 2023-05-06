package org.itstep.pd011;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    // Имя файла для хранения счетчика вызовов задачи task3()
    private final String RUN_TASK3_COUNTER = "runCounter.bin";

    // Имя папки для хранения файлов
    private String dirName = "data";

    // имена файлов для решения задач
    private String fileName1;
    private String fileName2;
    private String fileName3;

    public Solution() {
        this("data", "task1.bin", "task2.bin", "task3.bin");
    } // Solution
    public Solution(String dirName, String fileName1, String fileName2, String fileName3) {

        // проверка корректности параметров
        check(dirName);
        check(fileName1);
        check(fileName2);
        check(fileName3);

        // присваивание корректных значений
        this.dirName   = dirName;
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        this.fileName3 = fileName3;

        // создание папки, если еще нет
        File dir = new File(dirName);
        if (!dir.exists()) dir.mkdir();

        // создание файла данных для задачи 1
        // Конструктор вызваем один раз при старте приложения - файл создается
        // при старте приложения, т.е. task1() можно вызывать многократно,
        // файл пересоздаваться не будет
        createDoubleFile();

        // если файл данных для задачи 2 отсутствует - создать файл данных
        // т.к. файл больше нигде в коде не создается - то требование
        // однократного создания выполняется
        File file2 = new File(dirName + "/" + fileName2);
        if (!file2.exists()) {
            createIntFile(fileName2);
        } // if

        // если файл данных для задачи 3 отсутствует - создать файл данных
        File file3 = new File(dirName + "/" + fileName3);
        if (!file3.exists()) {
            // создать файл данных
            createIntFile(fileName3);

            // установить счетчик вызовов задачи task3 в 0
            setRunCounter(0);
        } // if
    } // Solution

    // проверка строки на допустимость - не пустая строка, не null
    private void check(String name) {
        if (name == null) throw new IllegalArgumentException("Имя не может быть null");
        if (name.isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
    } // check

    // Задача 1.
    // Создать двоичный файл из чисел типа double (от 20 до 30 чисел),
    // диапазон значений от -10 до 10. В этом файле все отрицательные числа
    // заменить их квадратами. Вывести файл до обработки, вывести файл после
    // обработки.
    public void task1() {
        showDoubleFile("Файл до обработки:\n");
        processDoubleFile();
        showDoubleFile("\nФайл после обработки (отрицательные числа заменены их квадратами):\n");
    } // task1


    // вывод в консоль файла, содержащего числа типа double в машинном представлении
    private void showDoubleFile(String title) {
        String pathName = dirName + "/" + fileName1;
        StringBuilder sbr = new StringBuilder(title);

        // читаем из файла данные и выводим в строку StringBuilder
        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            int position = 0;
            // пока не достигнут конец файла
            while(dis.available() > 0) {
                double value = dis.readDouble();  // чтение из файла
                // bgr
                String color = value < 0?"\033[34;1m":"\033[35;1m";
                sbr.append(String.format("%s%8.2f\033[0m", color, value));

                // перевод строки после каждых 15 значений
                if (++position % 15 == 0) sbr.append("\n");
            } // while
            // если последняя строка не заполнена, то делаем перевод строки
            if (position % 15 != 0) sbr.append("\n");
            System.out.print(sbr);
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при чтении из файла %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch
    } // showDoubleFile

    // замена отрицательных чисел в файле их квадратами
    private void processDoubleFile() {
        // полное имя файла
        String pathName = dirName + "/" + fileName1;

        // чтение/запись файла, обработка по заданию
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            long n = raf.length() / Double.BYTES;  // количество чисел в файле

            for (int i = 0; i < n; i++) {
                double value = raf.readDouble();
                if (value < 0) {
                    // установить указатель перед числом и записать его квадрат
                    raf.seek((long) i * Double.BYTES);
                    raf.writeDouble(value * value);
                } // if
            } // for i
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при обработке вещественного файла %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch
    } // processDoubleFile

    // Задача 2.
    // В двоичном файле целых чисел (от 15 до 30 чисел) найти количество
    // положительных и отрицательных чисел. Вывести файл в консоль с
    // выделением цветом положительных и отрицательных чисел.
    // Файл данных создавать только при первом запуске.
    public void task2() {
        // подсчет количества отрицательных и положительных чисел в файле
        // test
        int positive = calcAmount(integer -> integer >= 0);
        // test
        int negative = calcAmount(integer -> integer < 0);

        // вывод счетчиков и самого файла в консоль
        String title = String.format(
            "\033[34;1mОтрицательных\033[0m чисел: %d, \033[35;1mположительных\033[0m чисел: %d\n",
            negative, positive);
        showIntFile(fileName2, title);
    } // task2

    // возвращает количество чисел в файле для которых срабатывает предикат
    private int calcAmount(Predicate<Integer> predicate) {
        String pathName = dirName + "/" + fileName2; // полное имя файла
        int counter = 0;                     // счетчик положительных

        // чтение из файла
        try(DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            while(dis.available() > 0) {
                int value = dis.readInt();
                if (predicate.test(value)) counter++;
            }
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при подсчете положительных чисел в файле %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch

        return counter;
    } // calcAmount

    // --------------------------------------------------------------------------------

    // Задача 3.
    // В двоичном файле целых чисел (от 15 до 30 чисел) найти количество
    // локальных минимумов и локальных максимумов. Вывести файл в консоль
    // с выделением цветом локальных минимумов и максимумов. Файл данных
    // пересоздавать на каждом третьем запуске. Локальный минимум – элемент,
    // меньший своих левого и правого соседей. Локальный максимум – элемент,
    // больший своих левого и правого соседей
    public void task3() {
        // если счетчик запуска кратен 3 то пересоздать файл данных
        int n = getRunCounter();
        if (n % 3 == 0) createIntFile(fileName3);

        // найдем и выведем локальные минимумы и максимумы файла
        List<Integer> locMins = findLocMins();
        List<Integer> locMaxs = findLocMaxs();
        String title = "Файл данных с выделенными цветом локальными " +
                "\033[34;1mминимумами\033[0m и \033[35;1mмаксимумами\033[0m\n";
        showIntFile(fileName3, locMins, locMaxs, title);

        // увеличиваем счетчик запусков задачи,
        incrementRunCounter();
    } // task3


    // Увеличение счетчика запусков файла - счетчик храним в отдельном
    // двоичном файле - служебный файл data/runCounter.bin
    // Метод возвращает значение счетчика запусков (1 для первого запуска)
    // или -1, если доступ к файлу завершился ошибкой
    // операция "чтение модификация запись"
    private int incrementRunCounter() {
        int counter = -1;
        String pathName = dirName + "/" + RUN_TASK3_COUNTER;

        // инкремент значения, хранимого в служебном файле
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            // чтение счетчика запуска задачи task3(), инкремент счетчика
            counter = raf.readInt();
            ++counter;

            // Возвращаемся в начало файла, т.к. при чтении указатель операции переместился
            // по файлу
            raf.seek(0);

            // запись нового значения счетчика в файл
            raf.writeInt(counter);
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при операции с файлом %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch

        return counter;
    } // incrementRunCounter

    // устанавливает счетчик запусков задачи 3 в заданное значение
    private void setRunCounter(int value) {
        String pathName = dirName + "/" + RUN_TASK3_COUNTER;

        // запись значения value в служебный файл
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            raf.writeInt(value);
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при установке значения в файл %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch
    } // setRunCounter

    // читает счетчик запусков задачи 3
    private int getRunCounter() {
        String pathName = dirName + "/" + RUN_TASK3_COUNTER;
        int value = -1;

        // чтение значения value из служебного файла
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            value = raf.readInt();
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при чтении значения из файла %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch

        return value;
    } // getRunCounter

    // TODO: заменить два метода (findLocMins, findLocMaxs) одним - с предикатом
    // Поиск локальных минимумов в файле - возвращает коллекцию
    // целочисленных индексов чисел в файле, являющихся локальными
    // минимумами
    // Если локальных минимумов нет - возвращает пустую коллекцию
    private List<Integer> findLocMins() {
        List<Integer> locMins = new ArrayList<>();
        String pathName = dirName + "/" + fileName3;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            int left   = dis.readInt();   // 0 позиция
            int middle = dis.readInt();   // 1 позиция
            int right  = dis.readInt();   // 2 позиция
            int position = 1;

            while(dis.available() > 0) {
                if (left > middle && middle < right)
                    locMins.add(position);
                ++position;

                // подготовка к следующей итерации
                left = middle;
                middle = right;
                right = dis.readInt();  // читаем из файла
            } // while
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при поиске локальных минимумов в файле %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch

        return locMins;
    } // findLocMins

    // Поиск локальных максимумов в файле - возвращает коллекцию
    // целочисленных индексов чисел в файле, являющихся локальными
    // максимумами
    // Если локальных максимумов нет - возвращает пустую коллекцию
    private List<Integer> findLocMaxs() {
        List<Integer> locMaxs = new ArrayList<>();
        String pathName = dirName + "/" + fileName3;

        // последовательное чтение из файла
        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            // три первых значения, прочитанные из файла
            int left = dis.readInt();
            int middle = dis.readInt();
            int right = dis.readInt();
            int position = 1;

            // пока не достигнут конец файла читаем данные
            // available() > 0 конец файла не достигнут
            while(dis.available() > 0) {
                if (left < middle && middle > right)
                    locMaxs.add(position);
                ++position;

                // подготовка к следующей итерации
                left = middle;
                middle = right;
                right = dis.readInt();  // читаем из файла
            } // while
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при поиске локальных минимумов в файле %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch

        return locMaxs;
    } // findLocMaxs

    // Выводим числа типа int из двоичного файла; числа, на позициях
    // указанных в коллекции list выделяем цветом
    private void showIntFile(String fileName, List<Integer> listMin, List<Integer> listMax, String title) {
        String pathName = dirName + "/" + fileName;
        StringBuilder sbr = new StringBuilder(title);

        // чтение из файла данных и выводим в строку StringBuilder
        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            int position = 0;
            // пока не достигнут конец файла
            while(dis.available() > 0) {
                int value = dis.readInt();  // чтение из файла

                // определяем цвет вывода элемента
                String color = ""; // обычный элемент - цвет не нужен
                if (listMin.contains(position))       // если элемент - локальный минимум
                    color = "\033[34;1m";
                else if (listMax.contains(position))  // если элемент - локальный максимум
                    color = "\033[35;1m";
                sbr.append(String.format("%s%8d\033[0m", color, value));

                // перевод строки после каждых 15 значений
                if (++position % 15 == 0) sbr.append("\n");
            } // while
            // если последняя строка не заполнена, то делаем перевод строки
            if (position % 15 != 0) sbr.append("\n");
            System.out.print(sbr);
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при чтении из файла %s\n\033[0m",
                ex.getMessage(), pathName
            );
        } // try-catch
    } // showIntFile

    // Выводим числа типа int из двоичного файла; отрицательные и положительные числа
    // выделяем цветом
    private void showIntFile(String fileName, String title) {
        String pathName = dirName + "/" + fileName;
        StringBuilder sbr = new StringBuilder(title);

        try (var dis = new DataInputStream(new FileInputStream(pathName))) {
            int position = 0;
            while(dis.available() > 0) {
                int value = dis.readInt();
                sbr.append(String.format("%s%8d\033[0m", value<0?"\033[34;1m":"\033[35;1m", value));

                // перевод строки после каждых 15 значений
                if (++position % 15 == 0) sbr.append("\n");
            } // while
            // если последняя строка не заполнена, то делаем перевод строки
            if (position % 15 != 0) sbr.append("\n");
            System.out.print(sbr);
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при чтении из файла %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch
    } // showIntFile

    // Создание двоичного файла из чисел типа double (от 20 до 30 чисел),
    // диапазон значений от -10 до 10.
    private void createDoubleFile() {
        int n = Utils.getRandom(20, 30);
        String pathName = dirName + "/" + fileName1;

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathName))) {
            for (int i = 0; i < n; i++) {
                double value = Utils.getRandom(-10., 10.);
                dos.writeDouble(value);
            } // for i
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при создании файла %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch
    } // createDoubleFile

    // Создание двоичного файла, заполнение его случайными
    // числами типа int
    private void createIntFile(String fileName) {
        int n = Utils.getRandom(15, 30);
        String pathName = dirName + "/" + fileName;

        // запись n чисел типа int в файл
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathName))) {
            for (int i = 0; i < n; i++) {
                int value = Utils.getRandom(-10, 10);
                dos.writeInt(value);
            } // for i
        } catch (Exception ex) {
            System.out.printf(
                "\033[31;1mОшибка %s при создании файла %s\n\033[0m",
                ex.getMessage(), pathName);
        } // try-catch
    } // createIntFile
} // class Solution
