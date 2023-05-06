package org.homework.app.models.queries;

import java.util.Date;

public class Query04 {
    private Date appointmentDate;
    private int amount;
    private int minPercent;
    private double avgPercent;
    private int maxPercent;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinPercent() {
        return minPercent;
    }

    public void setMinPercent(int minPercent) {
        this.minPercent = minPercent;
    }

    public double getAvgPercent() {
        return avgPercent;
    }

    public void setAvgPercent(double avgPercent) {
        this.avgPercent = avgPercent;
    }

    public int getMaxPercent() {
        return maxPercent;
    }

    public void setMaxPercent(int maxPercent) {
        this.maxPercent = maxPercent;
    }

    public Query04() {
    }

    public Query04(
            Date appointmentDate,
            int amount,
            int minPercent,
            double avgPercent,
            int maxPercent) {
        this.appointmentDate = appointmentDate;
        this.amount = amount;
        this.minPercent = minPercent;
        this.avgPercent = avgPercent;
        this.maxPercent = maxPercent;
    }

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<td>%1$td.%1$tm.%1$tY</td>" +
                "<td align='right'>%2$d</td>" +
                "<td align='right'>%3$d</td>" +
                "<td align='right'>%4$.3f</td>" +
                "<td align='right'>%5$d</td>" +
                "</tr>",
                appointmentDate,
                amount,
                minPercent,
                avgPercent,
                maxPercent
        );
    }

}
