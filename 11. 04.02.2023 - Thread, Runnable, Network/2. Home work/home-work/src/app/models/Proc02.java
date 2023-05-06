package app.models;

/*
    2.	Создание коллекции заявок на ремонт ноутбуков (наименование устройства, модель, тип процессора, объем 
    оперативной памяти, емкость накопителя, диагональ экрана, описание неисправности, фамилия и инициалы владельца), 
    сериализация этой коллекции при первом запуске; десериализация, перемешивание и сериализация при последующих 
    запусках. Вывод результатов в консоль при помощи StringBuilder
*/

import app.utils.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Класс Процесс 2
public class Proc02 implements Runnable {

    // название файла
    static public final String FILE_NAME = "app_data/laptops.xml";
    

    @Override
    public void run() {

        try {
            // начальная инициализация
            if (!Files.exists(Path.of(FILE_NAME)))
                serialization(List.of(
                        new Laptop("Asus", "VivoBook 15", "Intel Core i5", 16, 512, 15.2, "Матрица", "Климов А. Л."),
                        new Laptop("Asus", "VivoBook 16", "Intel Core i7", 16, 512, 15.2, "Клавиатура", "Котова В. М."),
                        new Laptop("Apple", "MacBook Air", "Intel Core i5", 32, 512, 13d, "Матрица", "Калугина А. А."),
                        new Laptop("Samsung", "GalaxyBook", "Intel Core i7", 8, 256, 15.2, "Материнская плата", "Русаков Е. В."),
                        new Laptop("Apple", "MacBook Pro", "Intel Core i7", 32, 1024, 15.2, "Матрица", "Алексеев Д. Р."),
                        new Laptop("Asus", "VivoBook 14", "Intel Core i3", 16, 512, 15.2, "Динамик", "Громов С. Т."),
                        new Laptop("Samsung", "GalaxyBook", "Intel Core i5", 8, 256, 15.2, "Батарея", "Гончарова П. Г."),
                        new Laptop("Samsung", "GalaxyBook 15", "Intel Core i5", 8, 256, 15.2, "Батарея", "Савина А. Д."),
                        new Laptop("Apple", "MacBook Pro", "Intel Core i7", 32, 1024, 15.2, "Матрица", "Климова М. А."),
                        new Laptop("Apple", "MacBook Pro", "Intel Core i7", 32, 1024, 15.2, "Матрица", "Федоров М. Л.")
                ));

            // загрузка данных
            var list = new ArrayList<>(deserialization());

            // вывод данных
            showToConsole(list);

            // перемешивание
            Collections.shuffle(list);
            
            // запись данных
            serialization(list);


            // вывод данных
            showToConsole(list);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // сериализация
    public void serialization(List<Laptop> data) throws IOException {
        try (var stream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            stream.writeObject(data);
        }
    }

    // десериализация
    public List<Laptop> deserialization() throws Exception {
        if (!Files.exists(Path.of(FILE_NAME)))
            return new ArrayList<>();

        var list = new ArrayList<Laptop>();
        
        try (var stream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Laptop>) stream.readObject();
        }
    }

    // вывод данных в виде таблицы в консоль
    public void showToConsole(List<Laptop> data) {
        var sb = new StringBuffer();


        sb.append("\n\u001B[35m")
                .append("\t+——————————————————————+——————————————————————+——————————————————————+———————+—————————+———————————+——————————————————————+—————————————————+\n")
                .append("\t| Название             | Модель               | Процессор            | RAM   | Storage | Диагональ | Дефект               | Владелец        |\n")
                .append("\t+——————————————————————+——————————————————————+——————————————————————+———————+—————————+———————————+——————————————————————+—————————————————+\n");

        data.forEach(d -> sb.append(d.toTableRow()));

        sb.append("\t+——————————————————————+——————————————————————+——————————————————————+———————+—————————+———————————+——————————————————————+—————————————————+\u001B[0m\n\n");

        System.out.println(sb);
    }
}
