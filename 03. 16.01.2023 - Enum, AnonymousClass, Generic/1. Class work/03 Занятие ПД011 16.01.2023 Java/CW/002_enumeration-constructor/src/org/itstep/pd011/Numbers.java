package org.itstep.pd011;

/**
 * Поля в перечиселнии могут хранить какие-то дополнительные значения
 * Например, значение самих констант
 */
public enum Numbers {
    /* ZERO, -- отказались по требованию Заказчика */
    ONE(-1), TWO(-2), THREE(-3),
    FOUR(-4), FIVE(-5);  // неявный вызов конструктора перечисления
	
	

    // конструктор перечисления - задает значения вспомогательных
    // (дополнительных) полей
    Numbers(int value) {
        this.value = value;
    } // Numbers

    // вспомогательных/дополнительное поле для значений перечисления
    private int value;
    public int getValue() { return value; }

    // не делаем сеттер чтобы обеспечить неизменность перечисления,  
	// оно должно быть Immutable
    // public void setValue(int value) { this.value = value; }
} // enum Numbers
