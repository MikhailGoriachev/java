package org.homework.app.viewModels.queries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Модель фильтра для выборки стран
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountriesFilterViewModel {

    // минимальная стоимость оформления визы
    private int costVisaMin;

    // максимальная стоимость оформления визы
    private int costVisaMax;
}
