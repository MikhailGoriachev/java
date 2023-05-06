package org.itstep.pd011;

import org.itstep.pd011.controllers.SolutionController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String in = "data/persons.csv";
        String out = "data/out_persons.csv";
        SolutionController solutionController = new SolutionController(in);

        System.out.printf("\nИсходные данные:\n%s", solutionController);

        solutionController.write(out);
        System.out.println("Данные записаны в файл \"" + out + "\" вполне себе успешно :)\n");
    } // main
}
