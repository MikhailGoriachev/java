package org.homework.app.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

// Класс Тренировка
public class Workout {
    
    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // дата и время начала (с точностью до секунды)
    private Date dateTimeBegin;

    public Date getDateTimeBegin() {
        return dateTimeBegin;
    }

    public void setDateTimeBegin(Date dateTimeBegin) {
        this.dateTimeBegin = dateTimeBegin;
    }

    // дата и время завершения (с точностью до секунды)
    private Date dateTimeEnd;

    public Date getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(Date dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    // фамилия и инициалы тренера, проводящего тренировку (пустая строка, если тренировка самостоятельная)
    private String trainer;

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    // есть ли особые требования к инвентарю
    private boolean isSpecialInventory;

    public boolean isSpecialInventory() {
        return isSpecialInventory;
    }

    public void setSpecialInventory(boolean specialInventory) {
        isSpecialInventory = specialInventory;
    }

    // есть ли особые требования к помещению
    private boolean isSpecialRoom;

    public boolean isSpecialRoom() {
        return isSpecialRoom;
    }

    public void setSpecialRoom(boolean specialRoom) {
        isSpecialRoom = specialRoom;
    }

    // парсер для даты и времени
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    // конструктор по умолчанию
    public Workout() {
    }

    // конструктор инициализирующий
    public Workout(int id, String dateTimeBegin, String dateTimeEnd, String trainer, boolean isSpecialInventory, boolean isSpecialRoom) throws ParseException {
        this.setId(id);
        this.setDateTimeBegin(simpleDateFormat.parse(dateTimeBegin));
        this.setDateTimeEnd(simpleDateFormat.parse(dateTimeEnd));
        this.setTrainer(trainer);
        this.setSpecialInventory(isSpecialInventory);
        this.setSpecialRoom(isSpecialRoom);
    }

    
    // получить продолжительность тренировки (в секундах)
    public Duration getDuration() {
        return Duration.between(dateTimeBegin.toInstant(), dateTimeEnd.toInstant());
    }
    
    // строковое представление
    public String toTableRow() { 
        return String.format("\t| %2d | %s | %s | %17s | %-15s | %-10s | %-10s |\n", 
                id, 
                simpleDateFormat.format(dateTimeBegin), 
                simpleDateFormat.format(dateTimeEnd),
                LocalTime.ofSecondOfDay(getDuration().getSeconds()),
                trainer, 
                isSpecialInventory ? "да" : "нет", 
                isSpecialRoom ? "да" : "нет"
        );
    }
}
