package org.homework.app.entries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Единица измерения
@Entity
@Table(name = "units")
@Getter
@Setter
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // сокращенное название
    @Column(name = "short")
    private String shortName;
    
    // полное название
    @Column(name = "long")
    private String longName;
}
