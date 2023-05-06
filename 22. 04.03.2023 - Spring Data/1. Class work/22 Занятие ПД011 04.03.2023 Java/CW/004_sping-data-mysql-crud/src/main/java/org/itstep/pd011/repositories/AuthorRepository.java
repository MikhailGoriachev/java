package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findFirstByName(String name);
}
