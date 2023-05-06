package org.homework.app.models.queries;

public class Query05 {
    private String speciality;
    private int amount;
    private int minPrice;
    private double avgPrice;
    private int maxPrice;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Query05() {
    }

    public Query05(
            String speciality,
            int amount,
            int minPrice,
            double avgPrice,
            int maxPrice) {
        this.speciality = speciality;
        this.amount = amount;
        this.minPrice = minPrice;
        this.avgPrice = avgPrice;
        this.maxPrice = maxPrice;
    }

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<td>%s</td>" +
                "<td align='right'>%d</td>" +
                "<td align='right'>%d</td>" +
                "<td align='right'>%.3f</td>" +
                "<td align='right'>%d</td>" +
                "</tr>",
                speciality,
                amount,
                minPrice,
                avgPrice,
                maxPrice
        );
    }

}
