package org.itstep.pd011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* StreamAPI - Java 8 - java.util.stream - упрощение работы с наборами данных / потоками данных
*
* Поток данных    - канал передачи данных из источника данных
* Источник данных - массив, коллекция, файл
*
* Поток не хранит данные
* Поток не изменяет источник данных
*
* Отложенное исполнение
*    - промежуточный метод, возвращает поток, не исполняется сразу
*    - терминальный метод, возвращает скаляр или ничего, исполняет всю цепочку методов
* Широко используются лямбда-выражения
*
* Можно сказать, что StreamAPI очень приблизительно соответствует LINQ C#
*
* Базовый интерфейс - BaseStream (обобщенный)
*
* Что входит в состав Stream API
* IntStream, LongStream, DoubleStream - для примитивных типов
* Stream<T> - поток для ссылочных типов
*
* */
public class Main {

    public static void main(String[] args) {
	    // exampleArray();

        // variant16();

        exampleObject();
    } // main

    // потоки и массивы
    private static void exampleArray() {
        int[] arr = new int[] {1, 2, -4, 6, 7, 0, 0, -5, 3, 2, 1, 7};

        // определить количество четных элементов массива и их сумму - StreamAPI
        long counter = Arrays.stream(arr).filter(x -> (x & 1) == 0).count();
        long sumEven = Arrays.stream(arr).filter(x -> (x & 1) == 0).sum();

        // вывести массив и количество четных элементов в нем - StreamAPI
        // (четные элементы выводим синим цветом)
        Arrays.stream(arr).forEach(x -> System.out.printf("%s%6d\033[0m", x % 2 == 0?"\033[34m":"", x));
        System.out.printf("\nЧетных элементов: %6d, их сумма: %d\n", counter, sumEven);

        // другой вариант - создать поток и вычислять по заданию позже
        // это и есть отложенное выполнение, Lazy Load
        IntStream intStream1 = Arrays.stream(arr).filter(x -> x % 2 == 0);
        IntStream intStream2 = Arrays.stream(arr).filter(x -> x % 2 == 0);
        IntStream intStream3 = Arrays.stream(arr);

        counter = intStream1.count();
        sumEven = intStream2.sum();
        intStream3.forEach(x -> System.out.printf("%s%6d\033[0m", x % 2 == 0?"\033[34m":"", x));
        System.out.printf("\nЧетных элементов: %6d, их сумма: %d\n", counter, sumEven);

        // поиск минимального, максимального элементов
        int min = Arrays
            .stream(arr)   // получить поток из массива
            .min()         // получить минимальный элемент массива
            .getAsInt();   // привести к типу int
        int max = Arrays.stream(arr).max().getAsInt();

        // сумма элементов массива
        int sum = Arrays.stream(arr).sum();

        // сумма только положительных элементов массива
        int sumPos = Arrays.stream(arr).filter(x -> x >= 0).sum();

        // среднее арифметическое элементов массива
        double avg = Arrays.stream(arr).average().getAsDouble();

        // вывод результатов по примерам запросов
        System.out.printf("min = %d; max = %d; sum = %d; sumPos = %d; avg = %.3f\n",
            min, max, sum, sumPos, avg);

        System.out.println("\nРазличные элементы массива:");
        // проверка метода distinct()
        Arrays.stream(arr)
              .distinct()
              .forEach(x -> System.out.printf("%6d", x));
        System.out.println();

        // сортировка массива при помощи потока - вывод в поток без сохранения !!!
        System.out.println("\nОтсортированное представление:");
        Arrays.stream(arr)                                 // получить поток данных из массива
              .sorted()                                    // сортировка потока, но не массива
              .forEach(x-> System.out.printf("%6d", x));   // вывод отсортированного потока

        System.out.print("\nИсходный массив не изменился:\n");
        Arrays.stream(arr).forEach(x -> System.out.printf("%6d", x));

        // присвоить новый массив старому
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.print("\nНовый массив - изменился:\n");
        Arrays.stream(arr).forEach(x -> System.out.printf("%6d", x));

        // -------------------------------------------------------------
    } // exampleArray

