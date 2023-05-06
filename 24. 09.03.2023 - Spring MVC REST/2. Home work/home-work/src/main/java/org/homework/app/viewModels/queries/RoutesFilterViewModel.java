package org.homework.app.viewModels.queries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Модель фильтра для выборки маршрутов
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoutesFilterViewModel {

    // цель поездки (для запроса, где требуется только этот параметр)
    private String objectiveNameOnly;
    
    // цель поездки
    private String objectiveName;
    
    // стоимость транспортных услуг
    private int costService;
    
    // страна назначения
    private String countryName;
}
