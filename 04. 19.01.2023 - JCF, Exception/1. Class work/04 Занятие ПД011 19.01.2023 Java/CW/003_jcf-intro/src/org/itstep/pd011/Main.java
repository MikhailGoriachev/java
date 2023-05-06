package org.itstep.pd011;

import java.util.*;
import java.util.function.Consumer;
/*
 * JCF - Java Collection Framework
 * коллекция интерфейсов, классов для работы с контейнерами данных
 *
 * набор методов для работы с контейнерными типами данных (списки, очереди, стеки,
 * деки, множества, деревья, словари, ...)
 *
 * методы коллекций:
 * add() - добавить элемент в коллекцию
 * addAll(коллекция) - добавить все элементы одной коллекции в другую коллекцию
 * remove() - удалить элемент из коллекции
 * removeAll(коллекция) - удалить все элементы, входящие в коллекцию из другой коллекции
 *
 * contains()              - есть ли вхождение элемента в коллекцию
 * containsAll(коллекция)
 *
 * size()    - размер коллекции
 * toArray() - преобразовать коллекцию в массив
 *
 * isEmpty() - проверка на пустую коллекцию
 *
 * Интерфейсы
 * Collection - базовый интерфейс
 * List  - список
 * Queue - очередь FIFO - First In First Out
 * Deque - дек - двунаправленная очередь - скоростной доступ к данным
 *
 * Set     - множество, сохраняет только уникальные значения
 * SortSet - множество, но с сохранением порядка добавления элементов
 *
 * Классы для хранения данных (generic class)
 * ArrayList  - простой список
 * Stack      - стек LIFO - Last In First Out
 * ArrayDeque - двунаправаленная очередь
 * HashSet    - хэшированное множество - пары "ключ - значение", но
 *              в качестве ключа выступает хэш-функция
 * TreeSet    - дерево элементов, упорядоченное множество
 * HashMap    - отображение, словарь, пары "ключ - значение"
 *              удобнее, чем HashSet
 * TreeMap    - дерево, хранящее пары "ключ - значение"
 *
 * */

public class Main {

    public static void main(String[] args) {

        // demoArrayList();

        // stackDemo();

        // hashSet();

        // treeSetDemo();

        // hashMapDemo();

        collectionsDemo();
    } // main

