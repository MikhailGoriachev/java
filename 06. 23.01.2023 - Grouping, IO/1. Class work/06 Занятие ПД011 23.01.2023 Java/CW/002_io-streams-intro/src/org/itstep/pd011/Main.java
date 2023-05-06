package org.itstep.pd011;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    // Чтение символьных данных из файла
        // demoFileReader();

        // System.out.println();
        // demoFileReader1_7();

        // System.out.println();
        // demoScannerReader();

        // System.out.println();
        // demoReadCollection();

        // System.out.println();
        // demoFileWriter();

        // System.out.println();
       //  demoPrintFile();

        // System.out.println();
        demoReadWrite();
    } // main



    // "Классическое" чтение данных из файла для
    // Java версий 1.6 и ниже
    private static void demoFileReader() {
        // Имя файла
        // String fileName = "Persons.txt";
        String fileName = "data/Persons.txt";
        // String fileName = "d:/Data/Persons.txt";
        // String fileName = "d:\\Data\\Persons.txt";

        // Объект для чтения из файла
        FileReader frd = null;

        try {
            // создать объект для чтения из файла
            frd = new FileReader(fileName);
            int b;           // символ для чтения из файла - код прочитанного символа
            int count = 0;   // счетчик прочитанных байтов

            // чтение из файла
            while ((b = frd.read()) != -1) {
                System.out.print((char)b);
                count++;
            } // while
            System.out.printf("\ndemoFileReader: всего прочитано символов %d\n", count);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {  // Для закрытия файла также нужен try-блок
                frd.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } // try-catch
        } // try-catch-finally
    } // demoFileReader


    // Пример упрощенного чтения из файла для версий 1.7 и старше
    private static void demoFileReader1_7() {
        // Имя файла
        // String fileName = "d:/Data/Persons.txt";
        String fileName = "data/Persons.txt";
        //String fileName = "Persons.txt";

        // try-блок с ресурсами обеспечивает автоматическое закрытие файла
        // за счет реализации интерфейса AutoClosable классом FileReader
        try (FileReader frd = new FileReader(fileName)) {
            int b;           // символ для чтения из файла
            int count = 0;   // счетчик прочитанных байтов

            // чтение из файла
            while ((b = frd.read()) != -1) {
                System.out.print((char)b);
                count++;
            } // while
            System.out.printf("\ndemoFileReader1_7: Всего прочитано символов %d\n", count);
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // demoFileReader1_7


    // Использование класса Scanner для чтения из файла
    private static void demoScannerReader() {
        // String fileName =  "d:/Data/Persons.txt";
        // файл - в подпапке data папки проекта
        String fileName =  "data/Persons.txt";
        // String fileName =  "Persons.txt";

        // Если указать строку - парсится строка, не файл :)
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            String str;
            int counter = 0;
            int bytes = 0;

            // пока не достигнут конец файла
            while (sc.hasNext()) {
                str = sc.nextLine();
                System.out.println(str);
                bytes += str.length();
                counter++;
            } // while

            System.out.println("\ndemoScannerReader: Прочитано строк " + counter + ", символов " + bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        } // try-catch
    } // demoScannerReader

    // запись в текстовый файл в стиле Java 1.7
    private static void demoFileWriter() {
        String fileName = "data/Java_out.txt";

        // если папки data нет - создать папку
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        String[] text = {
            "Не следует, однако забывать, что укрепление и развитие структуры требуют определения и",
            "уточнения новых предложений. Не следует, однако забывать, что новая модель организационной ",
            "деятельности представляет собой интересный эксперимент проверки позиций, занимаемых участниками в ",
            "отношении поставленных задач. С другой стороны дальнейшее развитие различных форм деятельности ",
            "представляет собой интересный эксперимент проверки системы обучения кадров, соответствует насущным ",
            "потребностям."
        };

        // запись в файл
        // для дозаписи - параметр append в true
        // Объект класса File - возможность выполнения операций в файловой системе ОС
        // try(FileWriter fwr = new FileWriter(fileName, true)) {
        try(FileWriter fwr = new FileWriter(new File(fileName))) {
        // try(FileWriter fwr = new FileWriter(new File(new URI("file:///" + fileName)))) {
            for (String str:text) {
                fwr.write(str);
                fwr.write("\r\n"); // !!! Не забывайте - перевод строки выполняем сами !!!
            } // foreach
            System.out.println("demoFileWriter - Текстовый файл записан");
        } catch (IOException ex) {
            ex.printStackTrace();
        }  // catch (URISyntaxException ex) {
            // ex.printStackTrace();
        // }// try-catch

    } // demoFileWriter


    // демонстрация записи в текстовый файл с форматированием
    // подобно printf() - класс PrintWriter
    private static void demoPrintFile() {
        String fileName = "data/table_sin.txt";
        String splitter = "+----------+------------+\r\n";
        String header   = "|     x    |    sin(x)  |\r\n";

        // если папки data нет - создать папку
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        // запись в текстовый файл с форматированием
        try(PrintWriter pwr = new PrintWriter(fileName)) {
            pwr.append(splitter);
            pwr.append(header);
            pwr.append(splitter);
            for (double x = -3.2; x <= 3.2; x += 0.2) {
                double f = Math.sin(x);
                pwr.format("| %8.3f | %10.7f |\r\n", x, f);
                // pwr.printf("| %8.3f | %10.7f |\r\n", x, f);
            } // foreach
            pwr.append(splitter);
            pwr.flush();  // сброс буфера записи на диск - фактическая запись файла

            System.out.println("demoPrintFile - Форматированный файл записан");
        } catch (IOException ex) {
            ex.printStackTrace();
        }  // try-catch
    } // demoPrintFile

    // пример чтения с парсингом из файла CSV
    private static void demoReadCollection() {
        String fileName = "Persons.txt";
        List<Person> personList = new ArrayList<>();

        try {
            // открыть поток по чтению
            try (Scanner sc = new Scanner(new FileReader(fileName))) {

                String str;               // в эту строку читаем
                while (sc.hasNext()) {    // пока есть, что читать
                    str = sc.nextLine();  // чтение
                    StringTokenizer stz = new StringTokenizer(str, ",");

                    int id = Integer.parseInt(stz.nextToken().trim());
                    String fullName = stz.nextToken().trim();
                    int age = Integer.parseInt(stz.nextToken().trim());

                    personList.add(new Person(id, fullName, age));
                } // while
            } catch (IOException ex) {
                ex.printStackTrace();
            } // try-catch

            System.out.println("\nПрочитано из файла");
            for (Person person : personList)
                System.out.println(person);

            // для демонстрации обработки исключений
            // personList = null;

            personList.sort(Comparator.comparingInt(Person::getId));

            System.out.println("\nОтсортировано по id");
            for (Person person : personList)
                System.out.println(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // demoReadCollection

    // Запись строк - названий цветов в текстовый файл, чтение из этого файла
    // в коллекцию - список строк
    private static void demoReadWrite() {
        String fileName = "data/colors.txt";

        // если папки data нет - создать папку
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        // данные для записи в файл
        String[] colors = {
                "красный",
                "оранжевый",
                "желтый",
                "зеленый",
                "голубой",
                "синий",
                "фиолетовый"
        };

        // запись массива строк в файл
        try(PrintWriter pwr = new PrintWriter(fileName)) {
            for (String str:colors) {
                pwr.println(str);
                // fwr.write("\r\n"); // !!! Не забывайте - перевод строки выполняем сами !!!
            } // foreach
        } catch (IOException ex) {
            ex.printStackTrace();
        } // try-catch

        // чтение из файла в коллекцию строк
        // Слева интерфейс     -- справа класс хранения
        List<String> colorsList = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNext()) {
                colorsList.add(sc.nextLine());
            } // while
        } catch (IOException ex) {
            ex.printStackTrace();
        } // try-catch

        // выводим в консоль то, что прочитали из файла
        System.out.println("\nПрочитано из файла");
        for (String color : colorsList)
            System.out.println(color);

    } // demoFileWriter
}
