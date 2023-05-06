package org.itstep.pd011;

import org.itstep.pd011.controllers.SolutionController;
import org.itstep.pd011.utils.Utils;

// Разработайте консольное приложение для наработки навыков программирования
// операций с бинарными файлами по следующему заданию:
// Создайте файл, хранящий электроприборы (название прибора, производитель
// прибора, мощность – вещественное число, состояние – включен или выключен).
// Добавить электроприбор в файл.
// Упорядочить электроприборы в файле по возрастанию мощности.
public class Main {

    public static void main(String[] args) {
        // SolutionController solutionController = new SolutionController("my_data", "devices.bin");
        SolutionController solutionController = new SolutionController();

        String menu = "\n" +
            "\033[47m    \033[40;37;1m    Обработка данных в бинарных файлах   \033[47m    \033[0m\n" +
            "\033[35;1m1\033[0m - \033[1mпоказать\033[0m электроприборы в файле данных\n" +
            "\033[35;1m2\033[0m - \033[1mдобавить\033[0m электроприбор в файл данных\n" +
            "\033[35;1m3\033[0m - \033[1mупорядочить\033[0m электроприборы в файле по возрастанию мощности\n" +
            "\033[35;1m0\033[0m - \033[1mвыход\033[0m из приложения\n" +
            ">>> ";
        int cmd; // команда меню

        while(true) {
            try {
                // Вывод меню, ввод команды
                cmd = Utils.getInt(menu, 0, 3);

                // обработка команд
                switch (cmd) {
                    case 1:  // показать электроприборы в файле данных
                        solutionController.showAppliance("\nКоллекция электроприборов:\n");
                        break;
                    case 2: // добавить электроприбор в файл данных
                        solutionController.addAppliance();
                        solutionController.showAppliance("\nКоллекция электроприборов:\n");
                        break;
                    case 3: // упорядочить электроприборы в файле по возрастанию мощности
                        solutionController.orderByPower();
                        solutionController.showAppliance("\nКоллекция электроприборов:\n");
                        break;
                    case 0: // выход из приложения
                        System.exit(0);
                        break;
                } // switch
            } catch(Exception ex) {
                System.out.printf("\n\033[31;1mОшибка %s при работе приложения\033[0m\n\n", ex.getMessage());
            } // try-catch
        } // while
    } // main
} // class Main
