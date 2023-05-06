package org.homework.app.models;


// Класс Чайник
public class Kettle {

    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // производитель
    private String manufacture;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    // модель
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // мощность, Вт
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    // время нагрева от 20оС до 100оС в секундах
    private int heatingTime;

    public int getHeatingTime() {
        return heatingTime;
    }

    public void setHeatingTime(int heatingTime) {
        this.heatingTime = heatingTime;
    }
    
    // время удержания температуры 80оС, в минутах
    private int temperatureHoldingTime;

    public int getTemperatureHoldingTime() {
        return temperatureHoldingTime;
    }

    public void setTemperatureHoldingTime(int temperatureHoldingTime) {
        this.temperatureHoldingTime = temperatureHoldingTime;
    }

    
    // конструктор по умолчанию
    public Kettle() {
    }
    
    // конструктор инициализирующий
    public Kettle(int id, String manufacture, String model, int power, int heatingTime, int temperatureHoldingTime) {
        this.setId(id);
        this.setManufacture(manufacture);
        this.setModel(model);
        this.setPower(power);
        this.setHeatingTime(heatingTime);
        this.setTemperatureHoldingTime(temperatureHoldingTime);
    }


    // строковое представление
    public String toTableRow() {
        return String.format("\t| %1$2d | %2$-15s | %3$-15s | %4$15d | %5$14d | %6$14d |\n",
                id,
                manufacture, 
                model, 
                power, 
                heatingTime, 
                temperatureHoldingTime
        );
    }
}
