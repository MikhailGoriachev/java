package app.models;

/*
    1.	Создание файла случайных вещественных чисел (не более 20 чисел, диапазон значений [-10, 10]) при первом запуске, 
    при последующих запусках – перемешивание данных в файле. Сортировка коллекции, прочитанной из файла по заданию, 
    вывод в консоль, сохранение измененного файла. Вывод результатов в консоль при помощи StringBuilder. Сортировки 
    данных в коллекции: по возрастанию, по убыванию модулей, числа из диапазона [-5, -1] в конец файла.
 */

import app.utils.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

// Класс Процесс 1
public class Proc01 implements Runnable {

    // название файла
    static public final String FILE_NAME = "app_data/numbers.bin";

    // диапазон значений
    static public final double MIN_RANGE = -10d;
    static public final double MAX_RANGE = 10d;
    
    
    @Override
    public void run() {
        try {
            // инициализация файла
            if (!Files.exists(Path.of(FILE_NAME)))
                saveToFile(Arrays.stream(new double[Utils.getInt(12, 15)])
                        .map(n -> Utils.getDouble(MIN_RANGE, MAX_RANGE + 1d))
                        .toArray());

            // чтение данных из файла
            var array = loadFromFile();

            showToConsole(array, "Данные из файла");

            // перемешивание массива
            Collections.shuffle(array);

            showToConsole(array, "Перемешанные данные");

            // сортировка
            array.sort(Double::compare);

            showToConsole(array, "Отсортированные данные по возрастанию");
            
            // сохранение в файл
            saveToFile(array.stream().mapToDouble(Double::doubleValue).toArray());
            
            // по возрастанию модулей
            array.sort(Comparator.comparing(a -> Math.abs((Double) a)).reversed());
            
            showToConsole(array, "Отсортированные данные по убыванию модулей");
            
            // диапазон
            final double MIN = -5d, MAX = -1d;
            
            // по принципу [-5, -1] в конце
            array.sort(Comparator.comparing(a -> a >= MIN && a <= MAX));

            showToConsole(array, "Отсортированные данные по принципу [-5, -1] в конце");
            
            // сохранение в файл
            saveToFile(array.stream().mapToDouble(Double::doubleValue).toArray());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // запись данных в файл
    public void saveToFile(double[] array) throws IOException {
        // запись данных в файл
        try (var stream = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (var n : array)
                stream.writeDouble(n);
        }
    }

    // чтение данных из файла
    public List<Double> loadFromFile() throws IOException {

        var list = new ArrayList<Double>();

        // запись данных в файл
        try (var stream = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (stream.available() > 0)
                list.add(stream.readDouble());
        }

        return list;
    }

    // вывод массива в консоль
    public void showToConsole(List<Double> list, String title) {
        StringBuffer sb = new StringBuffer();

        sb.append("\u001B[32m\n\n\t").append(title).append("\n");
        list.forEach(n -> sb.append(String.format("\t%.3f\t", n)));
        sb.append("\n\n\u001B[0m");
        System.out.println(sb);
    }
}
