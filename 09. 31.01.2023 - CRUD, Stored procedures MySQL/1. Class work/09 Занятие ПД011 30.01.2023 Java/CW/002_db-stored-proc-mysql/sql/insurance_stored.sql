use insurance;

delimiter ::

drop procedure if exists clientsCounter::

create procedure clientsCounter(out number int) 
begin

    -- into имяПеременной или параметр 
    select count(*) into number from clients;
end::

drop procedure if exists getClient::

-- выборка данных из таблицы при помощи открытого запроса
-- вернуть таблицу из процедуры нельзя
create procedure getClient(in id int)
begin
    select * from clients where clients.id = id;
end::


drop procedure if exists deleteClient::

create procedure deleteClient(in id int)
begin
    delete from
        clients
    where
        cliets.id = id;
end::

delimiter ;

-- ---------------------------------------------------
-- тестовые вызовы процедур
set @counter = 0;
call insurance.clientsCounter(@counter); 
select @counter as counter;

call insurance.getClient(5);