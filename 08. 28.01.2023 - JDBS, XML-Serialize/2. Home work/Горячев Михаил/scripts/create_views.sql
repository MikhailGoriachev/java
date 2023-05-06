-- удаление представлений
drop view if exists view_appointments;
drop view if exists view_doctors;
drop view if exists view_patients;

-- представление таблицы doctors			(ВРАЧИ)

-- удаление представления 
-- drop view if exists view_doctors;
-- 

-- создание представления
create view view_doctors
as
select doctors.id
     , persons.surname    as doctor_surname    -- Фамилия врача
     , persons.[name]     as doctor_name       -- Имя врача
     , persons.patronymic as doctor_patronymic -- Отчество врача
     , specialities.name  as speciality_name   -- Специальность
     , doctors.price                           -- Цена приёма
     , doctors.[percent]                       -- Процент от цены приёма врачу
from doctors
         inner join persons on doctors.id_person = persons.id
         inner join specialities on doctors.id_speciality = specialities.id;



-- представление таблицы patients			(ПАЦИЕНТЫ)

-- удаление представления 
-- drop view if exists view_patients;
-- 

-- создание представления
create view view_patients
as
select patients.id
     , persons.surname    as patient_surname    -- Фамилия пациента
     , persons.[name]     as patient_name       -- Имя пациента
     , persons.patronymic as patient_patronymic -- Отчество пациента
     , patients.born_date                       -- Дата рождения пациента
     , patients.[address]                       -- Адрес проживания пациента
     , patients.passport                        -- Паспортные данные
from patients
         inner join persons on patients.id_person = persons.id;


-- представление таблицы appointments		(ПРИЕМЫ)

-- удаление представления 
-- drop view if exists view_appointments;
-- 

-- создание представления
create view view_appointments
as
select appointments.id
     , appointments.appointment_date           -- Дата приёма
     , Doc.surname       as doctor_surname     -- Фамилия врача
     , Doc.[name]        as doctor_name        -- Имя врача
     , Doc.patronymic    as doctor_patronymic  -- Отчество врача
     , specialities.name as speciality_name    -- Специальность
     , doctors.price                           -- Цена приёма
     , doctors.[percent]                       -- Процент от цены приёма врачу
     , pat.surname       as patient_surname    -- Фамилия пациента
     , pat.[name]        as patient_name       -- Имя пациента
     , pat.patronymic    as patient_patronymic -- Отчество пациента
     , patients.born_date                      -- Дата рождения пациента
     , patients.[address]                      -- Адрес проживания пациента
     , patients.passport                       -- Паспортные данные
from appointments
         inner join (doctors inner join persons doc on doctors.id_person = doc.id
    inner join specialities on doctors.id_speciality = specialities.id)
                    on appointments.id_doctor = doctors.id
         inner join (patients inner join persons pat on patients.id_person = pat.id)
                    on appointments.id_patient = patients.id
