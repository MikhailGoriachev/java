package app.models;

/*
    3.	Обработка текстового файла – подсчет (без учета регистра) частоты слов. Текстовый файл подготовить заранее, 
    формировать его в коде не надо. Текст из файла и сформированный словарь вывести в консоль при помощи StringBuilder
 */

import java.io.FileReader;
import java.util.*;

// Класс Процесс 3
public class Proc03 implements Runnable {

    // название файла
    static public final String FILE_NAME = "app_data/text.txt";


    @Override
    public void run() {
        try {

            // чтение данных из файла
            var text = readTextFromFile();
            
            // получение слов
            var words = text.split("[ –.,!?\\s]+");

            Map<String, Long> stat = new HashMap<>();

            Arrays.stream(words).forEach(word -> stat.put(
                    word,
                    Arrays.stream(words)
                            .filter(w -> w.equalsIgnoreCase(word))
                            .count()
            ));

            System.out.println(toTable(text, stat));            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // чтение данных из файла
    public String readTextFromFile() throws Exception {
        StringBuffer sb = new StringBuffer();

        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNext())
                sb.append(sc.nextLine()).append("\n");
        }

        return sb.toString();
    }
    
    // вывод данных в виде таблицы
    public String toTable(String text, Map<String, Long> data) {
        StringBuffer sb = new StringBuffer();
        
        sb.append("\n\u001B[33m")
                .append("\n")
                .append(text)
                .append("\n")
                .append("\t+——————————————————————+————————————+\n")
                .append("\t| Слово                | Количество |\n")
                .append("\t+——————————————————————+————————————+\n");
        
        data.forEach((key, value) -> sb.append(String.format("\t| %-20s | %10d |\n", key, value)));
        
        sb.append("\t+——————————————————————+————————————+\n\u001B[37m");
        
        return sb.toString();
    }

}
