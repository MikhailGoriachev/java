package org.itstep.pd011;

// объектное представление таблицы клиентов БД insurance
// таблица Clients
public record Client(int id, String surname, String name, String patronymic, String passport, double discount)
{

    //region конструкторы
    public Client() {
        this(-1, "", "", "", "",  0);
    } // Client

    // все, кроме ид
    public Client(String surname, String name, String patronymic, String passport, double discount) {
        this(-1, surname, name, patronymic, passport, discount);
    } // Client
    //endregion


    @Override
    public int id() {
        return id;
    }

    @Override
    public String surname() {
        return surname;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String patronymic() {
        return patronymic;
    }

    @Override
    public String passport() {
        return passport;
    }

    @Override
    public double discount() {
        return discount;
    }

    // представление объекта класса в виде строки таблицы
    public String toTableRow() {
        return String.format(
            "│ %3d │ %-12s │ %-12s │ %-12s │ %-8s │ %7.2f    │",
            id, surname, name, patronymic, passport, discount
        );
    } // toTableRow

    public static final String HEADER =
        "\t┌─────┬──────────────┬──────────────┬──────────────┬──────────┬────────────┐\n"+
        "\t│  Ид │ Фамилия      │ Имя          │ Отчество     │ Паспорт  │ Дисконт, % │\n"+
        "\t├─────┼──────────────┼──────────────┼──────────────┼──────────┼────────────┤\n";

    public static final String FOOTER =
        "\t└─────┴──────────────┴──────────────┴──────────────┴──────────┴────────────┘\n";

} // record Client
