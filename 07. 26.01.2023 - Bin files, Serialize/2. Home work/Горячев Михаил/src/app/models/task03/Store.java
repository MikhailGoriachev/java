package app.models.task03;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


//  Задача 3. Моделирование работы склада. Данные склада хранятся в файле формата CSV (первая строка содержит название 
//  и адрес склада, остальные строки – данные о товарах). По приведенному набору данных разработайте класс Goods, 
//  описывающий товар и класс Store для хранения и обработки коллекции товаров. В таблице столбец Стоимость и строка 
//  Итого – вычисляемые, хранить их не надо.
//
//      Перечень товаров на складе «Оптовый», г. Донецк, ул. Циолковского, 21
//  Наименование товара	            Количество	    Цена ед. товара	    Стоимость
//  Зонтик автоматический	        50	            750.00	            37500.00
//  Портсигар импортный	            300	            1200.00	            360000.00
//  Приставка игровая	            2	            15600.00	        31200.00
//  Куртка замшевая	                12	            5100.00	            61200.00
//  Чайник фарфоровый	            15	            750.00	            11250.00
//  Кинокамера отечественная	    7	            3100.00	            21700.00
//  Телевизор цветной	            7	            25100.00 	        175700.00
//  Фотоаппарат цифровой	        2	            12000.00	        24000.00
//  Компьютер планшетный	        3	            15600.00	        46800.00
//  Кофейник фарфоровый	            15	            750.00	            11250.00
//  Итого	                        413		                            780600.00
// 
//  Требуется выполнение следующих обработок при помощи StreamAPI:
//  •	вывод коллекции в консоль с итогами по количеству и сумме товара (сумма товара вычисляется как по строке, 
//      так и по столбцу);
//  •	упорядочивание коллекции по убыванию стоимости товара;
//  •	упорядочивание коллекции по наименованию товара;
//  •	упорядочивание коллекции по возрастанию количества товара;
//  •	выполните количественный анализ: суммарное количество товара, минимальное, максимальное, 
//      среднее количество товара 


// Класс Магазин
public class Store implements Serializable {

    // имя файла данных
    public final String DATA_FILE_NAME = "app_data/goodsList.bin";

    // название
    public String name;

    // адрес
    public String address;

    // список товаров
    public List<Goods> goodsList;


    // конструктор по умолчанию
    public Store() throws Exception {
        goodsList = new ArrayList<>();
        if (!loadData()) {
            Store.factory();
            loadData();
        }
    }

    // конструктор инициализирующий
    public Store(String name, String address, List<Goods> goodsList) {
        this.name = name;
        this.address = address;
        this.goodsList = goodsList;

        // сохранение данных
        saveData(goodsList);
    }


    // фабричный метод
    public static Store factory() throws Exception {
        return new Store("Оптовый", "г. Донецк, ул. Циолковского, 21", new ArrayList<>(List.of(
                new Goods("Зонтик автоматический", 50, 750),
                new Goods("Портсигар импортный", 300, 1200),
                new Goods("Приставка игровая", 2, 15600),
                new Goods("Куртка замшевая", 12, 5100),
                new Goods("Чайник фарфоровый", 15, 750),
                new Goods("Кинокамера отечественная", 7, 3100),
                new Goods("Телевизор цветной", 7, 25100),
                new Goods("Фотоаппарат цифровой", 2, 12000),
                new Goods("Компьютер планшетный", 3, 15600),
                new Goods("Кофейник фарфоровый", 15, 750)
        )));
    }

    // вывод данных в виде таблицы
    public String toTable(List<Goods> data) {
        var sb = new StringBuilder();

        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='4'>").append("Перечень товаров на складе &laquo;").append(name).append("&raquo;, ").append(address).append("</th>")
                .append("</tr><tr>")
                .append("<th>Наименование товара</th>")
                .append("<th>Количество</th>")
                .append("<th>Цена ед.товара</th>")
                .append("<th>Стоимость</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        AtomicInteger i = new AtomicInteger(1);
        data.forEach(g -> sb.append(g.toTableRow(i.getAndIncrement())));

        sb.append("<tr>")
                .append("<td>Итого</td>")
                .append(String.format("<td align='right'>%d</td>", data.stream().mapToInt(Goods::amount).sum()))
                .append("<td>&nbsp;</td>")
                .append(String.format("<td align='right'>%.2f</td>", data.stream().mapToDouble(Goods::cost).sum()))
                .append("</tr>");

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // упорядочивание коллекции по убыванию стоимости товара
    public List<Goods> orderByCostDesc() {
        return goodsList
                .stream()
                .sorted(Comparator.comparingInt(Goods::cost).reversed())
                .toList();
    }

    // упорядочивание коллекции по наименованию товара
    public List<Goods> orderByName() {
        return goodsList
                .stream()
                .sorted(Comparator.comparing(Goods::name))
                .toList();
    }

    // упорядочивание коллекции по возрастанию количества товара
    public List<Goods> orderByAmount() {
        return goodsList
                .stream()
                .sorted(Comparator.comparingInt(Goods::amount))
                .toList();
    }

    // выполните количественный анализ: суммарное количество товара, минимальное, максимальное, 
    // среднее количество товара 
    public IntSummaryStatistics getStatistic() {
        return goodsList
                .stream()
                .collect(Collectors.summarizingInt(Goods::amount));
    }

    // вывод статистики в виде таблицы
    public String statisticToTable(IntSummaryStatistics statistic) {
        return new StringBuilder().append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>Количество товара</th>")
                .append("</tr><tr>")
                .append("<th>Сумма единиц</th>")
                .append("<th>Минимум</th>")
                .append("<th>Среднее</th>")
                .append("<th>Максимум</th>")
                .append("<th>Количество товаров</th>")
                .append("</tr>")
                .append("</thead><tbody>")
                .append("<td>").append(statistic.getSum()).append("</td>")
                .append("<td>").append(statistic.getMin()).append("</td>")
                .append("<td>").append(statistic.getAverage()).append("</td>")
                .append("<td>").append(statistic.getMax()).append("</td>")
                .append("<td>").append(statistic.getCount()).append("</td>")
                .append("</tbody></table>")
                .toString();
    }

    // сохранение данных в бинарном формате
    public void saveData(List<Goods> goodsList) {

        try (var stream = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))) {
            stream.writeObject(this);
//            for (Goods g : goodsList) {
//                stream.writeObject(g);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // загрузка данных из бинарного формата
    public boolean loadData() throws IOException {
        if (!Files.exists(Path.of(DATA_FILE_NAME)))
            return false;

        try (var stream = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME))) {

            var data = (Store)stream.readObject();
            this.name = data.name;
            this.address = data.address;
            this.goodsList = data.goodsList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
