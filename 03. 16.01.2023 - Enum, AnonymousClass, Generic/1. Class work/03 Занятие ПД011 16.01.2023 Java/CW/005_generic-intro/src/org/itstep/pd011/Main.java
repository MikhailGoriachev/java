package org.itstep.pd011;

public class Main {

    public static void main(String[] args) {
        /*
         Синтаксис создания объекта обобщенного класса
         ОбобщенныйТип<список фактических типов> имяОбъекта = new ОбобщенныйТип<>();
         <> - это ромбовидный оператор, показывает, что создается экземпляр класса
         обобщенного типа, между < и > можно указать список фактических типов
         (т.е. список инстанцируемых типов)
         список фактических типов - может содержать только ссылочные типы
        */

        // demo1();
        // System.out.println("---------------------------------------------------------\n");

        // дженерик с ограничениями
        demo2();
    } // main

    // демонстрационный метод
    private static void demo1() {
        // Тип<ТипПараметр> имяОбъекта = new Тип<>(параметрыКонструктора);
        // закрываем дженерик оберточным классом для примитивного типа int
        GenericOne<Integer> obj1 = new GenericOne<>(10);
        int x = obj1.getA() + 10;
        System.out.printf("x = %d, obj1 = %s\n", x, obj1);

        // закрываем дженерик оберточным классом для примитивного типа char
        GenericOne<Character> obj2 = new GenericOne<>('ё');
        char y = obj2.getA();
        System.out.printf("y: '%c'; obj2: '%s'\n", y, obj2);

        GenericOne<String> obj3 = new GenericOne<>("это строка");
        String s = obj3.getA() + "....";
        System.out.printf("s: \"%s\"; obj3: \"%s\"\n", s, obj3);

        // закрыть джереник классом (ссылочным типом) User
        GenericOne<User> obj4 = new GenericOne<>(new User());
        User u = obj4.getA();
        System.out.printf("u: \"%s\"; obj4: \"%s\"\n", u, obj4);

        GenericOne<Person> obj5 = new GenericOne<>(new Person("Павлина", 34, 34_000));
        System.out.printf("u: \"%s\"; obj4: \"%s\"\n", obj5.getA(), obj5);

        System.out.println(obj5.getA().name() + ", " + obj5.getA().salary());
    } // demo1

    // еще один демонстрационный метод
    private static void demo2() {
        // пример класса с обобщенным типом - передаем два типа
        GenericTwo<String, Double> obj1 = new GenericTwo<>("плотность", 1100.5);
        System.out.printf("obj1: %s; add = %.3f; obj1 < 1000: %b\n", obj1, obj1.add(123.7), obj1.lt(1000.));

        // тип Integer, но т.к. метод add() возвращает double - формат вывода %f
        GenericTwo<String, Integer> obj2 = new GenericTwo<>("периметр", 100);
        System.out.printf("obj2: %s; add = %.0f; obj2 < 1000: %b\n", obj2, obj2.add(200), obj2.lt(1000));

        // недопустимый тип на второй позиции
        // GenericTwo<Integer, String> obj3 = new GenericTwo<Integer, String>();
    } // demo2

}
