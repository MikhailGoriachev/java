package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Author;
import org.itstep.pd011.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(Author author);

    @Query(value="select * from books where price between ?1 and ?2", nativeQuery = true)
    List<Book> findBooksBy(int fromPrice, int toPrice);
}
