package org.itstep.pd011;

import java.util.Objects;

// класс для примера закрытия дженерика ссылочным типом
public class User {
    private String name;
    private int age;
    private double salary;

    public User() {
        this("Татьяна", 31, 39_000);
    }

    // канонический конструктор
    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double salary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User other)) return false;
        return other.name.equals( name)&& other.age == age;
    } // equals

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
