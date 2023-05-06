package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


// Класс Маршрут
@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    // id
    @Id
    private Long id;
    
    // страна
    @ManyToOne
    private Country country;
    
    // цель поездки
    @ManyToOne
    private Objective objective;
    
    // стоимость одного дня прибывания
    @Column(name = "daily_cost")
    private int dailyCost;
    
    // поездки
    @OneToMany
    @Transient
    private List<Visit> visits;

    
    // конструктор инициализирующий
    public Route(Long id, Country country, Objective objective, int dailyCost) {
        this.setId(id);
        this.setCountry(country);
        this.setObjective(objective);
        this.setDailyCost(dailyCost);
    }

    
    // получить строковую информацию (необходимо для использования в выпадающем списке) 
    public String getStringInfo() {
        return String.format("%d. %s, %s", id, country.getName(), objective.getName());
    }
}
