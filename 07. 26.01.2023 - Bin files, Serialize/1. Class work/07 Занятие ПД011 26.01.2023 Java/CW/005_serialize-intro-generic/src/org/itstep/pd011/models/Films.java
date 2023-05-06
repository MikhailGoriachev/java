package org.itstep.pd011.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// коллекция фильмов
public class Films implements Serializable {
    private List<Film> films;

    public Films(List<Film> films) {
        this.films = new ArrayList<>();
        this.films.addAll(films);
    } // Films

    public Films(Film[] films) {
        this.films = new ArrayList<>();
        this.films.addAll(Arrays.asList(films));
    } // Films

    // чтение элемента коллекции
    public Film getAt(int index) {
        if (index < 0 || index >= films.size())
            throw new IndexOutOfBoundsException("Индекс фильма вышел за пределы массива фильмов при чтении");

        return films.get(index);
    } // getAt

    // запись элемента коллекции
    public void setAt(int index, Film film) {
        if (index < 0 || index >= films.size())
            throw new IndexOutOfBoundsException("Индекс фильма вышел за пределы массива фильмов при записи");

        films.set(index, film);
    } // setAt

    // вывод строкового представления массива фильмов
    @Override public String toString() {
        StringBuilder sbf = new StringBuilder();

        for (Film film:films) {
            sbf.append(film).append('\n');
        } // foreach
        return sbf.toString();
    } // toString
} // class Films
