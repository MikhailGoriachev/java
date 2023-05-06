package org.homework.app.viewModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.entries.Purchase;
import org.homework.app.entries.Seller;
import org.homework.app.entries.Unit;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleViewModel {
    
    private Long id;

    // id закупки
    private Long purchaseId;

    // id единицы товара
    private Long unitId;

    // id продавца
    private Long sellerId;

    // дата продажи
    private String saleDate;

    // цена
    private int price;

    // количество
    private int amount;
}