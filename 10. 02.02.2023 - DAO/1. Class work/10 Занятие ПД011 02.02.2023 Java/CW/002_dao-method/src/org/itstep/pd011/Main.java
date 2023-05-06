package org.itstep.pd011;

import java.util.List;

// модель - класс с операциями и 2 интерфейса: базовые CRUD и необязательные
// спец-запросы к таблице
public class Main {

    public static void main(String[] args) {
	    AbonentDaoImpl abonentDao = new AbonentDaoImpl();

        try {
            // BaseDao
            List<Abonent> abonentList = abonentDao.findAll();

            System.out.println("\n\033[1;4mСписок абонентов в телефонной книге\033[0m");
            abonentList.forEach(System.out::println);

            // AbonentDao
            String surnamePattern = "Ива";
            abonentList = abonentDao.findAbonentByLastname(surnamePattern + "%");

            System.out.printf("\nСписок абонентов телефонной книги, фамилия которых начинается на %s\n", surnamePattern);
            abonentList.forEach(System.out::println);
        } catch (DaoException e) {
            e.printStackTrace();
        } // try

    } // main
} // class Main