    private static void variant16() {
        System.out.println("\nВариант 16:");
        int[] arr = new int[] {7, 5, 5, -3, 3, -4, -2, -1, 4, 2};
        Arrays.stream(arr)
                .forEach(a -> System.out.printf("%6d", a));
        System.out.println();

        long negatives = Arrays
                .stream(arr)
                .filter(x -> x < 0)
                .count();
        System.out.println("\nОтрицательных: " + negatives);

        int[] helper = Arrays.stream(arr).map(Math::abs).toArray();
        int min = Arrays.stream(helper).min().getAsInt();

        // не работает, т.к. тип массива - примитивный
        // List<Integer> arrayList = new ArrayList(Arrays.asList(helper));
        // int imin = arrayList.indexOf(min);

        int imin = -1;
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] == min) {
                imin = i;
                break;
            } // if
        } // for i
        int sum = Arrays.stream(arr).skip(imin+1).sum();
        System.out.println("\nСумма после минимального по модулю: " + sum);

        arr = Arrays
                .stream(arr)
                .map(x -> x < 0?x*x:x)
                .sorted()
                .toArray();
        System.out.println("\nОтсортирован:");
        Arrays.stream(arr)
                .forEach(a -> System.out.printf("%6d", a));
        System.out.println();
    }

	// Потоки ссылочных типов
    private static void exampleObject() {
        List<City> cities = new ArrayList<>(Arrays.asList(
            new City("Макеевка", 400_000),
            new City("Донецк", 900_000),
            new City("Моспино", 12_000),
            new City("Енакиево", 150_000),
            new City("Новый Свет", 12_000),
            new City("Новоазовск", 25_000),
            new City("Молодежное", 21_000),
            new City("Мандрыкино", 8_000),
            new City("Мануйловка", 3_000),
            new City("Курахово", 18_000),
            new City("Старобешево", 32_000),
            new City("Амвросиевка", 20_000)
        ));


        // вывод списка через поток данных
        System.out.println("\n\nГорода:");

        // выводить можно при помощи метода, например e.show()
        // cities.stream().forEach(e -> e.show());
        // выводить можно при помощи toString()
        // cities.stream().forEach(e -> System.out.println(e));
        cities.stream().forEach(System.out::println);

        // filter() - выборка данных
        System.out.println("\nГорода, население которых не превышает 100 000:");
        cities
            .stream()
            .filter(c -> c.getPopulation() <= 100_000) // имена параметров - локальные в вызове метода
            //.forEach(с -> с.show());
            .forEach(City::show);

        // map() - преобразование типа

        // Вывести количество жителей городов, названия которых начинаются с буквы М
        // (Моспино, Макеевка, Молодежное, ...)
        System.out.println("\nЖителей в городах, начинающихся с буквы 'М':");
        cities
            .stream()
            .filter(e -> e.getName().startsWith("М"))
            //.map(e -> e.getPopulation())                 // в д.с. map() возвращает коллекцию типа int
            .map(City::getPopulation)                 // в д.с. map() возвращает коллекцию типа int
            .forEach(System.out::println);

        // Получить названия городов
        System.out.println("\nТолько названия городов, с населением от 20 000 до 200 000:");
        cities
            .stream()
            .filter(c->c.getPopulation() >= 20_000 && c.getPopulation() <= 200_000)  // фильтр по населению
            .map(City::getName)                                                   // только название города
            .forEach(System.out::println);


        // Еще один вариант для map - возвращает список строк
        List<String> cityNames = cities
                .stream()
                .filter(c -> c.getPopulation() >= 20_000 && c.getPopulation() <= 200_000)
                .map(City::getName)
                .toList();  // создание списка из массива

        // вывести список строк в одну строку и отобразить ее одной операцией (потокобезопасный вывод)
        StringBuffer sbNames = new StringBuffer("\nГорода с населением от 20 000 до 200 000:\n");
        cityNames.stream().forEach(c -> sbNames.append(c).append("\n"));
        System.out.println(sbNames);

        // reduce() - пример накопительного алгоритма
        System.out.println("Суммарное население городов, у которых от 20 000 до 200 000 жителей:");
        int total = cities
            .stream()
            .filter(c->c.getPopulation() >= 20_000 && c.getPopulation() <= 200_000) // фильтр по населению
            .map(City::getPopulation)                                            // только население города
            // acc - предыдущий, накоапленный результат
            // item - текущий элемент потока
            .reduce((acc, item) -> acc + item)  // acc = acc + item - накопление суммы по населению
            .get(); // выполнение запроса - соответствует шаблону LazyLoad - отложенное исполнение
        System.out.println(total);

        // еще один пример на reduce()
        System.out.println("\nСуммарное население городов больше 100 000 жителей: ");
        total = cities
                .stream()
                .filter(c -> c.getPopulation() > 100_000)
                .map(City::getPopulation)
                .reduce((acc, item) -> acc + item)
                .get();
        System.out.println(total);

    } // exampleObject
} // class Main
