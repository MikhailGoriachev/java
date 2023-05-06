/* 
    Запрос 1.
    Выбирает информацию о товарах, единицей измерения которых является «шт» (штуки)
    и цена закупки составляет меньше 200 руб. Значения задавать параметрами
*/
select
    *
from
    purchases join products on purchases.product_id = products.id
              join units    on purchases.unit_id = units.id
where
    units.short = 'шт' and purchases.price < 200;

/* 
    Запрос 5
    Выполняет группировку по наименованию закупленного товара.
    Для каждого наименования вычисляет среднюю цену закупки
    товара, количество закупок
*/
select
    products.name
    , avg(purchases.price) as averagePrice
    , count(purchases.price) as amount
from
    purchases join products on purchases.product_id = products.id
group by
    products.name;    
        
/*
Запрос 6.
Для всех продавцов вывести сумму и количество продаж, минимальную 
и максимальную стоимости продаж 
*/
select 
    persons.surname                              as surname
    , persons.`name`                             as name
    , persons.patronymic                         as patronymic
    , persons.passport                           as passport
    , ifnull(sum(sales.price * sales.amount), 0) as totalSale
    , count(sales.id)                            as salesFact
    , ifnull(min(sales.price * sales.amount), 0) as minSale
    , ifnull(max(sales.price * sales.amount), 0) as maxSale
from 
    (sellers join persons on sellers.person_id = persons.id) left join sales on sellers.id = sales.seller_id
group by
    persons.surname, persons.name, persons.patronymic, persons.passport;    