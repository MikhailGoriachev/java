package org.itstep.pd011;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidParameterException;


// Обобщенный класс для сериализации/десериализации
public class Serializer <T> {
    private String fileName; // имя файла для сериализации

    // конструкторы
    public Serializer(String fileName) {
        setFileName(fileName);
    } // Serializer

    // геттер и сеттер
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        if (fileName == null)
            throw new NullPointerException("Имя файла для сериализации не может быть null");
        if (fileName.isEmpty())
            throw new InvalidParameterException("Имя файла для сериализации не может быть пустым");
        this.fileName = fileName;
    } // setFileName

    // Метод для сериализации объекта в файл
    public boolean serialize(T obj) {
        boolean result = false;

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
            os.writeObject(obj);
            result = true;  // сериализация завершена удачно
        } catch (Exception ex) {
            ex.printStackTrace();
        } // catch

        return result;
    } // serialize

    // Метод для десериализации объекта из файла
    // если будут ошибки при чтении из файла, возвращаем null
    public T deserialize() {
        T result = null;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
            // при десериализации конструктор не вызывается!!!
            result = (T)is.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // catch

        return result;
    } // deserialize
} // class Serializer
