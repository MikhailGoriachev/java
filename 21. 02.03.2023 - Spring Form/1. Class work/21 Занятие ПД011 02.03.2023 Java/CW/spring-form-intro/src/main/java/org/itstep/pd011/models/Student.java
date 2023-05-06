package org.itstep.pd011.models;

// пример класса для работы с формой
public class Student {
    private int id;
    private String surname;
    private String name;
    private int age;

    // группа
    private String group;

    // основное увлечение
    private String hobby;

    // особые навыки
    private boolean foreignLanguage;
    private boolean workout;
    private boolean hasCar;

    // конструкторы

    public Student() {
        this(1001, "Иванова", "Ирина", 19, "ПМ-911", "чтение", true, true, false);
    } // Student

    public Student(int id, String surname, String name, int age, String group, String hobby, boolean foreignLanguage, boolean workout, boolean hasCar) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.group = group;
        this.hobby = hobby;
        this.foreignLanguage = foreignLanguage;
        this.workout = workout;
        this.hasCar = hasCar;
    }

    // аксессоры

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(boolean foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public boolean isWorkout() {
        return workout;
    }

    public void setWorkout(boolean workout) {
        this.workout = workout;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }
} // class Student
