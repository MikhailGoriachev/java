package org.homework.app.viewModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Query01ViewModel{
    
    // сокращённое имя
    private String unitShortName;
    
    // цена
    private int price;
}