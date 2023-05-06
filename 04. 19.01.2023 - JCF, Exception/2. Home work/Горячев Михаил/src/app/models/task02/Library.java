package app.models.task02;


import app.utils.Utils;

import java.util.*;

// Класс Библиотека
public class Library {

    // коллекция книг
    public HashMap<Integer, Book> books;

    // лимит книг
    final int LIMIT_BOOKS = 12;

    // название
    public String name;

    // адрес
    public String address;


    // конструктор по умолчанию
    public Library() throws Exception {
        name = "Кинодар";
        address = "ул. Книжная 42";
        books = new HashMap<>();
        initialization();
    }

    // конструктор инициализирующий
    public Library(HashMap<Integer, Book> books, String name, String address) {
        this.books = books;
        this.name = name;
        this.address = address;
    }


    // инициализация коллекции
    public void initialization() throws Exception {
        var d = new Book[]{
                new Book(1, "Джон Сонмез", "Путь программиста", 2016, Utils.getInt(10, 15)),
                new Book(2, "Ямамото Цунэтомо", "Путь самурая (Хагакурэ)", 2019, Utils.getInt(10, 15)),
                new Book(3, "Стив Макконнелл", "Совершенный код", 1993, Utils.getInt(10, 15)),
                new Book(4, "Эрвин Кнут", "Искусство программирования", 1968, Utils.getInt(10, 15)),
                new Book(5, "Кент Бек", "Refactoring", 1999, Utils.getInt(10, 15)),
                new Book(6, "Брюс Эккель", "Философия Java", 1998, Utils.getInt(10, 15)),
                new Book(7, "Анна Фролова", "Собачье счастье", 2021, Utils.getInt(10, 15)),
                new Book(8, "Чиннатхамби Кирупа", "JavaScript с нуля", 2021, Utils.getInt(10, 15)),
                new Book(9, "Эрих Гамма", "Design Patterns", 1994, Utils.getInt(10, 15)),
        };

        books.clear();
        new ArrayList<>(List.of(d)).forEach(a -> books.put(a.id(), a));
    }

    // добавление данных о книгах, вновь поступающих в библиотеку
    public void add(Book book) throws Exception {
        if (LIMIT_BOOKS <= books.size())
            throw new Exception("Library: добавление невозможно, достигнут лимит книг");

        var id = books.isEmpty()
                ? 1 
                : Collections.max(books.values(), Comparator.comparingInt(Book::id)).id() + 1;
        
        book.id(id);
        books.put(id, book);
    }

    // удаление данных о списываемых книгах
    public void remove(int id) {
        books.remove(id);
    }

    // выдача сведений о всех книгах, упорядоченных по авторам
    public List<Book> orderByAuthor() {
        var list = new ArrayList<>(books.values());

//        list.sort((a, b) -> a.author().compareTo(b.author()));
        list.sort(Comparator.comparing(Book::author));

        return list;
    }


    // выдача сведений о всех книгах, упорядоченных по убыванию года издания
    public List<Book> orderByYearDesc() {
        var list = new ArrayList<>(books.values());

        list.sort((a, b) -> Integer.compare(b.year(), a.year()));

        return list;
    }

    // выдача сведений о всех книгах, упорядоченных по возрастанию количества
    public List<Book> orderByAmountAsc() {
        var list = new ArrayList<>(books.values());

//        list.sort((a, b) -> Integer.compare(a.amount(), b.amount()));
        list.sort(Comparator.comparingInt(Book::amount));

        return list;
    }

    // выдача сведений о всех книгах, упорядоченных по названию
    public List<Book> orderByName() {
        var list = new ArrayList<>(books.values());

//        list.sort((a, b) -> a.name().compareTo(b.name()));
        list.sort(Comparator.comparing(Book::name));

        return list;
    }

    // вывод в таблицу
    public String libraryToTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<td colspan='2'>Название: ").append(name).append("</td>")
                .append("<td colspan='2'>Адрес: ").append(address).append("</td>")
                .append("<td>Лимит: ").append(LIMIT_BOOKS).append("</td>")
                .append("</tr><tr>")
                .append("<th>Id</th>")
                .append("<th>Название</th>")
                .append("<th>Автор</th>")
                .append("<th>Год издания</th>")
                .append("<th>Количество</th>")
                .append("</thead><tbody>");

        books.values().forEach(b -> sb.append(b.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
    
    // вывод в таблицу
    public static String booksToTable(Collection<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Название</th>")
                .append("<th>Автор</th>")
                .append("<th>Год издания</th>")
                .append("<th>Количество</th>")
                .append("</thead><tbody>");

        books.forEach(b -> sb.append(b.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
