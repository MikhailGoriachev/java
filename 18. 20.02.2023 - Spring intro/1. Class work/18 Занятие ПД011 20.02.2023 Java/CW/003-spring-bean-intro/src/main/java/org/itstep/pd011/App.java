package org.itstep.pd011;

import org.itstep.pd011.models.Bus;
import org.itstep.pd011.models.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  Пример приложения с использованием бинов, загружаемых из контекста
 *  контекст определяем в XML-файле
 */
public class App 
{
    public static void main( String[] args )
    {
        // получить контекст приложения, из контекста будем брать бины
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("\n\033[1mВывод данных бинов Student, Bus, полученных из контекста приложения\033[0m");

        // получить два бина - объекты класса Student
        Student student1 = ctx.getBean("student1", Student.class);
        Student student2 = ctx.getBean("student2", Student.class);

        // получить два бина - объекты класса Bus
        Bus bus1 = ctx.getBean("bus1", Bus.class);
        Bus bus2 = ctx.getBean("bus2", Bus.class);

        // Вывод данных о студентах
        System.out.printf("\n\t%s\n\t%s\n", student1, student2);

        // Вывод данных об автобусах
        System.out.printf("\n\t%s\n\t%s\n\n", bus1, bus2);

        // можно создавать объекты обычным образом
        var st = new Student("Леонидова", "Елена", "Леонидовна", 1992, "Енакиево", "ДЛ-123");
        var b = new Bus("89", "АВ345В", "Скороходв А.В.", 34);
        System.out.printf("\n\033[1mСоздание объектов традиционно, при помощи new:\033[0m\n\t%s\n\t%s\n\n", st, b);

        System.out.println("\n\n\033[1mРабота приложения завершена\033[0m\n\n");
    } // main
} // class App
