package org.homework.app.entries;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// Класс Персона
@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // фамилия
    @Column(name = "surname", length = 60)
    private String surname;
    
    // имя
    @Column(name = "name", length = 50)
    private String name;
    
    // отчество
    @Column(name = "patronymic", length = 60)
    private String patronymic;
    
    // паспорт
    @Column(name = "passport", length = 15)
    private String passport;
}
