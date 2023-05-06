package org.itstep.pd011;

public enum Shape3D {
    NONE, CUBE, SPHERE, CONE; // значения перечисления - целые константы, int

    // пример использования методов в перечислении
    // применяем переменное число параметров (у разных фигур - разное количество сторон
    public double volume(double... sides) {
        // получить текущее значение перечисления (this)
        return switch (this) {
            case CUBE   -> sides[0] * sides[0] * sides[0];
            case SPHERE -> 4. * Math.PI * sides[0] * sides[0] * sides[0] / 3.;
            case CONE   -> 4. * Math.PI * sides[0] * sides[0] * sides[1] / 3.;
            default     -> 0;
        };
    } // volume

    // переопределение toString() - повышаем удобство вывода
    // один из немногих методов с override в перечислении
    @Override public String toString() {

        return switch (this) {
            case CONE   -> "конус";
            case CUBE   -> "куб";
            case SPHERE -> "шар";
            default     -> "нет данных";
        };
    } // toString

} // enum Shape3D
