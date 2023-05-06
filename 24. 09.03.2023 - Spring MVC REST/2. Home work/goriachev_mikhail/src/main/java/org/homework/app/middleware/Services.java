package org.homework.app.middleware;

import org.homework.app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
    
    // клиенты
    @Autowired
    public ClientsService clientsService;
    
    // страны
    @Autowired
    public CountriesService countriesService;
    
    // цели поездки
    @Autowired
    public ObjectivesService objectivesService;
    
    // маршруты
    @Autowired
    public RoutesService routesService;
    
    // поездки
    @Autowired
    public VisitsService visitsService;
}
