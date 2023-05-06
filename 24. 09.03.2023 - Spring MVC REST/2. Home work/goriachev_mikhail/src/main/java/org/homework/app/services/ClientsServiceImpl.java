package org.homework.app.services;

//import com.sun.istack.NotNull;
import org.homework.app.entries.Client;
import org.homework.app.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientsServiceImpl implements ClientsService {
    
    // репозиторий
    private ClientsRepository repository;
    
    @Autowired
    public void setRepository(ClientsRepository repository) {
        this.repository = repository;
    }
    
    // сервис
    @Autowired
    private ClientsService service;
    
    // все записи
    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    // запись по Id
    @Override
    public Client findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Client item) {
        item.setId(0L);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Client item) {
        repository.saveAndFlush(item);
    }
}
