package org.itstep.pd011.entities;

import org.springframework.cglib.core.Local;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="year")
    private int year;

    @Column(name="price")
    private int price;

    @Column(name="amount")
    private int amount;

    // связное свойство, имя столбца должно быть author_id
    @ManyToOne
    private Author author;

    // связное свойство, имя столбца должно быть category_id
    @ManyToOne
    private Category category;

    public Book() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("\t| %3d | %-50s | %4d г. | %5d.00 р. | %3d шт. | %-15s | %-10s |",
                id, title, year, price, amount, author.getName(), category.getCategory());
    }
}
