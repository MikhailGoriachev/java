package org.itstep.pd011;

import java.security.InvalidParameterException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        double a, b, c;

        while(true) {
            try {
                System.out.print("\nТри стороны треугольника (0 0 0 для выхода): ");
                a = Utils.sc.nextDouble();
                b = Utils.sc.nextDouble();
                c = Utils.sc.nextDouble();
                if (a == 0 && b == 0 && c == 0) break;

                triangle.setSides(a, b, c);
                System.out.println("\nТреугольник: " + triangle);
            } catch (InvalidParameterException e) {
                System.out.printf(Locale.UK, "\n\033[31m%s\033[0m\n", e.getMessage());
            } catch (Exception e) {
                System.out.printf(Locale.UK, "\n\033[32m%s\033[0m\n", e.getMessage());
            } // try-catch

        }// while
    } // main
}
