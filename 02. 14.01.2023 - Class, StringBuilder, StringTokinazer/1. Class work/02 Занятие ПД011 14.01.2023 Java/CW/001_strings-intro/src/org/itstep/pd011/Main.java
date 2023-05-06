package org.itstep.pd011;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        // вертикальный блок вкл. / выкл.: Alt + Shift + Insert
        // или Alt+ЛКМ
        // stringDemo();
        // System.out.println("\n");

        // demoStringBuilder();

        // System.out.println("\n\n\033[34m");
        // demoStringBuffer();
        // System.out.print("\033[0m");

        stringTokenizerDemo();
    } // main


    // демонстрация работы со строками
    private static void stringDemo() {
        // Строки - неизменяемые (immutable) объекты класса String
        // Есть много конструкторов класса String
        // String str1 = new String();
        String str1 = "   кот ломом колол слона    ";

        int x = 42;
        String str2 = String.valueOf(x);  // фабричный метод, создающий строку
        System.out.printf("\"%s\"\n\"%s\"\n\n", str1, str2);


        // методы класса String
        x = 13;
        char t = str1.charAt(x);       // взять символ в x-й позиции строки
        System.out.printf("Символ в позиции %d строки \"%s\" это '%c'\n", x, str1, t);

        str1 = str1.trim();           // убрать ведущие и хвостовые пробелы в str1
        System.out.printf("Убрать ведущие и хвостовые пробелы: \"%s\"\n", str1);

        str1 = "пример 1";  // ближе к концу  алфавитной сортировки
        str2 = "Пример 1";  // ближе к началу алфавитной сортировки
        System.out.printf("\nСтроки для сравения \"%s\" и \"%s\"\n", str1, str2);

        // сравнение строк
        System.out.print("Сравнение строк с учетом регистра: ");
        // if (str1 == str2)    // сравнение ссылок
        if (str1.equals(str2))  // сравнение контента
            System.out.println("строки равны");
        else
            System.out.println("строки не равны");

        System.out.print("Сравнение строк без учета регистра: ");
        if (str1.equalsIgnoreCase(str2))
            System.out.println("строки равны");
        else
            System.out.println("строки не равны");

        // лексикографическое сравнение строк
        str1 = "ананас";
        str2 = "яблоко";
        System.out.printf("\nСтроки для сравения \"%s\" и \"%s\"\n", str1, str2);

        // xyz.compareTo(uvt) - очень важный метод
        // xyz  < uvt --->  -1
        // xyz == uvt --->   0
        // xyz  > uvt --->   1
        int result = str1.compareTo(str2);
        if (result < 0)
            System.out.printf("\"%s\" <  \"%s\"\n", str1, str2);
        else if (result == 0)
            System.out.printf("\"%s\" == \"%s\"\n", str1, str2);
        else
            System.out.printf("\"%s\" >  \"%s\"\n", str1, str2);


        System.out.print("\nПоиск в строке: ");
        str1 = "кот ломом колол слона";
        System.out.printf("\"%s\"\n", str1);
        if (str1.contains("слона"))  // есть строка "слон" в строке "кот ломом колол слона"
            System.out.println("Нашли слона");
        else
            System.out.println("Все говорят, что нету, а ты найди слона");

        System.out.printf("начинаем с \"кот\": %b\n", str1.startsWith("кот"));
        System.out.printf("заканчиваем с \"она\": %b\n", str1.endsWith("она"));

        // str1 = "кот ломом колол слона";
        System.out.printf("первое    вхождение \"ло\" в \"%s\": %d\n", str1, str1.indexOf("ло"));
        System.out.printf("последнее вхождение \"ло\" в \"%s\": %d\n", str1, str1.lastIndexOf("ло"));


        // подсчитать количество вхождений подстроки str2 в строку str1
        int i = 0;         // позиция начала поиска в строке
        int counter = 0;   // счетчик вхождений
        str2 = "ло";       // подстрока для поиска
        System.out.printf("""

                Количество вхождений подстроки \033[34m"%s"\033[0m в строке \033[34m"%s"\033[0m
                """, str2, str1);

        while((i = str1.indexOf(str2, i)) >= 0) {
            counter++;           // увеличение счетичка найденных подстрок
            i += str2.length();  // пропускаем найденную подстроку в строке
        } // while
        System.out.printf("В строке \033[34m\"%s\"\033[0m подстрок " +
                "\033[34m\"%s\"\033[0m найдено: \033[47;1m%4d   \033[0m\n", str1, str2, counter);


        // преобразование регистров символов строк
        System.out.println("\nПреобразование регистров символов стооки:");
        str1 = str1.toUpperCase();
        System.out.printf("%s\n", str1);

        str1 = str1.toLowerCase();
        // System.out.printf("%s\n", str1.toLowerCase());
        System.out.printf("%s\n", str1);

        // удаление подстроки - замена подстроки на пустую строку
        // !!!! заменяются ВСЕ вхождения заданной первым параметром подстроки !!!
        // str1 = "кот ломом колол слона";
        str2 = "ломом ";  // удаляемая подстрока (!!! пробел в конце !!!)
        System.out.printf("\nУдаление подстроки \"%s\" из строки \"%s\": ", str2, str1);
        str1 = str1.replace(str2, "");
        System.out.printf("%s\n", str1);

        // вставка подстроки - может быть сведена к замене
        // из "кот колол слона" хочу получить "котик колол слоника";
        str1 = str1.replace("кот", "котик");   // кот --> котик    -- замена
        str1 = str1.replace("на", "ника");     // слона --> слоника -- вставка сведена к замене
        System.out.printf("%s\n", str1);

        // из "котик колол слоника" хочу получить "котик серый колол слоника";
        str1 = str1.replace("к к", "к серый к");
        System.out.printf("%s\n", str1);

        // получение подстроки substring(firstIndex, secondIndex)
        // Первый индекс - включающий
        // Второй индекс - исключающий
        // Указание только одного индекса - от него и до конца строки
        System.out.println("\nПолучение подстроки: подстрока - первый символ строки");
        str1 = str1.substring(0, 1).toUpperCase() + str1.substring(1);
        System.out.printf("%s\n", str1);

    } // stringDemo

    // класс StringBuilder
    private static void demoStringBuilder() {
        // StringBuilder - класс для работы с изменяющимися строками
        // StringBuffer  - класс для работы с изменяющимися строками в
        //                 поток-безопасном режиме
        // Т.е. безопасное обращение нескольких параллельно исполняющихся потоков
        // к одной и той же строке
        StringBuilder sb = new StringBuilder("кот ломом колол слона");
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());

        // capacity тоже увеличится
        sb.append(sb);
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());

        sb.setCharAt(1, 'э');
        System.out.println(sb);

        sb.insert(3, "овский");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        // Первый индекс - включающий
        // Второй индекс - исключающий
        sb.delete(0, 3);  // удаляем символы от 0-го до 3-го (исключая 3й)
        System.out.println(sb);

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());  // ар.р.т

        // добавление в конец строки
        sb.append(". \033[1mThat's all falks!\033[0m");
        System.out.println(sb);
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());

        // еще раз продемонстрируем capacity
        sb.append(" Привет, мир.");
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());
    } // demoStringBuilder

    // пример на использование StringBuffer
    private static void demoStringBuffer() {
        // StringBuffer - класс для работы с изменяющимися строками в
        // потоко-безопасном режиме
        // Т.е. безопасное обращение нескольких параллельно исполняющихся потоков
        // к одной и той же строке
        StringBuffer sb = new StringBuffer("кот ломом колол слона");
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());

        sb.setCharAt(1, 'э');
        System.out.println(sb.toString());

        sb.insert(3, "овский");
        System.out.println(sb.toString());

        sb.reverse();
        System.out.println(sb.toString());

        sb.reverse();
        System.out.println(sb.toString());

        // Первый индекс - включающий
        // Второй индекс - исключающий
        sb.delete(0, 3);  // удаляем символы от 0-го до 3-го (исключая 3й)
        System.out.println(sb.toString());

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());  // ар.р.т

        // добавление в конец строки
        sb.append(". \033[1mThat's all falks!\033[0m");
        System.out.println(sb);
        System.out.printf("capacity: %d; length; %d\n", sb.capacity(), sb.length());
    } // demoStringBuffer

    // разбивка строк на токены - класс StringTokenizer
    private static void stringTokenizerDemo() {
        System.out.println("\n\nРазбиение строки на токены, класс StringTokenizer, текст для обработки:");
        String str = "Идейные:       соображения - высшего порядка, а \n" +
            "также??????? начало, повседневной... работы; по формированию " +
            "позиции в значительной!!!";

        // вывод текста для обработки
        System.out.printf("\033[34m%s\033[0m\n-----------------------------------------------------------\n", str);

        // StringTokenizer stz = new StringTokenizer(str); // разделители: пробел, \t, \n
        StringTokenizer stz = new StringTokenizer(str, " .,\t\n:;-!?");

        // определить количество токенов (слов) в строке
        int n = stz.countTokens();      // количество оставшихся необработанными токенов в строке
        String[] words = new String[n]; // массив слов/токенов, выделенных из строки

        // разбиение на токены
        // for (int i = 0; stz.hasMoreTokens(); i++) {  // еще один вариант заголовка цикла
        for (int i = 0; i < n; i++) {
            words[i] = stz.nextToken();
        } // for i

        // вывод массива слов
        for (String w:words) {
            System.out.println(w);
        } // foreach

        System.out.printf(
            "-----------------------------------------------------------\n" +
            "Всего слов: %d\n", n);

        // Пример обработки - поиск самого короткого слова
        int minLen = Integer.MAX_VALUE;   // words[0].length()
        String wMin = "";                 // words[0]

        // просмотреть массив слов
        for (String word:words) {
            if (word.length() <= minLen) { // последнее вхождение
                // if (word.length() < minLen) {  // первое вхождение
                wMin = word;
                minLen = word.length();
            } // if
        } // for
        System.out.printf("Последнее самое короткое слово: \033[30;47;1m    %s    \033[0m\n", wMin);

        // класс Arrays - простая обработка массивов
        Arrays.sort(words);  // отсортирован по алфавиту
        System.out.println("\n" + Arrays.toString(words));

        str = String.join(" ", words);
        System.out.printf("\n\033[32;1m\"%s\"\033[0m\n\n", str);
    } // stringTokenizerDemo

} // class Main
