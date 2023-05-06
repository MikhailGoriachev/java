package org.itstep.pd011;

/**
 * Демонстрационный класс - передача ссылки на метод
 * один из методов класса (isDemoClassNegative) будем
 * передавать параметром другого метода
 *
 * */
public class DemoClass {
    private String str;

    public DemoClass()           { this("Это строка"); }
    public DemoClass(String str) { this.str = str; }
    public DemoClass(int a)      { this.str = String.valueOf(a); }

    // метод для передачи в качестве параметра другому методу
    // никаких особенностей в объявлении такого метода нет
    public boolean isDemoClassNegative(int x) { return x < 0; }
    public boolean isDemoClassPositive(int x) { return x > 0; }
} // class DemoClass
