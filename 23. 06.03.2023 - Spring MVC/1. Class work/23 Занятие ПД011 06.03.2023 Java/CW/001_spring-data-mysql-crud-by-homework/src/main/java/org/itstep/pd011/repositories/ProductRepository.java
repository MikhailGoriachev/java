package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// работа с таблицей - справочником товаров, сущность Product
public interface ProductRepository extends JpaRepository<Product, Integer>  {
} // interface ProductRepository
