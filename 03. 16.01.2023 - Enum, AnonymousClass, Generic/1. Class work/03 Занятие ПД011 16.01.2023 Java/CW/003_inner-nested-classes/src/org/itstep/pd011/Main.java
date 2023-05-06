package org.itstep.pd011;

// внутренние/вложенные классы
public class Main {

    public static void main(String[] args) {

        /*
        System.out.println("Внешний класс");
	    OuterClass obj1 = new OuterClass(10, 20);

	    obj1.foo();
        obj1.method();

        System.out.println();
        */

        /*
        // Создание объекта с типом внутреннего класса,
        // но вне объемлющего класса
        // ТипВнешний.ТипВнутренний имя = new ТипВнешний(параметры).new ТипВнутренний(параметры);
        // т.е. создается и объект внешнего класса и объект внутреннего класса
        OuterClass.InnerClass innerObj1 = new OuterClass().new InnerClass();
        OuterClass.InnerClass innerObj2 = new OuterClass(1, 2).new InnerClass(3);

        System.out.println("Внутренний класс");
        innerObj1.bar();

        System.out.println();
        innerObj2.bar();
        */


        System.out.println("\nВложенный класс, объект 1:");
        OuterClass.NestedClass nestedObj1 = new OuterClass.NestedClass(10);
        nestedObj1.bar();

        // создается один экземпляр внешнего класса и несколько экземпляров вложенного класса
        // обратите внимание, как задается тип - ВнешнийКласс.ВложенныйКласс
        OuterClass.NestedClass nestedObj2 = new OuterClass.NestedClass(22);
        System.out.println("\nВложенный класс, объект 2:");
        nestedObj2.bar(); // разные значения полей у nestedObj1 и nestedObj2

    } // main
}
