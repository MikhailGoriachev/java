package app.controllers;

import app.interfaces.IController;
import app.models.Proc01;
import app.models.Proc02;
import app.models.Proc03;
import app.models.Proc04;
import app.utils.Utils;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Контроллер Задание 1
public class Task01Controller implements IController {

    public Task01Controller() throws Exception {
    }

    // работа по заданию
    public void run() throws InterruptedException {
        var threads = new ArrayList<Thread>(List.of(
                new Thread(new Proc01()),
                new Thread(new Proc02()),
                new Thread(new Proc03()),
                new Thread(new Proc04())
        ));
        
        // запуск потоков
        threads.forEach(Thread::start);

        // привязка для ожидания
        for (Thread thread : threads) 
            thread.join();
    }
}