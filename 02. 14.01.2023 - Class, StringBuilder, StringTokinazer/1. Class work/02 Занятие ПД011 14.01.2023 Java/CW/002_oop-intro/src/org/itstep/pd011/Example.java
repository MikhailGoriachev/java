package org.itstep.pd011;

import java.io.Serializable;

// класс наследует от Base и реализует интерфейс IBase
// класс может реализовывать больше одного интерфейса, например - стандартный
// Serializable
// (правда, есть тонкость  в этом интерфейсе нет обязательных к реализации методов)
public class Example extends Base implements IBase, Serializable, INewFeatures  {

    // реализация интерфейса IBase
    // просто удваиваем поле a
    @Override
    public int twice() {
        return 2*getA();
    } // twice

    @Override
    public String text(double x) { // реализация интерфейса IBase
        return String.format("%.5f", b + x);
    } // text

    @Override // реализация интерфейсного метода из INewFeatures
    public void foo() {
        System.out.print("\n\033[34mExample\033[0m: реализация метода foo()\n");
    } // foo

    // реализация абстрактного метода из Base
    @Override
    public void bar() {
        System.out.print("\n\033[34mExample\033[0m: реализация абстрактного метода bar()\n");
    } // bar
} // class Example
