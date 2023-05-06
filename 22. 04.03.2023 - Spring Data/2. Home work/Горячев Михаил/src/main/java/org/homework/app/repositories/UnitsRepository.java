package org.homework.app.repositories;

import org.homework.app.entries.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitsRepository extends JpaRepository<Unit, Long> {
}
