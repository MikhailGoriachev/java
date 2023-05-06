package org.homework.app.viewModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.entries.Visit;

// Класс Модель представления для поездки
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisitViewModel {
    
    private Long id;
    
    // id клиента
    private Long clientId;
    
    // id маршрута
    private Long routeId;
    
    // дата начала поездки
    private String dateStart;
    
    // длительность поездки
    private int duration;


    // создать модель представления из модели
    public static VisitViewModel fromModel(Visit item) {
        return new VisitViewModel(
                item.getId(),
                item.getClient().getId(),
                item.getRoute().getId(),
                item.getDateStart(),
                item.getDuration()
        );
    }
}
