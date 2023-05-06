package org.homework.app.viewModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.entries.Route;

// Класс Модель представления для маршрута
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteViewModel {

    private Long id;

    // id страны
    private Long countryId;

    // id цели поездки
    private Long objectiveId;

    // стоимость одного дня прибывания
    private int dailyCost;


    // создать модель представления из модели
    public static RouteViewModel fromModel(Route item) {
        return new RouteViewModel(
                item.getId(),
                item.getCountry().getId(),
                item.getObjective().getId(),
                item.getDailyCost()
        );
    }
}
