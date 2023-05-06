// пакет приложения ~~ пространство имен С#
// package имяПакета;
// принцип образования имени пакета - URL "наоборот"
// URL: pd011.itstep.org  --> имя пакета: org.itstep.pd011
package org.itstep.pd011; // --> src/org/itstep/pd011/*.java

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("Привет, мир \"Java\" из мира \033[34mPHP!\033[0m");

        int a = 42;
        short b = -5;
        byte c = 12;
        float f = 5.7f;
        double t = 7.5;

        String s = "Это строка в UTF";
        char ch = 'ю';

        boolean flag = true;
        System.out.println("a = " + a + ", b = " + b);

        System.out.printf("a = %d, b = %d, f = %.3f, t = %.3f, s = \"%s\", ch = '%c'\n", a, b, f, t, s, c);
        
        System.out.printf("\n\tКорень кубический из %.3f", t);
        t = Math.pow(t, 1./3.);
        System.out.printf(" равен %.3f\n", t);

        System.out.println();
        System.out.printf("%d", b );
    }
}