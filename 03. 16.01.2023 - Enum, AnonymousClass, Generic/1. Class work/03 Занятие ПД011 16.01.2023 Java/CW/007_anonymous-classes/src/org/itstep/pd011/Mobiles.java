package org.itstep.pd011;

import java.util.Arrays;
import java.util.Comparator;

// Класс Mobiles с внутренним классом Mobile, описывающим мобильные
// телефоны (фирма-разработчик, название модели, стоимость).
//
// В классе Mobiles хранить массив из 10 элементов Mobile - коллекцию
// мобильных телефонов.
//
// Обработки для объекта класса Mobiles:
//     a) сформировать и вывести массив (коллекцию) телефонов
//     b) вывести модели с минимальной и максимальной ценой в коллекции
//        телефонов
//     с) найти суммарную стоимость телефонов коллекции
public class Mobiles {
    final int N_SIZE = 10; // размер массива телефонов по заданию
    Mobile[]  mobiles;     // коллекция телефонов по заданию

    // поле интерфейсного типа для сравнения двух объектов
    // класса Mobile по наименованию производителей
    // синтаксис Comparator<Mobile> означает, что интерфейс Comparator
    // как-то настраивается на тип Mobile
    private Comparator<Mobile> comparatorBrand = new Comparator<>() {
        // универсальный метод сравнения - реализация интерфейса Comparator
        // a   b
        // 3 - 4 = -1  разность <  0 ==>   a  < b
        // 3 - 3 =  0  разность == 0 ==>   a == b
        // 4 - 3 =  1  разность >  0 ==>   a  > b
        @Override
        public int compare(Mobile mobile1, Mobile mobile2) {
            // str1.compareTo(str2) - сравнивает строки str1, str2
            // и возвращает результат по правилам compare()
            // Если строка ближе к началу алфавита, она меньше сравниваемой строки
            // Буква верхнего регистра меньше буквы нижнего регистра
            // str1      str2
            // ананас  < банан   результ compareTo(): -1
            // ананас == ананас  результ compareTo():  0
            // банан   > ананас  результ compareTo():  1
            return mobile1.getBrand().compareTo(mobile2.getBrand());
        } // compare
    };

    // конструкторы класса
    public Mobiles() { mobiles = new Mobile[N_SIZE]; }
    public Mobiles(Mobile[] mobiles) {
        // защита от массива неправильного размера
        if (mobiles.length != N_SIZE) {
            System.out.println("\n\033[31;1mОшибка - массив данных недопустимого размера. Аварийное завершение\n\033[0m");
            System.exit(1); // завершение приложения с кодом 1
            // Традиционно коды завершения 0 - Ок
            //                             1 - Неисправность, ошибка
            //                             2 - Ошибка записи
            //                             4 - Ошибка чтения
            //                             5 - Ошибка доступа, запрет доступа к ресурсу
            //                             ...
            return;  // этот оператор никогда не исполнится
        } // if
        this.mobiles = mobiles;
    } // Mobiles

    /////////////////////////////////////////////////////////////////////////
    // обработка по заданию

    // вывод коллекции телефонов в табличном формате
    public void show(String title) {

        // заголовок таблицы
        System.out.println(title + SPLITTER + "\n" + HEADER + "\n" + SPLITTER);

        // выводим элементы массива (коллекции) телефонов
        for(Mobile phone:mobiles) {
            System.out.println(phone.toTableRow());
        } // for phone

        // вывод строки, закрывающей таблицу
        System.out.println(SPLITTER);
    } // show


    // вывести модели с минимальной и максимальной ценой в коллекции телефонов
    public void showMinMaxPrice(String title) {
        int minPrice = getMinPrice();
        int maxPrice = getMaxPrice();

        // заголовок таблицы
        System.out.println(title + SPLITTER + "\n" + HEADER + "\n" + SPLITTER);
        for(Mobile phone:mobiles) {
            // выводим только телефоны с минимальной или максимальной ценой
            int price = phone.getPrice();
            if (price == minPrice || price == maxPrice)
                System.out.println(phone.toTableRow());
        } // for phone

        // вывод строки, закрывающей таблицу
        System.out.println(SPLITTER);
    } // showMinMaxPrice


    // вычисление суммарной стоимости телефонов коллекции
    public int amountPrice() {
        int amount = 0;
        for(Mobile phone: mobiles)
            amount += phone.getPrice();
        return amount;
    } // amountPrice


    // вывод коллекции телефонов с суммарной стоимостью коллекции
    public void showAmount(String title) {
        int amount = amountPrice();

        show(title);
        System.out.printf("Суммарная цена коллекции:                      %10d\n", amount);
    } // showAmount

    // получить минимальную цену телефона в коллекции
    private int getMinPrice() {
        // начальное значение минимальной цены
        int minPrice = mobiles[0].getPrice();

        // поиск минимальной цены в коллекции - стандартный метод
        // текущего минимума
        for (int i = 1; i < N_SIZE; i++) {
            if (mobiles[i].getPrice() < minPrice)
                minPrice = mobiles[i].getPrice();
        } // for i

        // вернуть найденную минимальную цену
        return minPrice;
    } // getMinPrice

