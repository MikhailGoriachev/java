create schema if not exists tourist_agency_goriachev;

use tourist_agency_goriachev;

-- удаление таблиц
drop table if exists visits;
drop table if exists routes;
drop table if exists objectives;
drop table if exists countries;
drop table if exists clients;

-- клиенты
create table clients
(
    id         int         not null auto_increment primary key,
    surname    varchar(80) not null,
    name       varchar(80) not null,
    patronymic varchar(80) not null,
    passport   varchar(20) not null unique
);

-- страны
create table if not exists countries
(
    id           int         not null auto_increment primary key,
    name         varchar(80) not null,
    cost_service int         not null,
    cost_visa    int         not null
);

-- цели поездки
create table if not exists objectives
(
    id   int         not null auto_increment primary key,
    name varchar(80) not null unique
);

-- маршруты
create table if not exists routes
(
    id           int not null auto_increment primary key,
    country_id   int not null,
    objective_id int not null,
    daily_cost   int not null,

    constraint fk_routes_countries foreign key (country_id) references countries (id),
    constraint fk_routes_objectives foreign key (objective_id) references objectives (id)
);

-- поездки
create table if not exists visits
(
    id         int  not null auto_increment primary key,
    client_id  int  not null,
    route_id   int  not null,
    date_start date not null,
    duration   int  not null,

    constraint fk_visits_clients foreign key (client_id) references clients (id),
    constraint fk_visits_routes foreign key (route_id) references routes (id)
);