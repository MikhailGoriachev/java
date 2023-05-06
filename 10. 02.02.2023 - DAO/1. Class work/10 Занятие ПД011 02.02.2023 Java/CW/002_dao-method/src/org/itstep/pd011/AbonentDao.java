package org.itstep.pd011;
import java.util.List;

// DAO уровня метода - специфическое для сущности действие,
// которое нет смысла выносить на верхний уровень
// !!! м.б. несколько методов !!!
public interface AbonentDao extends BaseDao <Long, Abonent> {
    // поиск абонентов по фамилии - специфичный для этого DAO запрос
    // для BaseDao слишком частный
    List<Abonent> findAbonentByLastname(String patternName) throws DaoException;
} // AbonentDao
