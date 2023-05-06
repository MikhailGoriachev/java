package org.itstep.pd011;

import org.itstep.pd011.controllers.SolutionController;

public class Main {

    public static void main(String[] args) {
        SolutionController solutionController = new SolutionController("data/persons.csv");

        System.out.printf("\nИсходные данные:\n%s", solutionController);

        // сгруппировать людей по городам проживания
        // вывести города группировки
        // вывести людей, проживающих в каждом городе группировки
        // solutionController.query01();

        // Группировка по возрасту, вывести состав возрастных групп, количество персон
        // в возрастных группах
        // solutionController.query02();

        // Вывести суммарный вес персон по городам
        // solutionController.query03();

        // Найти самого легкого, самого тяжелого и самого старого в городе
        solutionController.query04();

        // Вывод суммарной статистики по весу при группировке персон по городу
        // количество персон в городе, суммарный, минимальный, средний, максимальный вес
        // solutionController.query05();

        // Вывод суммарной (итоговой) статистики по возрасту при группировке персон по городу
        // количество персон в городе, суммарный, минимальный, средний, максимальный возраст
        // solutionController.query06();
    } // main
}
