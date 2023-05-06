package org.itstep.pd011.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// таблица clients
@Entity
@Table(name="clients")
public class Client {

    private static final long serialVersionID = -12121212121999L;

    @Id
    private long id;

    @Column(name="surname", length = 60)
    private String surname;

    @Column(name="name", length = 40)
    private String name;

    @Column(name="patronymic", length = 60)
    private String patronymic;

    @Column(name="passport", length = 12)
    private String passport;

    @Column(name="discount")
    private double discount;

    public Client() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passport='" + passport + '\'' +
                ", discount=" + discount +
                '}';
    }
} // class Client
