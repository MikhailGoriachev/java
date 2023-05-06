package org.homework.app.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaterialList {
    private static final List<Material> materials = new ArrayList<>(List.of(new Material[]{
            new Material(1, 8_960d, "Медь", "copper.jpg"),
            new Material(2, 7_700d, "Сталь", "steel.jpg"),
            new Material(3, 2_520d, "Базальт", "basalt.jpg"),
            new Material(4, 916.7, "Водяной лёд", "ice.jpg")
    }));

    
    // получить список
    public static List<Material> list() {
        return materials.stream().toList();
    }

    // получить запись по id
    public static Material get(int id) {
        return materials
                .stream()
                .filter(m -> m.getId() == id)
                .findAny()
                .orElse(null);
    }
}
