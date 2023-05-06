package org.itstep.pd011;

// объектное представление таблицы клиентов БД insurance
// таблица Clients
public class Client {
    public int id;
    public String surname;
    public String name;
    public String patronymic;
    public String passport;
    public double discount;

    //region конструкторы
    public Client() {
        this(-1, "", "", "", "",  0);
    } // Client

    public Client(String surname, String name, String patronymic, String passport, double discount) {
        this(-1, surname, name, patronymic, passport, discount);
    } // Client

    // представление объекта класса в виде стоки таблицы
    public String toTableRow() {
        return String.format(
                "│ %3d │ %-12s │ %-12s │ %-12s │ %-8s │ %7.2f    │",
                id, surname, name, patronymic, passport, discount
        );
    } // toTableRow

    public Client(int id, String surname, String name, String patronymic, String passport, double discount) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
        this.discount = discount;
    } // Client
    //endregion

    public static final String HEADER =
            "\t┌─────┬──────────────┬──────────────┬──────────────┬──────────┬────────────┐\n"+
            "\t│  Ид │ Фамилия      │ Имя          │ Отчество     │ Паспорт  │ Дисконт, % │\n"+
            "\t├─────┼──────────────┼──────────────┼──────────────┼──────────┼────────────┤\n";

    public static final String FOOTER =
            "\t└─────┴──────────────┴──────────────┴──────────────┴──────────┴────────────┘\n";

} // class Client
