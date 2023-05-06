package app.models;

// Модель Выражение для задания 1
public class Expression {

    // число A
    public double a;
    
    // число B
    public double b;
    
    
    // конструктор
    public Expression(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    
    // вариант A вычисление z1
    public double z1varA() {
        var temp = 2d * this.b - this.a; 
        return (Math.sin(this.a) + Math.cos(temp)) / (Math.cos(this.a) - Math.sin(temp));
    }
    
    // вариант A вычисление z2
    public double z2varA() {
        return (1d + Math.sin(2d * this.b)) / Math.cos(2d * this.b);
    }
    
    // вариант B вычисление z1
    public double z1varB() {
        var temp1 = this.a + 2d;
        var temp2 = Math.sqrt(2d * a);
        return ((temp1 / temp2) - (this.a / (2d + temp2)) + (2d / (this.a - temp2))) * ((Math.sqrt(this.a) - Math.sqrt(2d)) / (this.a + 2d));
    }
    
    // вариант B вычисление z2
    public double z2varB() {
        return 1d / (Math.sqrt(this.a) + Math.sqrt(2d));
    }
}
