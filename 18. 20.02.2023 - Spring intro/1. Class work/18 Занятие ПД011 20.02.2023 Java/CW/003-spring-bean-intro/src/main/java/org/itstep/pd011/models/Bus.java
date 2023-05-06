package org.itstep.pd011.models;

import java.io.Serializable;

public class Bus implements Serializable, Cloneable {
    private String marka;
    private String regNumber;
    private String driver;
    private int fuel;

    public Bus() {}

    public Bus(String marka, String regNumber, String driver, int fuel) {
        this.marka = marka;
        this.regNumber = regNumber;
        this.driver = driver;
        this.fuel = fuel;
    }

    //region геттеры и сеттеры
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    //endregion

    @Override
    public String toString() {
        return "Bus{" +
                "marka='" + marka + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", driver='" + driver + '\'' +
                ", fuel=" + fuel +
                '}';
    }
}
