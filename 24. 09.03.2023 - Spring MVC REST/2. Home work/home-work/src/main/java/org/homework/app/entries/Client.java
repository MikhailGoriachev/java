package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Клиент
@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    // id
    @Id
    private Long id;

    // фамилия
    @Column(name = "surname", length = 80)
    private String surname;

    // имя
    @Column(name = "name", length = 80)
    private String name;

    // отчество
    @Column(name = "patronymic", length = 80)
    private String patronymic;

    // паспорт
    @Column(name = "passport", unique = true, length = 20)
    private String passport;

    // поездки
    @Transient
    @OneToMany
    private List<Visit> visits;

    
    // получить строковую информацию (необходимо для использования в выпадающем списке) 
    public String getStringInfo() {
        return String.format("%d. %s %s. %s. %s", id, surname, name.charAt(0), patronymic.charAt(0), passport);
    }
}
