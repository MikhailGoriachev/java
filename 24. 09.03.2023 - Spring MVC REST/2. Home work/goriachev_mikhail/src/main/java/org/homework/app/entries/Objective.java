package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Цель проездки
@Entity
@Table(name = "objectives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Objective {

    // id
    @Id
    private Long id;
    
    // название
    @Column(name = "name")
    private String name;
    
    // маршруты
    @OneToMany
    @Transient
    private List<Route> routes;
}
