package app.controllers;

import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


/*
    Задача 2. Дан текстовый файл из нескольких строк, слова в котором разделяются пробелами (одним или несколькими), 
    символами конца строки. Реализовать обработки:
    •	Вывести текстовый файл в консоль, сохраняя разбивку текста на строки
    •	Преобразовать файл, оставив между словами по одному пробелу
    •	Для всех слов, из которых состоит текст определить: количество слов, суммарное количество букв в словах, 
        минимальная длина слова, максимальная длина слова, средняя длина слова
*/

// Контроллер Задание 2
public class Task02Controller implements IController {

    // название файла
    public final String TEXT_FILE_NAME = "app_data/text.txt";


    // конструктор по умолчанию
    public Task02Controller() {}


    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Инициализация",
                "Текст",
                "Преобразование файла",
                "Статистика",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 2. Текст";

        IController[] commands = new IController[]{

                // инициализация файла
                () -> {
                    initialization();
                    
                    Utils.showWindow("<html><h2 align='center'>Инициализация файла</h2>" +
                                    textToTable(getText()),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // вывод текста файла
                () -> Utils.showWindow("<html><h2 align='center'>Текст файла</h2>" +
                                textToTable(getText()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // преобразовать файл, оставив между словами по одному пробелу
                () -> {
                    convertFile();

                    Utils.showWindow("<html><h2 align='center'>Преобразование файла</h2>" +
                                    textToTable(getText()),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },

                // для всех слов, из которых состоит текст определить: количество слов, суммарное количество букв в словах,
                // минимальная длина слова, максимальная длина слова, средняя длина слова
                () -> Utils.showWindow("<html><h2 align='center'>Статистика текста</h2>" +
                                textToTable(getText()) + "<br>" + statisticToTable(getStatistic()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 2. Текст</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }


    // инициализация файла
    public void initialization() throws IOException {
        Files.writeString(Path.of(TEXT_FILE_NAME), "кол   ломом! . колол  —  слона\r\nехал     грека !!! через реку\r\n   видит грека,  в   реке... рак!!!");
    }

    // вывести текстовый файл в консоль, сохраняя разбивку текста на строки
    public String getText() {
        var sb = new StringBuilder();

        try (var sc = new Scanner(new File(TEXT_FILE_NAME))) {

            while (sc.hasNext())
                sb.append(sc.nextLine()).append("\n");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    // преобразовать файл, оставив между словами по одному пробелу
    public void convertFile() {
        var text = getText();
        var words = new ArrayList<String>();

        var st = new StringTokenizer(text, " .,!?-—:+=\n\r");
        
        while (st.hasMoreTokens())
            words.add(st.nextToken());
        
        try (var fw = new FileWriter(TEXT_FILE_NAME)) {
            
            for (String w : words) {
                fw.write(w);
                fw.write(' ');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // для всех слов, из которых состоит текст определить: количество слов, суммарное количество букв в словах,
    // минимальная длина слова, максимальная длина слова, средняя длина слова
    public Number[] getStatistic() {
        var words = new ArrayList<String>();

        try (var sc = new Scanner(new File(TEXT_FILE_NAME))) {

            while (sc.hasNext()) {
                var line = sc.nextLine();

                var st = new StringTokenizer(line, " .,!?-—:+=");

                while (st.hasMoreTokens())
                    words.add(st.nextToken());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new Number[]{
                words.size(),
                words.stream().mapToInt(String::length).sum(),
                words.stream().min(Comparator.comparing(String::length)).get().length(),
                words.stream().mapToInt(String::length).average().getAsDouble(),
                words.stream().max(Comparator.comparing(String::length)).get().length(),
        };
    }

    // вывод текста в виде таблицы
    public String textToTable(String text) {
        return new StringBuilder().append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Название файла:").append(TEXT_FILE_NAME).append("</th>")
                .append("</thead><tbody>")
                .append("<tr><td>")
                .append("<code>")
                .append(text.replace("\n", "<br>"))
                .append("</code>")
                .append("</td></tr>")
                .append("</tbody></table>")
                .toString();
    }

    // вывод статистики в виде таблицы
    public String statisticToTable(Number[] statistic) {
        return new StringBuilder().append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Количество слов</th>")
                .append("<th>Сумма букв в словах</th>")
                .append("<th>Минимальная длина слова</th>")
                .append("<th>Средняя длина слова</th>")
                .append("<th>Максимальная длина слова</th>")
                .append("</thead><tbody>")
                .append("<tr>")
                .append("<td>").append(statistic[0].intValue()).append("</td>")
                .append("<td>").append(statistic[1].intValue()).append("</td>")
                .append("<td>").append(statistic[2].intValue()).append("</td>")
                .append(String.format("<td>%.2f</td>", statistic[3].doubleValue()))
                .append("<td>").append(statistic[4].intValue()).append("</td>")
                .append("</tr>")
                .append("</tbody></table>")
                .toString();
    }
}
