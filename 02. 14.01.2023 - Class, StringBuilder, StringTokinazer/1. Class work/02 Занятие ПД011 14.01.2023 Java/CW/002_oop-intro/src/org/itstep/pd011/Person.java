package org.itstep.pd011;

// пример класса
public class Person {
    private String surnameNP;  // в пределах класса
    int age;                   // если доступ не указан - в пределах пакета
    public double salary;      // в пределах приложения

    // блок инициализации, выполняется перед любым конструктором
    {
        surnameNP = "";
        age = 0;
        salary = 0.0;
    }

    public Person(String surnameNP, int age, double salary) {
        this.surnameNP = surnameNP;
        this.age = age;
        this.salary = salary;
    } // Person

    public Person() {
        // вызов конструктора
        this("", 0, 0);
    }

    // геттеры и сеттеры
    public String getSurnameNP() {
        return surnameNP;
    }
    public void setSurnameNP(String surnameNP) {
        this.surnameNP = surnameNP;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
    } // setAge

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Оплата не может быть отрицательной");
        this.salary = salary;
    } // setSalary

    // аннотация @Override == C# override  общий предок всех Object
    @Override
    public String toString() {
        return String.format("Фамилия, инициалы: %-15s; возраст: %d; оклад: %.2f;", surnameNP, age, salary);
    } // toString
} // class Person
