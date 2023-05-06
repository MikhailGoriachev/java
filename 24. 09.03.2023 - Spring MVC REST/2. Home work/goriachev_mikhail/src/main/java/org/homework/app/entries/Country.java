package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Страна
@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    // id
    @Id
    private Long id;
    
    // название
    @Column(name = "name", length = 80)
    private String name;

    // стоимость транспортных услуг
    @Column(name = "cost_service")
    private Integer costService;

    // стоимость оформления визы
    @Column(name = "cost_visa")
    private int costVisa;

    // маршруты
    @OneToMany
    @Transient
    private List<Route> routes;
}
