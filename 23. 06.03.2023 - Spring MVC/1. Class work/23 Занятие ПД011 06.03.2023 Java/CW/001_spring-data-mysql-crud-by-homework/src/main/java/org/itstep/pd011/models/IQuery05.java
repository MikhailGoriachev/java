package org.itstep.pd011.models;

// Для преобразования результатов запроса 5
// (агрегация)
// https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
public interface IQuery05 {
    String getName();
    Double getAveragePrice();
    Integer getAmount();

    default  String toResultString() {
        return String.format(
                "Query05 {%-30s | %12.2f | %6d }",
                getName(), getAveragePrice(), getAmount()
        );
    } // toResultString
} // class Query05
