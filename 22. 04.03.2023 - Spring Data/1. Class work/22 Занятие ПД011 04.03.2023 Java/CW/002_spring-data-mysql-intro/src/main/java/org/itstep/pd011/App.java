package org.itstep.pd011;

import org.itstep.pd011.entities.Client;
import org.itstep.pd011.repositories.ClientRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("\n*** Привет, Spring Data ***");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // получить репозиторий, таблицу clients
        ClientRepository clientRepository = context.getBean(ClientRepository.class);

        System.out.println();

        List<Client> clientList = clientRepository.findAll();
        clientList.forEach(System.out::println);

        System.out.println();

        clientList = clientRepository.findAllByDiscountLessThan(0.2);
        clientList.forEach(System.out::println);

        System.out.println();
    }
}
