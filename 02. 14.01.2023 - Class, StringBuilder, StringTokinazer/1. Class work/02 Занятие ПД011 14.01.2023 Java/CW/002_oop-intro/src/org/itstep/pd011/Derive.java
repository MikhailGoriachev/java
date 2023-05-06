package org.itstep.pd011;

// Пример наследования/расширения класса
public class Derive extends Base {
    // пакетная область видимости
    String c;  // добавленное поле

    public Derive(int a, double b, String c) {
        super(a, b); // вызов конструктора суперкласса (д.б. первой строкой)

        this.c = c;  // другие присваивания, вызовы методов
    } // Derive

    // в конструкторе по умолчанию
    public Derive() {
        // конструктор суперкласса вызывается неявно
        System.out.println("Derive: конструктор по умолчанию");
        c = "наследование";
    } // Derive

    @Override // реализация абстрактного метода
    public void bar() {
        System.out.printf("\n\033[34mDerive\033[30m: реализация абстрактного метода bar()\n");
    } // bar

    // дополнение метода суперкласса
    @Override
    public String toString() {
        return super.toString() + String.format("; c = \"%s\"", c);
    } // toString
} // Derive
