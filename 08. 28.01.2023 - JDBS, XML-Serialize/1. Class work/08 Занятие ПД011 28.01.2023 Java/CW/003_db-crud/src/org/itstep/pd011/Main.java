package org.itstep.pd011;

import java.sql.*;
import java.util.List;

// Project Settings -> Libraries -> + -> Java:
public class Main {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр по работе с БД, в этом экземпляре реализуем все запросы к БД
            DbHandler dbHandler = DbHandler.getInstance();

            System.out.print("\033[32mСоединение установлено\033[30m\n");

            List<Client> clients = dbHandler.getAllClients();
            showClients(clients);


            System.out.println("\n\t\033[1mCreate\033[0m: Добавление записи");
            dbHandler.addClient(new Client("Романова'; drop table clients;", "Анастасия", "Михайловна",
                    "ОР567765", 0.34));
            clients = dbHandler.getAllClients();
            showClients(clients);


            // Чтение записи по id
            System.out.println("\n\t\033[1mRead\033[0m: Чтение записи по id");
            Client client = dbHandler.getClientById(10);
            System.out.printf("%s\t%s\n%s\n", Client.HEADER, client.toTableRow(), Client.FOOTER);

            // Изменение записи по id
            System.out.println("\n\t\033[1mUpdate\033[0m: Изменение записи по id");
            client.discount += 0.3;
            if (dbHandler.updateClient(client) > 0) {
                System.out.printf("%s\t%s\n%s\n", Client.HEADER, client.toTableRow(), Client.FOOTER);
            } else
                System.out.println("\n\t\033[31;1mОбновление не прошло\033[0m");
            // if

            // удаление записи по id
            System.out.println("\n\t\033[1mDelete\033[0m: Удаленение записи по id");
            int id = clients.stream()
                    .filter(c -> c.passport.equals("ОР567765"))
                    .findFirst()
                    .get().id;

            if (dbHandler.deleteClient(id) > 0) {
                clients = dbHandler.getAllClients();
                showClients(clients);
            } else
                System.out.println("\n\t\033[31;1mУдаление не прошло\033[0m");
            // if

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