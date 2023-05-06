package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


// Класс Поездка
@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    // id
    @Id
    private Long id;

    // клиент
    @ManyToOne
    private Client client;

    // маршрут
    @ManyToOne
    private Route route;

    // дата начала поездки
    @Column(name = "date_start")
    private String dateStart;

    // длительность поездки
    @Column(name = "duration")
    private int duration;


    // полная стоимость поездки
    // стоимость поездки может быть вычислена как Стоимость 1 дня пребывания * Количество дней пребывания + Стоимость
    // транспортных услуг + Стоимость оформления визы. Кроме того, клиент платит налог на добавленную стоимость (НДС) в
    // размере 3% от стоимости поездки.
    public double getOverCost() {
        return route.getDailyCost() * duration + route.getCountry().getCostService() + route.getCountry().getCostVisa();
    }

    // полная стоимость включая НДС
    public double getOverCostWithNds() {
        return getOverCost() * 1.03;
    }
}
