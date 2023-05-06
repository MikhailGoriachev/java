package app.models;

import java.io.Serializable;

// Класс Ноутбук
// (наименование устройства, модель, тип процессора, объем оперативной памяти, емкость накопителя, диагональ экрана, 
// описание неисправности, фамилия и инициалы владельца) 
public class Laptop implements Serializable {
    String name;
    String model;
    String processor;
    int ram;
    int storageCapacity;
    double diagonal;
    String defectDescription;
    String owner;

    Laptop() {
    }

    public Laptop(String name, String model, String processor, int ram, int storageCapacity, double diagonal, String defectDescription, String owner) {
        this.name = name;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.diagonal = diagonal;
        this.defectDescription = defectDescription;
        this.owner = owner;
    }

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "\t| %-20s | %-20s | %-20s | %-5d | %-7d | %-9.1f | %-20s | %-15s |\n",
                name,
                model,
                processor,
                ram,
                storageCapacity,
                diagonal,
                defectDescription,
                owner
        );
    }
}
