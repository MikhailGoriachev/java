package org.itstep.pd011;

import java.util.Arrays;

// класс Cinemas - прокатная фирма, имеющая сеть кинотеатров, т.е. класс для работы с коллекцией
// объектов типа Кинотеатр (Cinema)
// тип Кинотеатр - внутренний класс Cinema
public class Cinemas {
    private String name;       // название фирмы
    private Cinema[] cinemas;  // кинотеатры фирмы

    // конструкторы
    public Cinemas() { }
    public Cinemas(String name, Cinema[] cinemas) {
        this.name = name;
        this.cinemas = cinemas;
    } // Cinemas

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    } // setName

    public Cinema[] getCinemas() { return cinemas; }
    public void setCinemas(Cinema[] cinemas) {
        this.cinemas = cinemas;
    } // setCinemas

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\"\033[34m" + name + "\033[0m\"\n");

        // вывод коллекции/массива кинотеатров в виде таблицы
        sb.append(header());
        for (Cinema cinema:cinemas) {
            sb.append(cinema).append("\n");
        } // for cinema
        sb.append(hr());

        return sb.toString();
    } // toString

    private String header() {
        String str = "| Название кинотеатра  | Адрес кинотеатра     | Сеансы кинотеатра       | Фильм                          |\n";
        return hr() + str + hr();
    } // header

    private String hr() {
        return "+----------------------+----------------------+-------------------------+--------------------------------+\n";
    } // footer


    // запросы к массиву (коллекции) кинотеатров

    // Вывести кинотеатры/кинотеатр с максимальным количеством сеансов
    public void getMaxNumberSessions() {
        int maxNumSession = getMaxNumSession();

        StringBuffer sb = new StringBuffer(
            String.format("\nКинотеатры/кинотеатр с максимальным количеством сеансов (%d):\n", maxNumSession));
        sb.append(header());
        for (Cinema cinema:cinemas) {
            if (cinema.sessions.length == maxNumSession)
                sb.append(cinema).append("\n");
        } // for cinema
        sb.append(hr());

        System.out.println(sb); // вывод одной операцией
    } // getMaxNumberSessions

    // возвращает максимальное количество сеансов
    private int getMaxNumSession() {
        int maxNumSession = cinemas[0].sessions.length;

        for (int i = 1; i < cinemas.length; i++) {
            int numSession = cinemas[i].sessions.length; // количество сеансов
            if (numSession > maxNumSession) maxNumSession = numSession;
        } // for i
        return maxNumSession;
    } // getMaxNumSession

    // вывести список различных фильмов и кинотеатров в которых он идет
    public void getFilmsByCinema() {
        String[] distinctFilms = getDistinctFilm();

        StringBuffer sb = new StringBuffer("Фильмы и кинотеатры, в которых они прокатываются\n");
        sb.append("+--------------------------------+-----------------------------------------------+\n");
        sb.append("| Название фильма                | Кинотеатры, в которых прокатывается фильм     |\n");
        sb.append("+--------------------------------+-----------------------------------------------+\n");

        for (String film: distinctFilms) {
            sb.append(String.format("| %-30s | ", film));
            StringBuilder str = new StringBuilder("");
            for (Cinema cinema: cinemas) {
                if (film.equals(cinema.film)) str.append(cinema.name).append(", ");
            } // for cinema
            sb.append(String.format("%-45s |\n", str.substring(0, str.length()-2)));
        } // for film
        sb.append("+--------------------------------+-----------------------------------------------+\n");

        System.out.println(sb);
    } // getFilmsByCinema

    // получить список различных фильмов
    private String[] getDistinctFilm() {
        // создаем вспомогательный массив максимальной длины
        String[] films = new String[cinemas.length];
        films[0] = cinemas[0].film; // начальное заполнение
        int filmCounter = 1;

        for (int i = 1; i < cinemas.length; i++) {
            int index = indexOf(cinemas[i].film, films);
            if (index < 0) films[filmCounter++] = cinemas[i].film;
        } // for i

        // возвращаем массив названий фильмов, размер массива - минимально необходимый
        return Arrays.copyOf(films, filmCounter);
    } // getDifferentFilm

    // поиск фильма по названию в массиве строк films - возвращаем индекс
    // найденного фильма или -1, если такого фильма нет в массиве
    private int indexOf(String film, String[] films) {
        int index = -1;
        for (int i = 0; i < films.length; i++) {
            if (films[i] == null) break;
            // сравнение строк
            if (films[i].equals(film)) {
                index = i;
                break;
            } // if
        } // for i
        return index;
    } // indexOf

    // Вывести кинотеатры/кинотеатр с самым поздним сеансом
    public void getLaterSession() {
        int laterSessionTime = getLaterSessionTime();

        StringBuffer sb = new StringBuffer(
                String.format("\nКинотеатры/кинотеатр с самым поздним сеансом (на %02d:%02d):\n", laterSessionTime / 60, laterSessionTime % 60));
        sb.append(header());
        for (Cinema cinema:cinemas) {
            if (cinema.sessions[cinema.sessions.length-1] == laterSessionTime)
                sb.append(cinema).append("\n");
        } // for cinema
        sb.append(hr());

        System.out.println(sb); // вывод одной операцией
    } // getLaterSession

    // получить время самого позднего сеанса
    private int getLaterSessionTime() {
        int latestTime = cinemas[0].sessions[cinemas[0].sessions.length-1];

        for (int i = 1; i < cinemas.length; i++) {
            int laterTime = cinemas[i].sessions[cinemas[i].sessions.length-1]; // начало последнего сеанса
            if (laterTime > latestTime) latestTime = laterTime;
        } // for i
        return latestTime;
    } // getLaterSessionTime


    ///////////////////////////////////////////////////////////////
    // Внутренный класс, описывающий кинотеатр
    public class Cinema {
        private String name;       // название
        private String address;    // адрес кинотеатра
        private int[]  sessions;   // время начала сеанса в минутах
        private String film;       // название фильма

        public Cinema() {this("Кинодом", "пр. Ватутина, 12", new int[] {}, "");}
        public Cinema(String name, String address, int[] sessions, String film) {
            this.name = name;
            this.address = address;
            this.sessions = sessions;
            this.film = film;
        } // Cinema

        public String getName() { return name; }
        public void setName(String name) {
            this.name = name;
        } // setName

        public String getAddress() { return address; }
        public void setAddress(String address) {
            this.address = address;
        } // setAddress

        public int[] getSessions() {  return sessions; }
        public void setSessions(int[] sessions) {
            this.sessions = sessions;
        } // setSessions

        public String getFilm() { return film; }
        public void setFilm(String film) {
            this.film = film;
        } // setFilm

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("| %-20s | %-20s | %-23s | %-30s |", name, address, sessionsToString(), film));
            return sb.toString();
        } // toString

        // выводим сеансы в строковом формате
        private String sessionsToString() {
            StringBuilder sbf = new StringBuilder();
            for (int session:sessions) {
                sbf.append(String.format("%02d:%02d ", session / 60, session % 60));
            } // for session

            // убираем хвостовой пробел из выходной строки
            return sbf.toString().trim();
        } // sessionsToString
    } // class Cinema
} // class Cinemas
