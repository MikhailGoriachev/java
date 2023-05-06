package org.itstep.pd011;

// Класс, содержащий внутренний и вложенный классы
public class OuterClass {
    private int outerA;
    static private int stOuterA = 123;

    public InnerClass inner;  // объект внутреннего класса для работы с ним

    public OuterClass() { inner = new InnerClass(); }
    public OuterClass(int outerA, int innerA) {
        this.outerA = outerA;
        inner = new InnerClass(innerA); // создание объекта внутреннего класса
    } // OuterClass

    public void foo() {
        System.out.printf("Outer.foo: outerA = %d\n", outerA);
    } // foo

    private void zoo() {
        System.out.printf("Outer: метод zoo(), inner = %s", inner);
    } // zoo

    private static void stZoo() {
        System.out.printf("Outer: static метод stZoo(), stOuterA = %d", stOuterA);
    } // stZoo

    // демонстрация работы с объектом внутреннего класса
    public void method() {
        System.out.print("Outer.method: ");
        inner.innerA = 123;  // имеем доступ ко всем полям и методам внутреннего класса
        System.out.println(inner.innerA);
        inner.bar();
    } // method


    // Внутренний класс (м.б. также public, private, protected, abstract)
    class InnerClass {
        private int innerA;

        public InnerClass() { }
        public InnerClass(int innerA) {
            this.innerA = innerA;
        } // InnerClass

        public void bar() {
            // внутренний класс имеет прямой доступ ко всем полям
            // и методам объемлющего класса
            System.out.printf("Inner.bar: innerNC = %d, stOuterA = %d, outerA = %d\n", innerA, stOuterA, outerA);
            zoo();
            stZoo();
        } // bar

        @Override
        public String toString() {
            return "innerA=" + innerA;
        }
    } // class InnerClass

    // статический внутренний класс (вложенный класс) - всегда в одном экземпляре, напрямую работает только
    // со статическими полями и методами объемлющего класса
    static class NestedClass {
		// поле вложенного класса для доступа к нестатическому элементу объемлющего класса
        private int innerNC;

        public NestedClass() { }
        public NestedClass(int innerNC) {
            this.innerNC = innerNC;
        } // NestedClass

        public void bar() {
            // вложенный класс имеет прямой доступ только к статическим
            // полям и методам объемлющего класса
            System.out.printf("InnerNC.bar: innerNC = %d, stOuterA = %d\n", innerNC, stOuterA);
            stZoo();
        } // bar
    } // class NestedClass
} // class OuterClass
