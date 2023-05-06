package org.homework.app.viewModels.queries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Модель фильтра для выборки поездок
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitsFilterViewModel {

    // длительность прибывания в стране
    private int duration;
}
