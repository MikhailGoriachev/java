package org.homework.app.models;

import org.homework.app.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CylinderList {
    private static List<Cylinder> cylinders = new ArrayList<>(List.of(new Cylinder[]{
            new Cylinder(1, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(2, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(3, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(4, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(5, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(6, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(7, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(8, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(9, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list())),
            new Cylinder(10, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(MaterialList.list()))
    }));

    
    // получить список
    public static List<Cylinder> list() {
        return cylinders.stream().toList();
    }
    
    // получить запись по id
    public static Cylinder get(int id) {
        return cylinders
                .stream()
                .filter(m -> m.getId() == id)
                .findAny()
                .orElse(null);
    }

    // добавление элемента
    public static void addItem(Cylinder item) {
        item.setId(cylinders.isEmpty()
                ? 1
                : cylinders.stream().max(Comparator.comparing(Cylinder::getId)).get().getId() + 1);

        cylinders.add(item);
    }

    // изменение элемента
    public static void editItem(Cylinder item) {
        var index = cylinders.indexOf(get(item.getId()));
        cylinders.set(index, item);
    }

    // удаление элемента
    public static void removeItem(int id) {
        cylinders = cylinders
                .stream()
                .filter(c -> c.getId() != id)
                .toList();
    }
}
