package org.itstep.pd011;

// Класс представляет город
public class City {
    private String name;     // название города
    private int population;  // население города

    public City() {this("Новый Свет", 9_000); }
    public City(String name, int population) {

        this.name = name;
        this.population = population;
    } // City

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%-15s: население %d", name, population);
    }

    // простой вывод в консоль
    public void show() { System.out.println(this); } // show
} // class City
