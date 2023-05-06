package org.itstep.pd011;

import java.util.List;
 
public class Main {
    public static void main(String[] args) {
        try {
            // При появлении исключения Public Key Retrieval is not allowed
            // требуется войти в workbench CE или установить useSSL=true

            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();

            System.out.print("\033[1;4mСоединение установлено\033[0m\n");

            System.out.println("\n\tВсе записи таблицы \033[1mclients\033[0m");
            List<Client> clients = dbHandler.getAllClients();
            showClients(clients);

            // демонстрация транзакции
            // dbHandler.demoTransaction();

            // демонстрация пакетного выполнения запросов
            dbHandler.batchDemo();

            System.out.println("\n\tВсе записи таблицы \033[1mclients\033[0m");
            clients = dbHandler.getAllClients();
            showClients(clients);

        } catch (Exception e) {
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