package org.homework.app.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Запрос 8. Выполняет группировку по полю Страна назначения. Для каждой страны вычисляет 
// среднее значение по полю Стоимость транспортных услуг

@Getter
@Setter
@NoArgsConstructor
public class Query08 {

    // название страны
    private String countryName;

    // минимальная стоимость транспортных услуг
    private int minCostService;

    // средняя стоимость транспортных услуг
    private double avgCostService;

    // максимальная стоимость транспортных услуг
    private int maxCostService;
    
    // количество
    private long amount;

    
    // конструктор инициализирующий
    public Query08(String countryName, int minCostService, double avgCostService, int maxCostService, long amount) {
        this.setCountryName(countryName);
        this.setMinCostService(minCostService);
        this.setAvgCostService(avgCostService);
        this.setMaxCostService(maxCostService);
        this.setAmount(amount);
    }
}
