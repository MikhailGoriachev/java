package org.homework.app.repositories;

import org.homework.app.entries.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientsRepository extends JpaRepository<Client, Long> {

}
