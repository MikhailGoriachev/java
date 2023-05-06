package org.itstep.pd011;

import org.itstep.pd011.entities.Author;
import org.itstep.pd011.entities.Book;
import org.itstep.pd011.entities.Category;
import org.itstep.pd011.repositories.AuthorRepository;
import org.itstep.pd011.repositories.BookRepository;
import org.itstep.pd011.repositories.CategoryRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Реализация CRUD-операций !");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookRepository bookRepository = context.getBean(BookRepository.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);

        // выводим данные из таблицы books
        System.out.println("\n\n\tДанные из таблицы \033[1mbooks\033[0m");
        List<Book> bookList = bookRepository.findAll();
        bookList.forEach(System.out::println);

        // (C)RUD Добавление записей в таблицы authors, books
        Category category = categoryRepository.findFirstByCategory("учебник");

        // поиск и добавление автора - при необходимости
        String authorName = "Монахов В.В.";
        Author author =  authorRepository.findFirstByName(authorName);
        if (author == null)
            author = authorRepository.saveAndFlush(new Author("Монахов В.В."));

        // собственно добавление записи в таблицу books
        Book book = new Book();
        book.setId(null);
        book.setTitle("Язык программирования Java и среда NetBeans");
        book.setAuthor(author);
        book.setCategory(category);
        book.setAmount(2);
        book.setYear(2011);
        book.setPrice(300);
        book = bookRepository.saveAndFlush(book);
        // book = bookRepository.save(book);

        System.out.println("\n\n\tВ таблицу \033[1mbooks\033[0m добавлена запись");
        System.out.println(book);
        System.out.println();

        // читаем данные с добавленной записью
        bookList = bookRepository.findAll();
        bookList.forEach(System.out::println);

        // получаем максимальный id
        long id = bookList.stream()
                .max(Comparator.comparingLong(Book::getId))
                .get()
                .getId();

        // CR(U)D Изменить запись в таблице books
        System.out.println("\n\tИзменение записи с id = " + id);
        book = bookRepository.findById(id).get();
        int amount = book.getAmount()-1;
        book.setAmount(amount);
        bookRepository.save(book);
        System.out.println(bookRepository.findById(id).get());

        // CRU(D) Удалить запись из таблицы books
        System.out.printf("\n\tУдаленение записи с id = %d", id);
        bookRepository.deleteById(id);

        // Выводим данные из таблицы books
        System.out.println("\n\n\tДанные из таблицы \033[1mbooks\033[0m");
        bookRepository.findAll().forEach(System.out::println);
    }
}
