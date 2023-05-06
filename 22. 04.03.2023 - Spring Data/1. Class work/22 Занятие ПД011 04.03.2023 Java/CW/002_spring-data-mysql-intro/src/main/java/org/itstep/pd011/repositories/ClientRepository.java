package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAll();

    List<Client> findAllByDiscountLessThan(double from);

    /*
    int deleteClientByDiscountGreaterThan(double value);

    @Query(value="delete from clients where surname like '%?1%'", nativeQuery = true)
    int deleteClientBySurnameContains(String value);
    */



}
