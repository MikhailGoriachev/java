package org.homework.app.models.task02;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


// Класс Общий ресурс
public class Store {

    // семафор
    private final Semaphore semaphore;

    // есть ли новые данные
    private boolean isNewData = false;

    // название файла
    public final String FILE_NAME = "app_data/numbers.txt";


    // конструктор инициализирующий
    public Store() {
        this.semaphore = new Semaphore(1);
    }


    // запись данных
    public void put(double value) throws InterruptedException, IOException {
        while (true) {
            Thread.sleep(40);
            
            if (!isNewData) {
                semaphore.acquire();

                appendToFile(value);

                isNewData = true;

                semaphore.release();

                break;
            }
        }
    }

    // получение данных
    public List<Double> get() throws InterruptedException, IOException {

        List<Double> value;

        var f = false;

        while (true) {
            Thread.sleep(40);

            if (isNewData) {
                semaphore.acquire();

                value = readNumbers();

                isNewData = false;

                semaphore.release();
                break;
            }
        }

        return value;
    }

    // запись числа в конец файла
    public void appendToFile(double value) throws IOException {
        try (var stream = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            stream.println(value);
        }
    }

    // чтение данных из файла
    public List<Double> readNumbers() throws IOException {
        var list = new ArrayList<Double>();

        try (var scanner = new Scanner(Path.of(FILE_NAME))) {
            while (scanner.hasNext())
                list.add(Double.parseDouble(scanner.nextLine()));
        }

        return list;
    }

    // получить количество чисел в файле
    public int getCountNumbers() throws IOException {
        return readNumbers().size();
    }
}
