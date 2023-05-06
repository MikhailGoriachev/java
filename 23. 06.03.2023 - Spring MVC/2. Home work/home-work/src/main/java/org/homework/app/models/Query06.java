package org.homework.app.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Query06 {
    
    // название товара
    private String goodsName;
    
    // минимальная цена
    private int minPrice;
    
    // средняя цена
    private int avgPrice;
    
    // максимальная цена
    private int maxPrice;
    
    // количество
    private long count;

    public Query06(String goodsName, int minPrice, int avgPrice, int maxPrice, long count) {
        this.goodsName = goodsName;
        this.minPrice = minPrice;
        this.avgPrice = avgPrice;
        this.maxPrice = maxPrice;
        this.count = count;
    }
}
