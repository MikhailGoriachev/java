package org.homework.app.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TabletList {
    private static final List<Tablet> tablets = new ArrayList<>(List.of(new Tablet[]{
            new Tablet(1, "планшет", "LG", 2021, "Android 12", 30_000),
            new Tablet(2, "ноутбук", "Lenovo", 2019, "Windows 11", 60_000),
            new Tablet(3, "ноутбук", "Samsung", 2016, "Windows 10", 45_000),
            new Tablet(4, "ноутбук", "Acer", 2016, "Windows 8.1", 45_000),
            new Tablet(5, "ноутбук", "Acer", 2016, "Windows 7", 48_000),
            new Tablet(6, "ноутбук", "Acer", 2018, "Windows 10", 36_000),
            new Tablet(7, "планшет", "Lenovo", 2022, "Android 13", 40_000),
            new Tablet(8, "планшет", "Samsung", 2022, "Android 13", 54_000),
            new Tablet(9, "планшет", "LG", 2021, "Android 12", 30000),
            new Tablet(10, "ноутбук", "Acer", 2016, "Windows 7", 48_000),
    }));

    // получить список устройств
    public static List<Tablet> getTablets() {
        return tablets.stream().toList();
    }

    // добавление элемента
    public static void addItem(Tablet tablet) {
        tablet.id = tablets.isEmpty()
                ? 1
                : tablets.stream().max(Comparator.comparing(t -> t.id)).get().id + 1;
        
        tablets.add(tablet);
    }
}
