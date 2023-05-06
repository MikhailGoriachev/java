package org.itstep.pd011;

public class Main {

    public static void main(String[] args) {
        // создать компанию с массивом данных для обработки
        Cinemas cinemaCompany = new Cinemas("Кинопрокат № 1", new Cinemas.Cinema[] {
            new Cinemas().new Cinema("Металлург", "ул. Заводская, 35",
                new int[] {mkTime(8, 0), mkTime(11, 0), mkTime(14, 0), mkTime(17, 0)},
                "Валериан и город 1000 планет"),
            new Cinemas().new Cinema("Донецк", "пр. Ильича, 88",
                new int[] {mkTime(8, 0), mkTime(11, 0), mkTime(14, 0), mkTime(17, 0)},
                "Пятый элемент"),
            new Cinemas().new Cinema("Комсомолец", "ул. Артема, 36",
                new int[] {mkTime(10, 0), mkTime(13, 0), mkTime(16, 0), mkTime(19, 0)},
                "Красавица и Чудовище"),
            new Cinemas().new Cinema("им. Т.Г. Шевченко", "ул. Артема, 123",
                new int[] {mkTime(8, 0), mkTime(11, 0), mkTime(14, 0), mkTime(17, 0)},
                "Валериан и город 1000 планет"),
            new Cinemas().new Cinema("Мультиплекс", "ул. Артема, 130",
                new int[] {mkTime(9,0), mkTime(12, 0), mkTime(15, 0)},
                "Гудзонский ястреб"),
            new Cinemas().new Cinema("Кристалл", "ул. Стадионная, 32а",
                new int[] {mkTime(9,0), mkTime(12, 0), mkTime(15, 0), mkTime(18, 0)},
                "Валериан и город 1000 планет"),
            new Cinemas().new Cinema("Победа", "пр. Ильича, 18",
                new int[] {mkTime(8, 0), mkTime(11, 0), mkTime(14, 0), mkTime(17, 0)},
                "Пятый элемент"),
            new Cinemas().new Cinema("Юность", "ул. Куйбышева, 85",
                new int[] {mkTime(10, 0), mkTime(13, 0), mkTime(16, 0)},
                "Бездна"),
            new Cinemas().new Cinema("Кальмиус", "ул. Набережная, 6",
                new int[] {mkTime(19, 0), mkTime(22, 30)},
                "Пятый элемент"),
            new Cinemas().new Cinema("Зеленый", "ул. Стадионная, 48",
                new int[] {mkTime(19, 30), mkTime(22, 30)},
                "Пятый элемент")
        });
        System.out.println("\nДанные о прокатной фирме: " + cinemaCompany);

        // a) Вывести кинотеатры/кинотеатр с максимальным количеством сеансов
        cinemaCompany.getMaxNumberSessions();

        // b) Вывести список различных фильмов и кинотеатров, в которых этот фильм демонстрируется
        cinemaCompany.getFilmsByCinema();

        // c) Вывести кинотеатры/кинотеатр с самым поздним сеансом
        cinemaCompany.getLaterSession();
    } // main

    // вспомогательный метод для формирования времени начала сеанса
    private static int mkTime(int hr, int mn) { return 60*hr + mn; }
} // class Main
