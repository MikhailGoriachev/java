package org.homework.app.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TabletList {
    private static List<Tablet> tablets = new ArrayList<>(List.of(new Tablet[]{
            new Tablet(1, "планшет", "LG", 2021, "Android", 30_000),
            new Tablet(2, "ноутбук", "Lenovo", 2019, "Windows", 60_000),
            new Tablet(3, "ноутбук", "Samsung", 2016, "Windows", 45_000),
            new Tablet(4, "ноутбук", "Acer", 2016, "Windows", 45_000),
            new Tablet(5, "ноутбук", "Acer", 2016, "Windows", 48_000),
            new Tablet(6, "ноутбук", "Acer", 2018, "Windows", 36_000),
            new Tablet(7, "планшет", "Lenovo", 2022, "Android", 40_000),
            new Tablet(8, "планшет", "Samsung", 2022, "Android", 54_000),
            new Tablet(9, "планшет", "LG", 2021, "Android", 30000),
            new Tablet(10, "ноутбук", "Acer", 2016, "Windows", 48_000),
    }));

    
    // получить список устройств
    public static List<Tablet> list() {
        return tablets.stream().toList();
    }
    
    // получить запись по id
    public static Tablet get(int id) {
        return tablets
                .stream()
                .filter(m -> m.getId() == id)
                .findAny()
                .orElse(null);
    }
    
    // гаджеты по убыванию цены
    public static List<Tablet> getTabletsByPriceDesc() {
        return tablets
                .stream()
                .sorted((a, b) -> Integer.compare(b.getPrice(), a.getPrice()))
                .toList();
    }
    
    // гаджеты по типу
    public static List<Tablet> getTabletsByTypeAsc() {
        return tablets
                .stream()
                .sorted(Comparator.comparing(Tablet::getType))
                .toList();
    }
    
    // гаджеты по производителю
    public static List<Tablet> getTabletsByManufactureAsc() {
        return tablets
                .stream()
                .sorted(Comparator.comparing(Tablet::getManufacture))
                .toList();
    }    
    
    // гаджеты по операционной системе
    public static List<Tablet> getTabletsBySystem() {
        return tablets
                .stream()
                .sorted(Comparator.comparing(Tablet::getSystem))
                .toList();
    }
    
    // добавление элемента
    public static void addItem(Tablet tablet) {
        tablet.setId(tablets.isEmpty()
                ? 1
                : tablets.stream().max(Comparator.comparing(Tablet::getId)).get().getId() + 1);

        tablets.add(tablet);
    }

    // изменение элемента
    public static void editItem(Tablet item) {
        var index = tablets.indexOf(get(item.getId()));
        tablets.set(index, item);
    }

    // удаление элемента
    public static void removeItem(int id) {
        tablets = tablets
                .stream()
                .filter(c -> c.getId() != id)
                .toList();
    }
}
