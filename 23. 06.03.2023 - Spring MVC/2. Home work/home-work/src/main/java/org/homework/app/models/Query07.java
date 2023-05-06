package org.homework.app.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.entries.Person;

@Getter
@Setter
@NoArgsConstructor
public class Query07 {
    
    // id
    private Long id;

    // персона
    private Person person;

    // суммарная стоимость
    private Long sumPrice;

    // минимальная цена
    private int minPrice;
    
    // максимальная цена
    private int maxPrice;

    // количество
    private Long count;

    
    public Query07(Long id, Person person, Long sumPrice, int minPrice, int maxPrice, Long count) {
        this.id = id;
        this.person = person;
        this.sumPrice = sumPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.count = count;
    }
}
