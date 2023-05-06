package app.models;

/*
    4.	Загрузка главной страницы сайта NewtonSoft, определение количества символов < и > на загруженной странице
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

// Класс Процесс 4
public class Proc04 implements Runnable {

    // URL-ссылка на ресурс
    public final String URL_NAME;

    
    // конструктор по умолчанию
    public Proc04() {
        URL_NAME = "https://www.newtonsoft.com/json";
    }


    @Override
    public void run() {
        try {
            var url = new URL(URL_NAME);

            // количество символов < и >
            AtomicInteger countSymbols = new AtomicInteger();
            
            try(var reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                reader.lines().forEach(l -> countSymbols.addAndGet((int) l.chars().filter(c -> c == '>' || c == '<').count())); // reading content
            }

            System.out.println("\u001B[36mКоличество вхождений символов '<' и '>': " + countSymbols + "\u001B[0m");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
