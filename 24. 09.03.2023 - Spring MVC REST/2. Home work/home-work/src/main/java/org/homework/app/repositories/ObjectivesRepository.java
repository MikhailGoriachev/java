package org.homework.app.repositories;

import org.homework.app.entries.Objective;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ObjectivesRepository extends JpaRepository<Objective, Long> {
    
}
