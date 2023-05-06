package app.models.task02;

import java.util.Date;


// Класс Книга
public class Book {
    // id книги
    private int id;

    public int id() {return id;}

    public int id(int id) throws Exception {
        if (id > 0) return this.id = id;
        throw new Exception("Book: поле Id должно быть больше 0");
    }

    // автор
    private String author;

    public String author() {return author;}

    public String author(String author) throws Exception {
        if (!author.isEmpty()) return this.author = author;
        throw new Exception("Book: поле Author не может быть пустым");
    }

    // название
    private String name;

    public String name() {return name;}

    public String name(String name) throws Exception {
        if (!name.isEmpty()) return this.name = name;
        throw new Exception("Book: поле Name не может быть пустым");
    }

    // год издания
    private int year;

    public int year() {return year;}

    public int year(int year) throws Exception {
//        int maxYear = new Date().getYear() + 1;
//        if (year > 1900 && year <= maxYear) return this.year = year;
//        throw new Exception("Book: поле Year должно быть больше 1900 и меньше, либо равно " + maxYear);
        
        if (year > 1900) return this.year = year;
        throw new Exception("Book: поле Year должно быть больше 1900");
    }

    // количество
    private int amount;

    public int amount() {return amount;}

    public int amount(int amount) throws Exception {
        if (amount > 0) return this.amount = amount;
        throw new Exception("Book: поле Amount должно быть больше 0");
    }


    // конструктор по умолчанию
    public Book() {}

    // конструктор инициализирующий
    public Book(int id, String author, String name, int year, int amount) throws Exception {
        this.id(id);
        this.author(author);
        this.name(name);
        this.year(year);
        this.amount(amount);
    }


    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%d</td><td align='right'>%d</td>",
                id, name, author, year, amount
        );
    }
}
