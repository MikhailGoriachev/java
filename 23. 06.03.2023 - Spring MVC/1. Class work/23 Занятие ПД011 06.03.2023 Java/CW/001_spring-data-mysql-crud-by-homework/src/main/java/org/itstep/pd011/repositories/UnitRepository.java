package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

// запросы к таблице units
public interface UnitRepository extends JpaRepository<Unit, Integer> {

    // получить эапись по краткому наименованию единицы измерения
    Unit findByShortName(String shortName);

} // interface UnitRepository
