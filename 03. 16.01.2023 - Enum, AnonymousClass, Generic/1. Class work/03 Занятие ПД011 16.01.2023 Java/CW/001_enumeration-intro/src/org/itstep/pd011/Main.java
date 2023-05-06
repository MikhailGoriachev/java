package org.itstep.pd011;

// Использование перечислений
public class Main {

    public static void main(String[] args) {
        // simpleEnum();
        complexEnum();
    } // main

    // простой пример на традиционное использование перечислений
    private static void simpleEnum() {
        // в выражениях значение перечисления уточняется именем типа
        Fruits fruit1 = Fruits.CHERRY;  // создание экземпляра перечисления - без использования new

        // вывод названия фрукта на русском языке
        String strRus;

        // for(var fruit:Fruits.values()) {
        for(Fruits fruit:Fruits.values()) {
            System.out.printf("Фрукт: %s (код %d)", fruit, fruit.ordinal());
            // Перечисление можно использовать в switch
//            switch (fruit) {
//                case BANANA: // значение указывается без уточнения типа
//                    strRus = "банан";
//                    break;
//                case APPLE:
//                    strRus = "яблоко";
//                    break;
//                case CHERRY:
//                    strRus = "вишня";
//                    break;
//                case GRAPE:
//                    strRus = "виноград";
//                    break;
//                case LEMON:
//                    strRus = "лимон";
//                    break;
//                case ORANGE:
//                    strRus = "апельсин";
//                    break;
//                case NONE:
//                default:
//                    strRus = "нет данных";
//                    break;
//            } // switch

            // switch-expression - улучшенный вариант switch() {}
            // значение перечисления указывается без уточнения типа
            strRus = switch (fruit) {
                case BANANA -> "банан";
                case APPLE -> "яблоко";
                case CHERRY -> "вишня";
                case GRAPE -> "виноград";
                case LEMON -> "лимон";
                case ORANGE -> "апельсин";
                default -> "нет данных";
            }; // switch
            System.out.printf("; по русски это \033[4m%s\033[0m\n", strRus);
        }
    } // simpleEnum


    // более сложное применение перечисления - с использованием методов
    private static void complexEnum() {
        Shape3D shape;

        // присвоить значение КОНУС перечислению
        shape = Shape3D.CONE;
        double r = 10, h = 2;
        double v = shape.volume(r, h);  // пример вызова метода, определенного для перечисления
        System.out.printf(
            "Фигура: \033[34;1m%s\033[0m, ее объем для радиуса %.3f и высоты %.3f равен %.3f\n",
            shape, r, h, v);

        shape = Shape3D.CUBE;
        double a = 10.;
        v = shape.volume(a);
        System.out.printf("Фигура: \033[34;1m%s\033[0m, ее объем для стороны %.3f равен %.3f\n", shape, a, v);

        shape = Shape3D.SPHERE;
        r = 20.;
        v = shape.volume(r);
        System.out.printf("Фигура: \033[34;1m%s\033[0m, ее объем для радиуса %.3f равен %.3f\n", shape, r, v);
    } // complexEnum
}
