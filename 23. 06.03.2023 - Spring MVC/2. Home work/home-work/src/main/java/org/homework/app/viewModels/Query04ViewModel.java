package org.homework.app.viewModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Query04ViewModel {
    
    // минимальная цена продажи
    private int minSalePrice;
    
    // максимальная цена продажи
    private int maxSalePrice;
}