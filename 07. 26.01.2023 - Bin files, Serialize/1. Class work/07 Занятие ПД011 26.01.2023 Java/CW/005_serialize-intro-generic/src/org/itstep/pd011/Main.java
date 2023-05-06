package org.itstep.pd011;

import org.itstep.pd011.models.Film;
import org.itstep.pd011.models.Films;
import org.itstep.pd011.models.Genre;

import java.util.Arrays;

/*
*
* Cериализация коллекции объектов, описывающих фильм (название, режиссер, жанр,
* год выпуска) и десериализация с использованием обобщенного класса - Serializer<T>
*
* */
public class Main {

    public static void main(String[] args) {
        System.out.println();

        // создать объект на базе массива фильмов
        Films films = new Films(Arrays.asList(
            new Film("Никита", "Михалков Н.", Genre.ACTION, 2010),
            new Film("Звездные врата", "Эммерих Р.", Genre.SCIFI, 1994),
            new Film("Кто я?", "Джеки Чан", Genre.THRILLER, 1998),
            new Film("Троя", "Петерсен В.", Genre.TRAGEDY, 2004),
            new Film("Последний самурай", "Цвик Э.", Genre.THRILLER, 2003)
        ));

        // создать объект сериализации
        String fileName = "app_data/films.dat";
        Serializer<Films> sz = new Serializer<>(fileName);

        // выполнить сериализацию
        sz.serialize(films);
        System.out.printf("Коллекция фильмов:\n%s", films);

        // изменить коллекцию в объекте-контейнере
        films.setAt(0, new Film("Двойной удар", "Леттич Ш.", Genre.THRILLER, 1991));
        films.setAt(1, new Film("Великий Гэтсби", "Лурман Б.", Genre.MELODRAMA, 2013));
        films.setAt(2, new Film("Начало", "Нолан К.", Genre.SCIFI, 2010));
        System.out.printf("\nКоллекция фильмов после изменения:\n%s", films);

        // восстановить объект, контейнер
        films = sz.deserialize();
        System.out.printf("\nКоллекция фильмов после десериалиазации:\n%s", films);

        System.out.println("\n-------------------------------------------------------");

        System.out.println("\nСериализация отдельного фильма:");
        fileName = "app_data/film.dat";
        Serializer<Film> szf = new Serializer<>(fileName);
        Film film = new  Film("Под куполом", "Швайко Р.", Genre.SCIFI, 2015);

        // выполнить сериализацию
        szf.serialize(film);
        System.out.printf("%s\n", film);

        // изменить фильм
        film.setGenre(Genre.TRAGEDY);
        film.setName("Над бездной");
        film.setProduction(1989);
        film.setProducer("Пол Верхувен");
        System.out.printf("%s\n", film);

        // восстановить объект, контейнер
        film = szf.deserialize();
        System.out.printf("%s\n", film);

    } // main
} // class Main