    // region Демонстрация List, ArrayList
    // List -- ArrayList
    private static void demoArrayList() {
        // ArrayList<String> arrayList = new ArrayList<>();
        // слева интерфейс - справа реализация
        List<String> arrayList = new ArrayList<>();
        String[] colors = new String[] {
            "белый", "желтый", "янтарный", "лавандовый",
            "зеленый", "антик-белый", "серый"
        };

        // заполнение и вывод в консоль
        arrayList.addAll(Arrays.asList(colors));

        arrayList.addAll(Arrays.asList(
            "белый", "желтый", "янтарный", "лавандовый",
             "зеленый", "антик-белый", "серый")
        );

        arrayList.add("красный");
        arrayList.add("синий");

        // for (String color:colors) { arrayList.add(color); } // foreach
        showArrayList(arrayList, "ArrayList:\n");

        // пример лямбда-выражения
        // arrayList.sort((o1, o2) -> o1.compareTo(o2));
        arrayList.sort(new Comparator<String>() {
            // o1 <  o2 -->   < 0
            // o1 == o2 -->  == 0
            // o1 >  o2 -->   > 0
            @Override public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        showArrayList(arrayList, "\nПо алфавиту:\n");

        // сортировка по убыванию длины слов
        // arrayList.sort((o1, o2) -> o2.length() - o1.length());
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        showArrayList(arrayList, "\nПо убыванию длин строк:\n");

        // сортировка по возрастанию длины строк
        //  arrayList.sort((o1, o2) -> o1.length() - o2.length());
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        showArrayList(arrayList, "\nПо возрастанию длин строк:\n");


        // поиск и удаление
        // contains(), indexOf(), remove() - по индексу и по объекту

        // только для демонстрации indexOf()
        if (arrayList.contains("серый")) {
            arrayList.remove("серый");
        }

        // более простой вариант - удаление по значению объекта (только первый найденный)
        if (arrayList.contains("антик-белый")) arrayList.remove("антик-белый");
        showArrayList(arrayList, "удаление выполнено:\n");

        System.out.println("\n---------------------------------------------");
    } // demoArrayList

    // вывести список с использованием forEach
    private static void showArrayList(List<String> arrayList, String s) {
        System.out.print(s);
        // пример лямбда-выражения - изучим позже
        // arrayList.forEach(item -> System.out.printf("\033[34;1m%s\033[0m\n", item));

        // использование анонимного класса
        arrayList.forEach(new Consumer<String>() {
            @Override // item - очередной элемент списка
            public void accept(String item) {
                System.out.printf("\033[34;1m%s\033[0m\n", item);
            } // accept
        });
        System.out.println();
    } // showArrayList
    // endregion

    //region Демонстрация Stack
    private static void stackDemo() {
        // Стек чисел Integer
        Stack<Integer> stack = new Stack<>();

        // заполнить
        stack.addAll(Arrays.asList(2, 6, 7, 8));
        stack.push(-1);

        // вывести
        showStack("\nСтек: ", stack);

        // удалить из вершины стека
        int t = stack.pop();
        System.out.printf("\nС вершины стека удалили %d\n", t);
        showStack("\nСтек: ", stack);

        // нарушение парадигмы стека - удаление произвольного элемента из стека
        t = 6;
        System.out.printf("\nУдаление %d из произваольного места стека\n", t);
        stack.remove(Integer.valueOf(t));
        showStack("\nСтек: ", stack);
    } // stackDemo

    // вывод стека
    private static void showStack(String title, Stack<Integer> stack) {
        System.out.print(title + "X <- ");
        stack.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer item) {
                System.out.printf("%d <- ", item);
            } // accept
        });
        System.out.println("T");
    } // showStack
    //endregion

    // хэшсет - хранит пары "ключ - значение", ключ это значение некоторой хэш-функции,
	// т.е. некоторое число, формируемое по хранимому значению.
    // хэш-функция рассчитывается прозрачно, т.е. незаметно для программиста
     private static void hashSet() {
         HashSet<String> hashSet = new HashSet<>();

         hashSet.add("Саратов");
         hashSet.add("Адлер");
         hashSet.add("Макеевка");  // добавляется только один элемент
         hashSet.add("Макеевка");
         hashSet.add("Харцызск");
         hashSet.add("Харцызск");
         hashSet.add("Харцызск");
         hashSet.add("Амвросиевка");

         System.out.println("\nHashSet:");
         hashSet.forEach(new Consumer<String>() {
             @Override
             public void accept(String s) {
                 System.out.println(s);
             }
         });
         // for (String s:hashSet) {
         //     System.out.println(s);
         // } // foreach
    } // hashSet

    // упорядоченное дерево
    private static void treeSetDemo() {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Саратов");
        treeSet.add("Антрацит");
        treeSet.add("Макеевка");
        treeSet.add("Макеевка");    // дубликаты не записываются
        treeSet.add("Ясиноватая");
        treeSet.add("Харцызск");
        treeSet.add("Иловайск");
        treeSet.add("Обрыв");
        treeSet.add("Амвросиевка");

        System.out.println("\nTreeSet:");
        for (String s:treeSet) {
            System.out.println(s);
        } // foreach

        System.out.println("\nВывод treeSet циклом \033[1mwhile\033[0m с использованием \033[34;1mитератора:\033[0m");
        // итератор получает доступ к элементам дерева
        Iterator<String> iter = treeSet.iterator();
        while(iter.hasNext()) {
            System.out.printf("%-15s", iter.next());
        }
        System.out.println();

        System.out.println("\nВывод treeSet при помощи цикла \033[34;1mforeach:\033[0m");
        for(String item: treeSet)
            System.out.printf("%-15s", item);

        // коллекция строк - номеров автобусных маршрутов - проверяем сортировку
        // такой коллекции строк
        treeSet.clear();
        treeSet.addAll(Arrays.asList("88", "122", "16а", "23", "1", "76б", "11", "3", "7", "21"));
        System.out.println("\n\nСортировка строк - представлений чисел:");
        for(String item: treeSet)
            System.out.printf("%-15s", item);
    } // treeSetDemo

    // HashMap - отображение, словарь, пары "ключ - значение"
    private static void hashMapDemo() {
        HashMap<Integer, String> cities = new HashMap<>();
        // пары - идентификатор города и название города
        cities.put(5,   "Саратов");
        cities.put(12,  "Адлер");
        cities.put(3,   "Макеевка");
        // cities.put(3,   "Минеральное");  // запись нового значения поверх старого для ключа 3
        cities.put(4,   "Макеевка");
        cities.put(6,   "Харцызск");
        cities.put(1,   "Харцызск");
        cities.put(100, "Амвросиевка");

        // вывести элементы отображения
        System.out.print("\nHashMap - значения: ");
        for (var city:cities.values()) {
            System.out.printf("%-15s", city);
        } // foreach

        System.out.print("\nHashMap - ключи   : ");
        for (var key:cities.keySet()) {
            System.out.printf("%-15d", key);
        } // foreach
        System.out.println();

        // классический способ перебора значений
        System.out.println("\nВывод элементов коллекции при помощи Map.Entry");
        // for (Map.Entry<Integer, String> city:cities.entrySet()) {
        for (var city:cities.entrySet()) {
            // System.out.println(city);
            // возможно также изменить значение элемента имя.setValue()
            System.out.printf("%5d --> %-15s\n", city.getKey(), city.getValue());
        } // foreach

        // попытка выбрать из коллекции названия городов, упорядочить названия
        // по алфавиту, вывести названия гоордов в одну строку
        System.out.println();

        Object[] citiesName = cities.values().toArray();
        Arrays.sort(citiesName, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        for (var c:citiesName) {
            System.out.print(c + " ");
        }
        System.out.println();

        List citiesAsList = Arrays.asList(cities.values().toArray());  // выборка данных сортировка
        // Либо сортируем методом класса Collections либо напрямую методом List
//        Collections.sort(citiesAsList, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((String)o1).compareTo((String)o2);
//            }
//        });

        citiesAsList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });

        citiesAsList.forEach(new Consumer() {                         // вывод
            @Override // действие для каждого элемента коллекции citiesAsList
            public void accept(Object o) {
                System.out.print((String)o + " ");
            }
        });

    } // hashMapDemo


    // Методы класса Collections
    private static void collectionsDemo() {
        List<String> list = new ArrayList<>(Arrays.asList("Саратов", "Адлер", "Макеевка", "Луганское", "Харцызск", "Снежное"));
        list.add("Амвросиевка");
        showArrayList(list, "\nСписок городов:\n");

        Collections.sort(list);
        showArrayList(list, "\nСписок городов по алфавиту:\n");

        Collections.reverse(list);
        showArrayList((ArrayList<String>) list, "\nСписок городов против алфавита:\n");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        showArrayList(list, "\nСписок городов по длине названия:\n");

        Collections.shuffle(list);
        showArrayList(list, "\nПеремешанный список городов:\n");

        Collections.fill(list, "Неизвестно");
        showArrayList(list, "\nСписок городов :) :) :\n");
    } // collectionsDemo
}
