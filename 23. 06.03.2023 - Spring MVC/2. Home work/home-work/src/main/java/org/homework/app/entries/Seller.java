package org.homework.app.entries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Продавец
@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // персона
    @ManyToOne
    private Person person;

    // процент комиссии
    @Column(name = "interest")
    private int interest;

    // получить строковое представление
    public String getToString() {
        return String.format(
                "%d. %s %s. %s. %s",
                id,
                person.getSurname(),
                person.getName().charAt(0),
                person.getPatronymic().charAt(0),
                person.getPassport()
        );
    }
}
