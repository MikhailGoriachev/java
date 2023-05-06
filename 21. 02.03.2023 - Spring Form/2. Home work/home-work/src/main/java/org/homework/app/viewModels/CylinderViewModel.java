package org.homework.app.viewModels;

// Класс Цилиндр
public class CylinderViewModel {
    
    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // высота
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // радиус
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // материал
    private int materialId;

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    
    // конструктор по умолчанию
    public CylinderViewModel() {
    }

    // конструктор инициализирующий
    public CylinderViewModel(int id, double height, double radius, int materialId) {
        this.setId(id);
        this.setHeight(height);
        this.setRadius(radius);
        this.setMaterialId(materialId);
    }
}
