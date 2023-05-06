package org.itstep.pd011;

import java.sql.*;
import java.util.List;
 
public class Main {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();

            System.out.print("\033[32mСоединение установлено\033[30m\n");

            List<Client> clients = dbHandler.getAllClients();
            showClients(clients);

            // добавление записи
            System.out.println("\n\t\033[1mCreate\033[0m: Добавление записи - подготовленный оператор");
            dbHandler.addClientPs(new Client("Романова", "Анастасия", "Михайловна", "ОР567765", 0.34));
            clients = dbHandler.getAllClients();
            showClients(clients);

            // Чтение записи по id
            System.out.println("\n\t\033[1mRead\033[0m: Чтение записи по id - подготовленный оператор");
            Client client = dbHandler.getClientPs(10);
            System.out.printf("%s\t%s\n%s\n", Client.HEADER, client.toTableRow(), Client.FOOTER);

            // Изменение записи по id
            System.out.println("\n\t\033[1mUpdate\033[0m: Изменение записи по id - подготовленный оператор");
            client.discount += 0.3;
            client.surname = "Горонкова";
            if (dbHandler.updateClientPs(client) > 0) {
                System.out.printf("%s\t%s\n%s\n", Client.HEADER, client.toTableRow(), Client.FOOTER);
            } else
                System.out.println("\n\t\033[31;1mОбновление не прошло\033[0m");

            // Удаление записи по id
            System.out.println("\n\t\033[1mDelete\033[0m: Удаленение записи по id");
            int id = clients.stream().filter(c -> c.passport.equals("ОР567765"))
                    .findFirst()
                    .get().id;

            if (dbHandler.deleteClientPs(id) > 0) {
                clients = dbHandler.getAllClients();
                showClients(clients);
            } else
                System.out.println("\n\t\033[31;1mУдаление не прошло\033[0m");
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // main

    // вывести всех клиентов из коллекции
    private static void showClients(List<Client> clients) {
        System.out.print(Client.HEADER);

        clients.forEach(c -> System.out.printf("\t%s\n", c.toTableRow()));
        System.out.println(Client.FOOTER);
    } // showClients


}