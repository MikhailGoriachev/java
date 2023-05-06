package org.itstep.pd011;

public class Person {
    private int id;
    private String fullName;
    private int age;

    public Person() { }

    public Person(int id, String surnameNP, int age) {
        this.id = id;
        this.fullName = surnameNP;
        this.age = age;
    } // Person

    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName()               { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge()         {  return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    } // toString
} // class Person
