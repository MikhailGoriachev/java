package org.itstep.pd011.models;

import java.io.Serializable;

/**
 * Перечисление, описывающее жанры фильмов
 */
public enum Genre implements Serializable {
    NONE("без жанра"),
    COMEDY("комедия"),
    TRAGEDY("трагедия"),
    THRILLER("фильм ужасов"),
    ACTION("боевик"),
    MELODRAMA("мелодрама"),
    SCIFI("фантастика");

    private String genre;
    Genre(String genre) { this.genre = genre; }

    @Override public String toString() { return genre; } // toString
} // Genre
