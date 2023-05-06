package org.itstep.pd011;

// запись в телефонной книге
public class Abonent extends Entity {
    private int id;
    private String name;
    private String phone;

    public Abonent() {}

    public Abonent(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Abonent{");
        sb.append("id=").append(id)
          .append(", name='").append(name).append('\'')
          .append(", phone=").append(phone).append('}');
        return sb.toString();
    }
}
