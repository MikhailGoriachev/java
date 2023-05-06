package org.itstep.pd011;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/*
* Двоичные данные - данные в машинном формате
*
* */
public class Main {

    public static void main(String[] args) {

        String fileName = "app_data/binary.bin";

        // demoBinfile(fileName);

        demoDirectBinFiles("app_data/random.bin");
    } // main

    // демо работы с бинарными файлами
    private static void demoBinfile(String fileName) {
        // Создание папки для файлов данных, если папки еще нет
        File dir = new File("app_data");
        if (!dir.exists()) dir.mkdir();

        // запись вещественных данных в двоичный файл
        System.out.print("\nВывод вещественных чисел в двоичный файл...");
        List<Double> data = new ArrayList<>(Arrays.asList(Math.PI, Math.E, 9.81, -1000., 42.));
        writeBinData(fileName, data);
        System.out.println(" \033[32;1mвыполнен\033[0m");

        System.out.println("Читаем данные из двоичного файла:");
        data = readBinData(fileName);
        for (double d:data) {
            System.out.printf(Locale.UK, "%12.3f", d);
        } // foreach
        System.out.println("\n");
    } // demoBinFile


    // демо работы с бинарными файлами прямого доступа
    public static void demoDirectBinFiles(String fileName) {
        System.out.println("Двоичные файлы прямого доступа");
        // чтение и запись в двоичный файл произвольного доступа
        // т.е. чтение и запись выполняется в произвольном порядке
        // ‼ все записи файла имеют равную длину
        // ‼ можно даже изменить размер такого файла
        // имя.setLength(новаяДлина)
        randomAccessDemo(fileName, new ArrayList<>(Arrays.asList(2, -12, 85, 0, -6, -2, 12, 85, 6, -119)));
        // randomAccessDemo(fileName, new ArrayList<Integer>(Arrays.asList(2, 3, 5, 6, 12, 85, 99)));

        // пример работы с файлом прямого доступа - меняем местами первое максимальное
        // и первое минимальное числа в файле
        System.out.println("\nОбмен местами первого min и первого max в файле");

        // читаем данные из файла и выводим в консоль
        List<Integer> idata = readBinIntData(fileName);
        showList("Файл до обмена           : ", idata);

        // меняем местами первое максимальное и первое минимальное числа в файле
        swapMinMax(fileName);

        // после обмена еще раз читаем данные из файла и выводим в консоль
        idata = readBinIntData(fileName);
        showList("Файл после обмена        : ", idata);

    } // directBinFiles

    // Запись данных в двоичном формате
    private static void writeBinData(String fileName, List<Double> data) {

        // Открываем/создаем файл
        // DataOutputStream - вывод в машинном представлении
        // FileOutputStream - потомок OutputStream для работы с локальными файлами
        // м.б. любой другой потомок (например, для сетевой работы - UDP, TCP, ...)
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            // Типизированная запись в файл
            // например, для записи строки out.writeUTF(str);
            for(double d:data)
                out.writeDouble(d);
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // writeBinData


    // Пример чтения двоичных данных в формате double
    private static List<Double> readBinData(String fileName) {
        List<Double> arr = null;

        // Открываем файл
        // DataInputStream - ввод в машинном представлении
        // FileInputStream - потомок InputStream для работы с локальными файлами
        // м.б. любой другой потомок (например, для сетевой работы - UDP, TCP, ...)
        try (DataInputStream dr = new DataInputStream(new FileInputStream(fileName))) {
            arr = new ArrayList<>();

            // размер файла в числах типа double:
            // размер файла в байтах делим на размер типа double в байтах
            // long n = (new File(fileName)).length() / Double.BYTES;
            // for(long i = 0; i < n; i++) arr.add(dr.readDouble());

            // чтение до появления признака "Конец файла"
            while (dr.available() > 0) {
                arr.add(dr.readDouble());
            }
        } catch (Exception ex) {
            System.out.printf("Ошибка: %s\n", ex.getMessage());
        } // try-catch

        return arr;
    } // readBinData

    // чтение целых чисел из файла
    private static List<Integer> readBinIntData(String fileName) {
        List<Integer> list = null;

        try (DataInputStream dr = new DataInputStream(new FileInputStream(fileName))) {
            // размер файла в числах типа int:
            // размер файла в байтах делим на размер типа int в байтах
            int n = (int)(new File(fileName)).length() / Integer.BYTES;
            list = new ArrayList<>();

            // прочитать эти n чисел из файла
            for(int i = 0; i < n; i++) list.add(dr.readInt());
        } catch (Exception ex) {
            System.out.printf("\n\033[31;1mОшибка: %s\n\033[0m", ex.getMessage());
        } // try-catch

        return list;
    } // readBinIntData

    // запись и чтение данных - набор целых чисел
    private static void randomAccessDemo(String fileName, List<Integer> data) {
        // RandomAccessFile - при создании задавать имя файла и режим открытия файла
        // "rw" - чтение и запись, если файла нет, он будет создан
        // "r"  - только чтение из файла
        // try(RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw")) {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            System.out.print("Запись в файл прямого доступа...");
            // Запись в файл - типизированная, в двоичном формате
            for (int d:data) {
                raf.writeInt(d);
            } // for each
            System.out.println("\033[32;1mвыполнено\033[0m");

            // чтение из файла в прямом порядке
            System.out.print("Чтение в прямом порядке  : ");
            int n = data.size();
            raf.seek(0);    // переход в начало файла
            for (int i = 0; i < n; i++) {
                // raf.seek(i*Integer.BYTES);            // переход на заданную позицию в файле
                System.out.printf("%6d", raf.readInt()); // чтение из файла, продвигает позицию в файле
            } // for i
            System.out.println();

            // чтение из файла в обратном порядке
            System.out.print("Чтение в обратном порядке: ");
            for (int i = n-1; i >= 0; --i) {
                raf.seek(i * Integer.BYTES);           // переход на заданную позицию в файле
                System.out.printf("%6d", raf.readInt()); // чтение из файла, продвигает позицию в файле
            } // for i
            System.out.println();
        } catch (Exception ex) {
            System.out.printf("\n\033[31;1mОшибка: %s\n\033[0m", ex.getMessage());
        } // try-catch
    } // randomAccessDemo

    // меняем местами первое максимальне и первое минимальное числа в файле
    private static void swapMinMax(String fileName) {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            long pos_min = 0, pos_max = 0;
            long n = raf.length() / Integer.BYTES;  // размер файла в записях (числах) типа int

            for (long i = 0; i < n; i++) {
                long pos  = raf.getFilePointer(); // получить текущую позицию в файале
                int value = raf.readInt();        // чтение из файла, продвигает позицию в файле

                if (value > max) {
                    max = value;
                    pos_max = pos;  // запомнить позицию в файле
                } // if
                if (value < min) {
                    min = value;
                    pos_min = pos;    // запомнить позицию в файле
                } // if
            } // for i

            // собственно обмен местами min, max
            raf.seek(pos_min);  raf.writeInt(max);
            raf.seek(pos_max);  raf.writeInt(min);
        } catch (Exception ex) {
            System.out.printf("\n\033[31;1mОшибка: %s\n\033[0m", ex.getMessage());
        } // try-catch
    } // swapMinMax


    // служебный метод - вывод списка целых чисел в консоль
    private static void showList(String caption, List<Integer> idata) {
        System.out.print(caption);
        for (int d:idata) {
            System.out.printf("%6d", d);
        } // foreach
        System.out.println();
    } // showList
} // class Main
