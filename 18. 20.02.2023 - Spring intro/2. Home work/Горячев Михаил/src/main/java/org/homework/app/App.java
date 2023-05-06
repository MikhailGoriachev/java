package org.homework.app;

import org.homework.app.models.Book;
import org.homework.app.models.Kettle;
import org.homework.app.models.Workout;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        var sb = new StringBuilder();

        // обработка чайников
        proc01(ctx, sb);

        // обработка тренировок
        proc02(ctx, sb);

        // обработка книг
        proc03(ctx, sb);
        
        // вывод заданий
        System.out.println(sb);
    }

    // 1.	Три бина для объектов класса Чайник, найти чайник с минимальным временем нагрева
    public static void proc01(ApplicationContext ctx, StringBuilder sb) {
        List<Kettle> list = List.of(
                ctx.getBean("kettle01", Kettle.class),
                ctx.getBean("kettle02", Kettle.class),
                ctx.getBean("kettle03", Kettle.class)
        );

        var min = list.stream().min(Comparator.comparing(Kettle::getHeatingTime)).get();

        // вывод всех чайников
        toKettlesTable(list, sb, "Чайники");

        // чайник с минимальным временем нагрева 
        toKettlesTable(List.of(min), sb, "Чайник с минимальным временем нагрева");
    }

    // вывод таблицы чайников
    public static void toKettlesTable(List<Kettle> list, StringBuilder sb, String title) {
        sb
                .append("\t+————————————————————————————————————————————————————————————————————————————————————————————+\n")
                .append(String.format("\t| %-90s |\n", title))
                .append("\t+————+—————————————————+—————————————————+—————————————————+————————————————+————————————————+\n")
                .append("\t| id | Производитель   | Модель          | Мощность (Вт)   | Нагрев (с)     | Удерж. (мин)   |\n")
                .append("\t+————+—————————————————+—————————————————+—————————————————+————————————————+————————————————+\n");

        list.forEach(k -> sb.append(k.toTableRow()));

        sb.append("\t+————+—————————————————+—————————————————+—————————————————+————————————————+————————————————+\n\n");
    }

    // 2.	Два бина для объектов класса Тренировка, найти суммарную продолжительность тренировок
    public static void proc02(ApplicationContext ctx, StringBuilder sb) {
        var workout1 = ctx.getBean("workout01", Workout.class);
        var workout2 = ctx.getBean("workout02", Workout.class);

        var duration1 = workout1.getDuration().toSeconds();
        var duration2 = workout2.getDuration().toSeconds();

        var title = "Тренировки. Суммарная продолжительность: " +
                LocalTime.ofSecondOfDay(duration1 + duration2) +
                " (ЧЧ:СС)";

        toWorkoutsTable(List.of(workout1, workout2), sb, title);
    }

    // вывод таблицы тренировок
    public static void toWorkoutsTable(List<Workout> list, StringBuilder sb, String title) {
        sb
                .append("\t+————————————————————————————————————————————————————————————————————————————————————————————————————————————————+\n")
                .append(String.format("\t| %-110s |\n", title))
                .append("\t+————+—————————————————————+—————————————————————+———————————————————+—————————————————+————————————+————————————+\n")
                .append("\t| id | Начало тренировки   | Конец тренировки    | Продолж. (ЧЧ:СС)  | Тренер          | Инвентарь  | Помещение  |\n")
                .append("\t+————+—————————————————————+—————————————————————+———————————————————+—————————————————+————————————+————————————+\n");

        list.forEach(w -> sb.append(w.toTableRow()));

        sb.append("\t+————+—————————————————————+—————————————————————+———————————————————+—————————————————+————————————+————————————+\n\n");
    }

    // 3.	Три бина для объектов класса Книга, средний размер книги в байтах
    public static void proc03(ApplicationContext ctx, StringBuilder sb) {
        var list = List.of(
                ctx.getBean("book01", Book.class),
                ctx.getBean("book02", Book.class),
                ctx.getBean("book03", Book.class)
        );
        
        var avgSize = (int)list
                .stream()
                .mapToInt(Book::getSize)
                .average()
                .getAsDouble();

        var title = "Книги. Средний размер байтах: " + avgSize;
        
        toBooksTable(list, sb, title);
    }

    // вывод таблицы книг
    public static void toBooksTable(List<Book> list, StringBuilder sb, String title) {
        sb
                .append("\t+——————————————————————————————————————————————————————————————————————————————————————————————————————————+\n")
                .append(String.format("\t| %-104s |\n", title))
                .append("\t+————+————————————+——————————————————————+——————————————————————————————————————————+———————————————+——————+\n")
                .append("\t| id | Формат     | Автор                | Название                                 | Размер (байт) | Год  |\n")
                .append("\t+————+————————————+——————————————————————+——————————————————————————————————————————+———————————————+——————+\n");

        list.forEach(b -> sb.append(b.toTableRow()));

        sb.append("\t+————+————————————+——————————————————————+——————————————————————————————————————————+———————————————+——————+\n\n");
    }
}
