package org.itstep.pd011;

public class Main {

    public static void main(String[] args) {
        // создание объекта с коллекцией мобильных телефонов,
        // заполнение коллекции массивом значений
        Mobiles mobiles = new Mobiles(initialize());

        // Меню приложения
        String menu =
            "\n\t\033[1;30;47m    Внутренние классы   \033[0m\n" +
            "\033[1;35m1\033[0m - \033[1mЗадача 1\033[0m, вывод коллекции телефонов\n" +
            "\033[1;35m2\033[0m - \033[1mЗадача 2\033[0m, сортировка коллекции телефонов по производителю\n" +
            "\033[1;35m3\033[0m - \033[1mЗадача 3\033[0m, сортировка коллекции телефонов по убыванию цен\n" +
            "\033[1;35m4\033[0m - \033[1mЗадача 4\033[0m, сортировка коллекции телефонов по возрастанию цен\n" +
            "\033[1;35m5\033[0m - \033[1mЗадача 7\033[0m, сортировка коллекции телефонов по модели\n" +
            "\033[1;35m6\033[0m - \033[1menum\033[0m, анонимные классы в перечислении\n" +
            "\033[1;35m0\033[0m - \033[1mВыход\033[0m\n" +
            "\033[1;34m$$\033[0m  ";

        while (true) {
            // выводим меню и вводим команду меню
            int cmd = Utils.getInt(menu, 0, 8);

            // выполнение команд меню
            switch (cmd) {
                // Задача 1 - телефоны с минимальной и максимальной ценами
                case 1 -> mobiles.show("\nКоллекция мобильных телефонов\n");

                // Задача 4 - сортировка коллекции телефонов по производителю
                case 2 -> mobiles.orderByBrand();

                // Задача 5 - сортировка коллекции телефонов по убыванию цен
                case 3 -> mobiles.orderByPrice(true);

                // Задача 6 - сортировка коллекции телефонов по возрастанию цен
                case 4 -> mobiles.orderByPrice(false);

                // Задача 7 - сортировка коллекции телефонов по модели
                case 5 -> mobiles.orderByModel();

                // Демонстрация анонимного класса в перечислении
                case 6 -> demoEnum();

                // завершение работы приложения
                case 0 -> {
                    Utils.sc.close();
                    System.exit(0);
                }  // case 0
            } // switch

            System.out.println();
        } // while
    } // main

    // заполнение массива телефонов
    private static Mobiles.Mobile[] initialize() {
        return new Mobiles.Mobile[]{
            new Mobiles().new Mobile("Samsung", "A8 2018", 26000),
            new Mobiles().new Mobile("Xiaomi", "Redmi 4X", 8100),
            new Mobiles().new Mobile("Meizu", "M5 Note", 8100),
            new Mobiles().new Mobile("Samsung", "A7 2017", 23000),
            new Mobiles().new Mobile("Nokia", "N8", 26000),
            new Mobiles().new Mobile("Xiaomi", "Redmi 5 Plus", 13200),
            new Mobiles().new Mobile("Lenovo", "K6", 6500),
            new Mobiles().new Mobile("Asus", "Zenfone 5", 13300),
            new Mobiles().new Mobile("BQ", "BQ 4028", 3500),
            new Mobiles().new Mobile("Samsung", "J5 2017", 11000)
        };
    } // initialize

    // демонстрация анонимых классов в перечислении
    private static void demoEnum() {
        int i = 5;
        for (Shape s:Shape.values()) {
            s.setShape(5, i--);
            System.out.printf("%s, площадь:  %.3f\n", s, s.area());
        } // for s
    } // demoEnum
} // class Main
