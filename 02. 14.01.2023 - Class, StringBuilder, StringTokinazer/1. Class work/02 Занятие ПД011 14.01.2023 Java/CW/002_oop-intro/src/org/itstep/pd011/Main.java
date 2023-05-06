package org.itstep.pd011;

// при демонстрации сортировки массива объектов
// import java.util.Arrays;
// import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // создание и вывод объекта класса
        // demo0();

        // инкапсуляция, полиморфизм, наследование
        // demo1();

        // Пример работы с объектом, массивом объектов
        demo2();
    } // main

    // создание и вывод объекта класса
    private static void demo0() {
        Mobile mobile = new Mobile("Samsung A51", 2020, 25000);
        System.out.println(mobile);

        mobile = new Mobile();
        System.out.println(mobile);
    } // demo0

    // инкапсуляция, полиморфизм, наследование
    private static void demo1() {
        Base obj = new Derive();  // полиморфизм и наследование

        // при добавлении объекта к строке неявно вызывается toString
        System.out.println("Это объект класса Derive: " + obj);
        System.out.printf("Это объект класса Derive: %s\n", obj);

        // неполиморфные вызовы методов, раннее связывание присутствует
        obj.setA(100);
        obj.setB(-15.56);
        // obj.setC(); //- невозможен, т.к. базовый класс про него не знаеи
        System.out.printf("Это объект класса Derive: %s\n", obj);

        // полиморфизм, позднее связывание
        System.out.print("\nПозднее связывание, полиморфный вызов bar():");
        obj.bar();   // позднее связывание
        System.out.println();

        System.out.print("\n-----------------------------------------\n");

        // Раннее связывание, без полиморфизма
        Derive derive = new Derive();
        System.out.printf("Это объект класса Derive: %s\n", derive);
        derive.setA(12);
        derive.setB(-3.5);
        derive.bar();
        derive.c = "Новая строка в объекте derive";
        System.out.printf("Измененный объект класса Derive: %s\n", derive);

        derive = new Derive(101, -9.82, "Строка текста 1");
        System.out.printf("Новый объект класса Derive: %s\n", derive);
        System.out.print("\n-----------------------------------------\n");

        // Демо - вызов интерфейсных методов, реализации абстрактного метода
        Example ex = new Example();
        System.out.printf("%s; %d; %s\n", ex, ex.twice(), ex.text(10.));
        ex.bar();  // INewFeature
        ex.foo();

        // Полиморфизм на уровне интерфейсного типа
        IBase ib = ex;  // допустимо, т.к. Example реализует интерфейс IBase

        // вызовы методов интерфейса
        String str = ib.text(150);
        int r = ib.twice();

        // надо же что-то сделать с полученными значениями - выводим в консоль
        System.out.printf("\nstr: %s; r = %d\n", str, r);

        INewFeatures newFeatures = ex;
        r = newFeatures.twice();
        int t = newFeatures.summa(1, 5);
        System.out.printf("\nr = %d; t = %d\n", r, t);

        // вызов static-метода интерфейса
        INewFeatures.bar();
    } // demo1

    // Пример работы с объектом, массивом объектов
    private static void demo2() {
        System.out.println("\n\nРабота с классом Person:");
        Person person = new Person("Петрова Е.Н.", 34, 15000);
        System.out.println(person);

        // проблема - некорректные значения, поэтому нужны сеттеры
        // person.age = -1;
        // person.setAge(-1);
        // person.salary = -1;
        // person.setSalary(-1);

        // массив объектов
        Person[] people = new Person[] {
            new Person("Петрова Е.Н.", 34, 15000),
            new Person("Иванов А.Л.", 45, 12000),
            new Person("Петрова К.У.", 21, 17000),
            new Person("Лымарь Ш.К.", 22, 10400),
            new Person("Тимофеева Б.Н.", 25, 14000),
        };
        showPeople("\nМассив объектов:", people);

        // поиск человека с минимальным возрастом, получаем ссылку
        // на персону с минимальным возрастом
        Person minAge = getMinAgePerson(people);
        System.out.println("\nСамый младший это: " + minAge);

        minAge.salary = 23_000;
        showPeople("\nИзменили minAge", people);

        // упорядочить массив объектов по убыванию оклада
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.salary < o1.salary?-1:o2.salary > o1.salary?1:0;
            }
        });

        // лямбда-выражение - аноноимная реализация функционального интерфейса (в еотором
        // определен единственный метод), Comparator - функциональный интерфейс
        // Arrays.sort(people, (o1, o2) -> o2.salary < o1.salary?-1:o2.salary > o1.salary?1:0);
        Arrays.sort(people, (o1, o2) -> Double.compare(o2.salary, o1.salary));

        // orderPeopleBySalaryDesc(people);
        showPeople("\nМассив объектов по убыванию оклада:", people);
    } // demo2

    // пока что сортируем массива объектов "классически"
    private static void orderPeopleBySalaryDesc(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                if (people[j].getSalary() < people[j+1].getSalary()) {
                    Person t = people[j];
                    people[j] = people[j+1];
                    people[j+1] = t;
                } // if
            } // for j
        } // for i
    } // orderPeopleBySalaryDesc

    // возвращает ссылку на персону с минимальным возрастом
    // Правильнее - возвращать индекс, текущая реализация - просто демо
    private static Person getMinAgePerson(Person[] people) {
        Person personMinAge = people[0];  // personMinAge - это не новый объект!!!
        // изменение personMinAge - изменение элемента массива !!!
        // p - ссылка на объект класса Person в коллекции people
        for (Person p : people) {
            if (p.getAge() < personMinAge.getAge()) personMinAge = p;
        } // for
        return personMinAge;
    } // getMinAgePerson

    // вывод массива объектов
    private static void showPeople(String title, Person[] people) {
        System.out.println(title);

        // при выводе выделяем цветом записи с минимальным возрастом
        int minAge = getMinAgePerson(people).getAge();
        for (Person p : people) {
            String color = "";
            if (p.getAge() == minAge) color = "\033[34;1m";
            System.out.printf("%s%s\033[0m\n", color, p);
        } // for
    } // showPeople
} // class Main
