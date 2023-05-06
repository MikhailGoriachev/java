package app.interfaces.task04;

// Интерфейс для фигуры
public interface IBody {
    
    // площадь
    double area();
    
    // объём
    double volume();
    
    // вывод в строку таблицы
    String toTableRow(int n);
}
