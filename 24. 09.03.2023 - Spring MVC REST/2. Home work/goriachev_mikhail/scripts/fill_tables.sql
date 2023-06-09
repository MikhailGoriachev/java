﻿use tourist_agency_goriachev;

-- очистка таблиц
delete from visits;
delete from routes;
delete from objectives;
delete from countries;
delete from clients;

-- заполнение таблицы visits
insert into clients (surname, name, patronymic, passport)
values ('Иванов', 'Владимир', 'Александрович', '1234 567890'),
       ('Петров', 'Валерий', 'Витальевич', '2345 678901'),
       ('Сидоров', 'Александр', 'Сергеевич', '3456 789012'),
       ('Козлов', 'Андрей', 'Александрович', '4567 890123'),
       ('Смирнова', 'Елена', 'Дмитриевна', '5678 901234'),
       ('Федорова', 'Ольга', 'Андреевна', '6789 012345'),
       ('Попов', 'Михаил', 'Сергеевич', '7890 123456'),
       ('Александрова', 'Надежда', 'Павловна', '8901 234567'),
       ('Кузнецова', 'Екатерина', 'Ивановна', '9012 345678'),
       ('Николаева', 'Татьяна', 'Алексеевна', '0123 456789'),
       ('Михайлов', 'Владимир', 'Геннадьевич', '0987 654321'),
       ('Гаврилов', 'Анатолий', 'Сергеевич', '9876 543210'),
       ('Полякова', 'Ирина', 'Владимировна', '8765 432109'),
       ('Калинина', 'Оксана', 'Сергеевна', '7654 321098'),
       ('Антонов', 'Дмитрий', 'Андреевич', '6543 210987'),
       ('Лебедева', 'Марина', 'Ивановна', '5432 109876'),
       ('Савельев', 'Виктор', 'Александрович', '4321 098765'),
       ('Борисов', 'Георгий', 'Петрович', '3210 987654'),
       ('Королева', 'Анастасия', 'Сергеевна', '2109 876543'),
       ('Тихонов', 'Василий', 'Дмитриевич', '1098 765432');

-- заполнение таблицы countries
insert into countries (name, cost_service, cost_visa)
values ('Франция', 500, 2000),
       ('Испания', 600, 2500),
       ('Италия', 550, 2200),
       ('Греция', 450, 1800),
       ('Хорватия', 400, 1600),
       ('Турция', 400, 1700),
       ('Таиланд', 800, 3000),
       ('Египет', 350, 1500),
       ('ОАЭ', 1000, 3500),
       ('США', 1200, 4000),
       ('Канада', 1000, 3500),
       ('Япония', 1500, 5000),
       ('Китай', 700, 2800),
       ('Австралия', 1300, 4500),
       ('Новая Зеландия', 1200, 4200);

-- заполнение таблицы objectives
insert into objectives (name)
values ('Путешествие'),
       ('Отдых'),
       ('Изучение языка'),
       ('Знакомство с культурой'),
       ('Посещение достопримечательностей'),
       ('Покупки'),
       ('Спорт'),
       ('Релаксация'),
       ('Активный отдых'),
       ('События и фестивали');

-- заполнение таблицы routes
insert into routes(country_id, objective_id, daily_cost)
values (5, 1, 2000),
       (2, 10, 1000),
       (8, 4, 1400),
       (3, 1, 3200),
       (12, 4, 2000),
       (1, 7, 4600),
       (9, 3, 2100),
       (4, 8, 1800),
       (7, 1, 2900),
       (14, 10, 3200),
       (6, 5, 4300),
       (10, 9, 1500),
       (1, 4, 2000),
       (13, 2, 2800),
       (11, 1, 3600),
       (3, 5, 4400),
       (15, 5, 5000),
       (9, 2, 3400),
       (7, 2, 1700),
       (2, 6, 2900);

-- заполнение таблицы visits
insert into visits (client_id, route_id, date_start, duration)
values (10, 5, '2023-03-11', 7),
       (3, 17, '2023-01-15', 8),
       (8, 10, '2023-02-09', 2),
       (17, 7, '2023-02-25', 10),
       (1, 6, '2023-02-08', 14),
       (16, 1, '2023-02-20', 6),
       (13, 19, '2023-02-17', 3),
       (6, 9, '2023-01-16', 3),
       (2, 13, '2023-02-04', 10),
       (12, 15, '2023-03-10', 14),
       (18, 7, '2023-02-14', 6),
       (19, 10, '2023-03-09', 4),
       (4, 2, '2023-01-29', 5),
       (7, 8, '2023-03-05', 1),
       (20, 3, '2023-02-23', 6),
       (15, 1, '2023-02-11', 5),
       (11, 16, '2023-01-09', 4),
       (5, 2, '2023-01-22', 13),
       (14, 14, '2023-02-22', 3),
       (9, 9, '2023-03-02', 3);