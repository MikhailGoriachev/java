package org.itstep.pd011;

import java.util.List;

// CRUD-операции с таблицей phones, для этой таблицы не требуется
// дополнительных запросов, следовательно, не нужен интерфейс PhoneDao
public class PhoneDao implements BaseDao <Long, Phone>  {
    @Override
    public boolean create(Phone phone) throws DaoException {
        return false;
    }

    @Override
    public List<Phone> findAll() throws DaoException {
        return null;
    }

    @Override
    public Phone findEntityById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Phone update(Phone phone) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Phone phone) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }
}
