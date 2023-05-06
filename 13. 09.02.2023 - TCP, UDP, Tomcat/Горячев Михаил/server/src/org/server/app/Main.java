package org.server.app;

import org.server.app.controllers.ServerController;

public class Main {
    public static void main(String[] args) throws Exception {
        new ServerController().run();
    }
}