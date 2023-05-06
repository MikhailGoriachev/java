package org.homework.app.models;


// Класс Книга
public class Book {
    
    // id
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // формат (EPUB, FB2, PDF, DJVU, …)
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    // автор
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // название
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    // размер в байтах
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // год создания
    private int pubYear;

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
    
    
    // конструктор по умолчанию
    public Book() {
    }
    
    // конструктор инициализирующий
    public Book(int id, String format, String author, String title, int size, int pubYear) {
        this.setId(id);
        this.setFormat(format);
        this.setAuthor(author);
        this.setTitle(title);
        this.setSize(size);
        this.setPubYear(pubYear);
    }

    
    // строковое представление
    public String toTableRow() {
        return String.format("\t| %2d | %-10s | %-20s | %-40s | %13d | %4d |\n",
               id, format, author, title, size, pubYear);
    }
}
