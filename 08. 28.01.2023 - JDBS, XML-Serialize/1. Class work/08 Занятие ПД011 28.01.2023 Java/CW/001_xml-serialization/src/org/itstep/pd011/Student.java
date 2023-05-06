package org.itstep.pd011;

import java.io.Serializable;
import java.util.StringJoiner;

// класс должен быть JavaBean для сериализации
// Требования, которые должен выполнять класс, чтобы называться JavaBean
// — объявление класса со спецификатором public;
// — объявление public-конструктора без параметров (по умолчанию);
// — объявление инкапсулированных полей;
// — объявление корректных геттеров и сеттеров для каждого нестатического поля;
// — возможность сохранения объекта целиком – сериализация.
// Статические поля не сериализуются в XML.
// Поля со спецификатором transient — сериализуются в XML
public class Student implements Serializable {
    static String faculty = "РПО";     // static не сериализуется в XML
    private String name;
    private int id;
    private transient String password; // transient сериализуется в XML
    private static final long serialVersionUID = 2L;

    public Student(){
        this("Оксана", 123456, " pA55w0rd_");
    }
    public Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    //region геттеры и сеттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

    // !!! StringJoiner
    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
            .add(String.format("name='%s'", name))
            .add("id=" + id)
            .add("password='" + password + "'")
            .toString();
    }
}
