package org.homework.app.models;

import java.util.ArrayList;
import java.util.List;

public class TabletList {
    public static List<Tablet> tablets = new ArrayList<>(List.of(new Tablet[]{
            new Tablet("планшет", "LG", 2021, "Android 12", 30_000),
            new Tablet("ноутбук", "Lenovo", 2019, "Windows 11", 60_000),
            new Tablet("ноутбук", "Samsung", 2016, "Windows 10", 45_000),
            new Tablet("ноутбук", "Acer", 2016, "Windows 8.1", 45_000),
            new Tablet("ноутбук", "Acer", 2016, "Windows 7", 48_000),
            new Tablet("ноутбук", "Acer", 2018, "Windows 10", 36_000),
            new Tablet("планшет", "Lenovo", 2022, "Android 13", 40_000),
            new Tablet("планшет", "Samsung", 2022, "Android 13", 54_000),
            new Tablet("планшет", "LG", 2021, "Android 12", 30000),
    }));
}
