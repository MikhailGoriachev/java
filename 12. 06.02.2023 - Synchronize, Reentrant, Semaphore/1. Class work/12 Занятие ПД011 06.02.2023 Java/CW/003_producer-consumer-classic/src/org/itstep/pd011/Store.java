package org.itstep.pd011;

/*
 * Склад готовой продукции - общий ресурс для производителя и потребителя
 * Это и есть объект-посредник
 * */
public class Store {
    final int LIMIT = 5;      // максимальное количество товара на складе

    // счетчик товара на складе - общий ресурс
    private int counter = 0;

    // Прием товара от производителя - принимаем 1 единицу товара,
    // если на складе есть место
    // synchronized гарантирует непрерывность метода
    synchronized public int put() {
        int result = 0;  // количество принятого товара

        // Если на складе есть место - т.е. валидация успешна - принять товар - т.е. принять данные
        if (counter < LIMIT) {
            counter++;
            System.out.printf("Склад \033[35;1mпринял\033[0m товар, остаток на складе                : %2d\n", counter);
            result = 1;
        } // if

        return result;
    } // put

    // Выдача товара потребителю, выдаем всегда 1 единицу товара, если товар
    // есть на складе
    synchronized public int get() {
        int result = 0;  // количество отгруженного товара

        // если есть товар на складе (есть данные для обмена), то его можно выдавать
        if (counter > 0) {
            counter--;
            System.out.printf("Склад \033[34;1mотгрузил\033[0m товар, остаток на складе              : %2d\n", counter);
            result = 1;
        } // if

        return result;
    } // get
} // class Store
