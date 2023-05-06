package app;

import app.controllers.Task01Controller;
import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        new Task01Controller().run();
    }
}