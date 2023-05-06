package org.homework.app.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Запрос 7. Выполняет группировку по полю Цель поездки. Определяет минимальную, 
// среднюю и максимальную стоимость 1 дня пребывания

@Getter
@Setter
@NoArgsConstructor
public class Query07 {

    // цель поездки
    private String objectiveName;

    // минимальная стоимость 1 дня пребывания
    private int minDailyCost;

    // средняя стоимость 1 дня пребывания
    private double avgDailyCost;

    // максимальная стоимость 1 дня пребывания
    private int maxDailyCost;
    
    // количество
    private long amount;

    
    // конструктор инициализирующий
    public Query07(String objectiveName, int minDailyCost, double avgDailyCost, int maxDailyCost, long amount) {
        this.setObjectiveName(objectiveName);
        this.setMinDailyCost(minDailyCost);
        this.setAvgDailyCost(avgDailyCost);
        this.setMaxDailyCost(maxDailyCost);
        this.setAmount(amount);
    }
}
