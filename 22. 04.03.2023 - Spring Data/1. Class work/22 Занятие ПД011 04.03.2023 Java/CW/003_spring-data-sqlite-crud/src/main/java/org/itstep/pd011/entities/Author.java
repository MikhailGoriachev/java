package org.itstep.pd011.entities;

import javax.persistence.*;

// таблица Authors
@Entity
@Table(name="authors")
public class Author {
    private static final long serialVersionID = -23456678899L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    public Author() { }
    public Author(String name) { this.name = name; }

    public static long getSerialVersionID() {
        return serialVersionID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() { return String.format("\t| %3d | %-15s |", id, name); }


}