    // получить максимальную цену телефона в коллекции
    private int getMaxPrice() {
        // начальное значение максимальной цены
        int maxPrice = mobiles[0].getPrice();

        // поиск максимальной цены в коллекции - стандартный метод
        // текущего максимума
        for (int i = 1; i < N_SIZE; i++) {
            if (mobiles[i].getPrice() > maxPrice)
                maxPrice = mobiles[i].getPrice();
        } // for i

        // вернуть найденную максимальную цену
        return maxPrice;
    } // getMinPrice

    // строка-разделитель и заголовок таблицы вывода телефонов
    static final String SPLITTER = "+-----------------------+--------------------+------------+";
    static final String HEADER   = "| Производитель         | Модель             | Цена, руб. |";

    // сортировка коллекции телефонов по производителю
    public void orderByBrand() {
        // использование члена класса, хранящего ссылку на
        // анонимный класс-компаратор для реализации сравнения
        // строк - названий производителей телефона
        Arrays.sort(mobiles, comparatorBrand);
        show("\nКоллекция телефонов, упорядоченная по производителю\n");
    } // orderByBrand

    // сортировка коллекции телефонов по цене - замыкание desc в анонимном классе
    // desc: true  - по убыванию
    // desc: false - по возрастанию
    public void orderByPrice(boolean desc) {

        // использование анонимного класса - "быстро, но грязно"
        Arrays.sort(mobiles, new Comparator<Mobile>() {
            @Override
            public int compare(Mobile mobile1, Mobile mobile2) {
                // универсальный метод сравнения - реализация интерфейса Comparator
                // a   b
                // 3 - 4 = -1  разность <  0 ==>   a  < b
                // 3 - 3 =  0  разность == 0 ==>   a == b
                // 4 - 3 =  1  разность >  0 ==>   a  > b
                // return mobile1.getPrice() - mobile2.getPrice();
                return desc?mobile2.price - mobile1.price:mobile1.price - mobile2.price;
            } // compare
        });
        show(String.format("\nКоллекция телефонов, упорядоченная по %sанию цен\n", desc?"убыв":"возраст"));
    } // orderByBrand

    // пример явной реализации интерфейса Comparator
    public void orderByModel() {
        // CompareModels compareModels = new CompareModels();
        // Arrays.sort(mobiles, compareModels);
        Arrays.sort(mobiles, new CompareModels());
        show("\nКоллекция телефонов, упорядоченная по модели\n");
    } // orderByModel

    /////////////////////////////////////////////////////////////////////////
    // внутренний класс - описание мобильного телефона
    public class Mobile {
        private String brand;   // фирма-разработчик телефона
        private String model;   // модель телефона
        private int    price;   // стоимость (цена) телефона

        {   // значения полей класса по умолчанию, устанавливаются перед
            // выполнением конструктора, можно распознать такие шаблонные
            // значения
            brand = "~Brand~";
            model = "~Model~";
            price = 1;
        }

        // конструкторы класса

        public Mobile() {  }
        public Mobile(String brand, String model, int price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        } // Mobile

        // Геттеры и сеттеры для полей класса

        public String getBrand() { return brand; }
        public void setBrand(String brand) {
            // для строки метод trim() - отбросить ведущие и хвостовые пробелы
            if (brand == null || brand.trim().isEmpty()) {
                System.out.println("\033[31;1mОшибка: название фирмы-разработчика не может быть пустым\033[0m");
                return;
            } // if
            this.brand = brand;
        } // setBrand

        public String getModel() { return model; }
        public void setModel(String model) {
            // для строки метод trim() - отбросить ведущие и хвостовые пробелы
            if (model == null || model.trim().isEmpty()) {
                System.out.println("\033[31;1mОшибка: название модели телефона не может быть пустым\033[0m");
                return;
            } // if
            this.model = model;
        } // setModel

        public int getPrice() {  return price;  }
        public void setPrice(int price) {
            if (price <= 0) {
                System.out.println("\033[31;1mОшибка: цена модели телефона не может быть нулевой или отрицательной\033[0m");
                return;
            } // if
            this.price = price;
        } // setPrice

        @Override // преобразование полей класса в строковое представление
        public String toString() {
            String str = String.format(
                "Разработчик: \"%s\", модель: \"%s\", цена: %d руб.",
                 brand, model, price
            );
            return str;
        } // toString

        // вывод строки таблицы
        public String toTableRow() {
            return String.format("| %-21s | %-18s | %10d |", brand, model, price);
        } // toString
    } // class Mobile

    // Класс-сравниватель для сортировки массива телефонов
    // по названиям моделей
    class CompareModels implements Comparator<Mobile> {

        @Override
        public int compare(Mobile mobile1, Mobile mobile2) {
            return mobile1.model.compareTo(mobile2.model);
        }
    } // class CompareModels

} // class Mobiles
