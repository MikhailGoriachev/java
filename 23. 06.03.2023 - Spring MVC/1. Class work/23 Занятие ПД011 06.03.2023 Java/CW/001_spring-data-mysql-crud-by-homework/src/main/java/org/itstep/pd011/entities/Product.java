package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// описание товара
@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // наименование товара
    @Column(name="name", length = 60)
    private String name;

    // предоставляем конструктор по умолчанию
    public Product() {} // Product

    // строковое представление
    @Override
    public String toString() {
        return String.format("Product{%d: \"%s\"}", id, name);
    }
} // class Product
