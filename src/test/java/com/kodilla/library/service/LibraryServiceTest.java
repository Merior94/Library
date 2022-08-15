package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTest {

    @Autowired
    LibraryService libraryService;

    @Test
    void ShouldGetBooks(){
        libraryService.getAllTitles();
        //BookDto bookDto = new BookDto(1,"test", "autor", BookStatus.STATUS_OK, LocalDate.now());

        //libraryService.addBook(bookDto);
        //libraryService.getAllTitles();

    }

    @Test
    void addTitle(){
        libraryService.addTitle();
    }

    @Test
    void getAllTitles(){
        List<Title> titles = libraryService.getAllTitles();
        titles.forEach(System.out::println);
    }

    @Test
    void findByTitle(){
        Title title = libraryService.findByTitle("tytuł");
        System.out.println(title);
    }

    @Test
    void addBook(){
        BookDto bookDto = new BookDto(0,"tytuł", "autor", BookStatus.STATUS_OK, LocalDate.now());
        System.out.println(libraryService.addBook(bookDto));
    }

    @Test
    void getAllBooks(){
        List<Book> books = libraryService.getAllBooks();
        books.forEach(System.out::println);
    }

    @Test
    void getAllUsers(){
        List<User> users = libraryService.findAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    void addUser(){
        User user = User.builder()
                .firstName("first")
                .lastName("lastname")
                .email("first@last.com")
                .build();

        libraryService.addUser(user);
        List<User> users = libraryService.findAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    void findBookByTitle(){
        Optional<List<Book>> books = libraryService.findBookByTitle("tytuł");
        //System.out.println(book);
        books.get().forEach(System.out::println);
    }

    @Test
    void getAllLeases(){
        List<Lease> leases = libraryService.getAllLeases();
        leases.forEach(System.out::println);
    }

    @Test
    void addLease(){
        Lease lease = Lease.builder()
                .book(libraryService.findBookByTitle("tytuł").get().get(0))
                .user(libraryService.findAllUsers().get(0))
                .build();
        System.out.println(lease);

        libraryService.addLease(lease);
        List<Lease> leases = libraryService.getAllLeases();
        leases.forEach(System.out::println);
    }
}