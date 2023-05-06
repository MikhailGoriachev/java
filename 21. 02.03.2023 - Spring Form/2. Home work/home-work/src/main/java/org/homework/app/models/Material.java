package org.homework.app.models;

// Класс Материал
public class Material {
    
    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // плотность 
    private double density;

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    // название
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // файл изображения
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    // конструктор по умолчанию
    public Material() {
    }

    // конструктор инициализирующий
    public Material(int id, double density, String name, String file) {
        this.setId(id);
        this.setDensity(density);
        this.setName(name);
        this.setFile(file);
    }
}
