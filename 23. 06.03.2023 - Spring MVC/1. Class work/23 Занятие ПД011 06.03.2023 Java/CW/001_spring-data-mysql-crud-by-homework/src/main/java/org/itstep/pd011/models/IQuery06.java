package org.itstep.pd011.models;

// Для преобразования результатов запроса 6
// (агрегация)
// https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
public interface IQuery06 {
    String getSurname();
    String getName();
    String getPatronymic();
    String getPassport();
    Integer getTotalSale();
    Integer getSalesFact();
    Integer getMinSale();
    Integer getMaxSale();

    default  String toResultString() {
        return String.format(
            "Query06 {%-20s | %-15s | %-20s | %-15s | %10d.00 | %6d | %6d.00 | %6d.00 }",
            getSurname(), getName(), getPatronymic(), getPassport(),
            getTotalSale(), getSalesFact(), getMinSale(), getMaxSale()
        );
    } // toResultString
}





