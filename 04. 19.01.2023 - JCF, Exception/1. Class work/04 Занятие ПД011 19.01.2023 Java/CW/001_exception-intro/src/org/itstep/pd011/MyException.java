package org.itstep.pd011;

// собственный класс исключений
public class MyException extends RuntimeException implements ISetValues {
    public MyException() {
        super();
    } // MyException

    public MyException(String message) {
        // использование константы ERROR_ONE из интерфейса
        super(message + ". Код ошибки: " + ERROR_ONE);
    } // MyException
}
