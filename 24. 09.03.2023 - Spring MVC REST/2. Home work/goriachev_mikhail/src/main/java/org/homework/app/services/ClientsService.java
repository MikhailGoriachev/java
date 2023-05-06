package org.homework.app.services;

import org.homework.app.entries.Client;

import java.util.List;


public interface ClientsService {
    
    // все записи
    List<Client> findAll();
    
    // запись по id
    Client findById(Long id);
    
    // добавить запись
    void store(Client item);
    
    // изменить запись
    void update(Client item);    
}
