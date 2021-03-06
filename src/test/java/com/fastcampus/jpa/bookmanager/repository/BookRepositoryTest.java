package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("jpa 초격자");
        book.setAuthor("패스트 캠퍼스");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

}