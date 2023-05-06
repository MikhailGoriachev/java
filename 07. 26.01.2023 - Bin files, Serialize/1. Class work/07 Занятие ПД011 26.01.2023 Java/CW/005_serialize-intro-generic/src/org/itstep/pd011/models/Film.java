package org.itstep.pd011.models;

import java.io.Serializable;
import java.security.InvalidParameterException;


public class Film implements Serializable {
    private String name;       // название фильма
    private String producer;   // режиссер фильма
    private Genre  genre;      // жанр фильма
    private int    production; // год выпуска

    public Film() {}
    public Film(String name, String producer, Genre genre, int production) {
        setName(name);         // название фильма устанавливаем с защитой от недопустимых значений
        setProducer(producer); // имя продюсера устанавливаем с защитой от недопустимых значений
        this.genre = genre;    // жанр в защите не нуждаетя - перечисление
        setProduction(production);  // год выпуска фильма также устанавливаем с защитой от недопустимого значения
    } // Film

    // название фильма
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null)
            throw new NullPointerException("Название фильма не может быть null");
        if (name.isEmpty())
            throw new InvalidParameterException("Название фильма не может быть пустым");
        this.name = name;
    } // setName

    // режиссер фильма
    public String getProducer() { return producer; }
    public void setProducer(String producer) {
        if (producer == null)
            throw new NullPointerException("Имя режиссера не может быть null");
        if (producer.isEmpty())
            throw new InvalidParameterException("Имя режиссера должно быть указано");

        this.producer = producer;
    } // setProducer

    // жанр фильма - не требуется защит, т.к. это перечисление
    // с фиксированным набором значений
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    // год выпуска фильма, не допустимы отрицательные значения, 0 - это 2000 год
    public int getProduction() { return production; }
    public void setProduction(int production) {
        if (production < 0)
            throw new InvalidParameterException("Год выпуска фильма не может быть отрицательным");
        this.production = production;
    } // setProduction

    // строковое представление данны по фильму
    @Override public String toString() {
        return String.format("Название \"%s\", режиссер %s, жанр %s, год выпуска: %d",
            name, producer, genre, production);
    } // toString
} // class Film
