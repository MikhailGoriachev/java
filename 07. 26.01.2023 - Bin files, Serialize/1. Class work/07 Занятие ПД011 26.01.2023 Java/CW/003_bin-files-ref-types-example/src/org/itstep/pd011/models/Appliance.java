package org.itstep.pd011.models;

import org.itstep.pd011.utils.Files;
import org.itstep.pd011.utils.Utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

// Класс Электроприбор
public class Appliance {
    // Длина буфера записи названия прибора в бинарный файл (в байтах, один символ == два байта)
    private static final int LEN_NAME = 62;

    // Длина буфера записи производителя прибора в бинарный файл (в байтах, один символ == два байта)
    private static final int LEN_BRAND = 42;

    // Длина записи в двоичном файле, в байтах
    //                              длина наименования + длина названия производителя + длина double + длина boolean
    public static final int BYTES = LEN_NAME           + LEN_BRAND                    + Double.BYTES + 1;

    // заголовки для табличного отображения сведений о приборе
    public static final String SPLITTER = "+---------------------------+---------------+--------------+-------------+\n";
    public static final String HEADER   = "| название электроприбора   | производитель | мощность, Вт | состояние   |\n";

    private String name;     // название прибора
    private String brand;    // производитель прибора
    private double power;    // мощность
    private boolean state;   // состояние прибора - включен/выключен


    public Appliance() {
        this("утюг", "Phillips", 1200, false);
    } // Appliance
    public Appliance(String name, String brand, double power, boolean state) {
        setName(name);
        setBrand(brand);
        setPower(power);
        setState(state);
    } // // Appliance

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("\033[31;1m\nНаименование прибора обязательно должно быть задано\n\033[0m");
            this.name = "утюг";
            return;
        } // if
        this.name = name;
    } // setName

    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("\033[31;1m\nПроизводитель прибора обязательно должен быть задан\n\033[0m");
            this.brand = "ДонЭлектроЗавод";
            return;
        } // if
        this.brand = brand;
    } // setRoom

    public double getPower() { return power;  }
    public void setPower(double power) {
        if (power <= 0) {
            System.out.println("\033[31;1m\nМощность прибора не может быть отрицательной или нулевой\n\033[0m");
            this.power = 1;
            return;
        } // if
        this.power = power;
    } // setPower

    // стандартные имена для работы с boolean: isXxx  для геттера и setXxx
    // для сеттера
    public boolean isState() { return state; }
    public void setState(boolean state) { this.state = state; }

    /////////////////////////////////////////////////////////////////////////////////
    // ввод с клавиатуры
    public void input() {
        String temp;
        System.out.print("\nНазвание прибора     : ");
        temp = Utils.sc.nextLine();
        setName(temp);

        System.out.print("Производитель прибора: ");
        temp = Utils.sc.nextLine();
        setBrand(temp);

        System.out.print("Мощность прибора, Вт : ");
        double power = Utils.sc.nextDouble();
        setPower(power);

        int state = Utils.getInt("Состояние прибора (1 - вкл., 0 - выкл.): ", 0, 1);
        setState(state == 1);
    } // input


    /////////////////////////////////////////////////////////////////////////////////
    // работа с бинарным файлом

    // DataOutput - интерфейс, реализуется классами RandomAccessFile, DataOutputStream
    // https://docs.oracle.com/javase/7/docs/api/java/io/DataInput.html
    // запись полей объекта в бинарный файл dos
    public void write(DataOutput raf) throws IOException {
        Files.writeString(raf, name, LEN_NAME);    // запись строки - название прибора
        Files.writeString(raf, brand, LEN_BRAND);  // запись строки - производитель прибора
        raf.writeDouble(power);                    // запись мощности прибора
        raf.writeBoolean(state);                   // запись состояния прибора - включен/выключен
    } // write

    // DataInput - интерфейс, реализуется классами RandomAccessFile, DataInputStrem
    // https://docs.oracle.com/javase/7/docs/api/java/io/DataInput.html
    // чтение полей объекта из бинарного файла dis
    public void read(DataInput raf) throws IOException {
        name = Files.readString(raf, LEN_NAME);    // чтение строки - название прибора
        brand = Files.readString(raf, LEN_BRAND);  // чтение строки - производитель прибора
        power = raf.readDouble();                  // чтение мощности прибора
        state = raf.readBoolean();                 // чтение состояния прибора - включен/выключен
    }  // read

    /////////////////////////////////////////////////////////////////////////////////
    // вывод в строку

    @Override
    public String toString() {
        String str = String.format("%s, %s, %.2f Вт, %s",
            name, brand, power, state?"включен":"выключен");
        return str;
    } // toString

    // Формирование строки таблицы для вывода в консоль
    public String toTableRow() {
        String str = String.format("| %-25s | %-13s | %12.2f | %-11s |",
            name, brand, power, state?"включен":"выключен");
        return str;
    } // toString
} // class Appliance
