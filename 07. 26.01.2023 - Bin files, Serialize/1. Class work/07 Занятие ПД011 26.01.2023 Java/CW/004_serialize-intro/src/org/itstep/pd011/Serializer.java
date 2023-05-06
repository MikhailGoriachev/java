package org.itstep.pd011;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// класс, выполняющий сериализацию
public class Serializer {
    private String fileName; // имя файла для сериализации

    public Serializer(String fileName) {
        this.fileName = fileName;
    } // Serializer

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // Метод для сериализации объекта в файл
    public boolean serialize(ClassA obj) {
        boolean result = false;

        // ObjectOutputStream - поток  для записи объектов
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
    public ClassA deserialize() {
        ClassA result = null;

        // ObjectInputStream - поток  для чтения объектов
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
            // при десериализации конструктор не вызывается!!!
            result = (ClassA)is.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // catch

        return result;
    } // deserialize
} // class Serializer
