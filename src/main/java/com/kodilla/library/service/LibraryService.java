package com.kodilla.library.service;

import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.*;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.LeaseRepository;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final TitleRepository titleRepository;
    private final LeaseRepository leaseRepository;
    private final UserRepository userRepository;

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }
    public void addLease(Lease lease) {
        leaseRepository.save(lease);
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Title findByTitle(String title) {
        return titleRepository.findByTitle(title).orElse(new Title());
    }

    public void addTitle(){
        Title title = Title.builder()
                .author("autor")
                .title("tytuł")
                .releaseDate(LocalDate.now())
                .build();
        System.out.println(title);
        titleRepository.save(title);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<List<Book>> findBookByTitle(String title){
        Optional<List<Title>> titles = titleRepository.findByTitleContaining(title);
        return bookRepository.findByTitle(titles.get().get(0));
    }

    public BookDto addBook0(final BookDto bookDto){
//        Title title = Title.builder()
//                .author("autor")
//                .title("tytuł")
//                .releaseDate(LocalDate.now())
//                .build();
//        System.out.println(title);

        Title title = this.findByTitle("tytuł");

        Book book = Book.builder()
                .status(BookStatus.STATUS_OK)
                .title(title)
                .build();

        bookRepository.save(book);
        return bookDto;
    }

    public BookDto addBook(final BookDto bookDto){
        //czy tytuł istnieje w bazie? dodaj ksiazke : dodaj tytul i ksiazke
        Title title;
        try {
            title = titleRepository.findByTitle(bookDto.getTitle()).orElseThrow(TitleNotFoundException::new);
        } catch (TitleNotFoundException e) {
            title = Optional.ofNullable(titleRepository.save(Title.builder()
                    .title(bookDto.getTitle())
                    .author(bookDto.getAuthor())
                    .releaseDate(bookDto.getReleaseDate())
                    .build())).orElseThrow();
        }

        Book book = Book.builder()
                .status(BookStatus.STATUS_OK)
                .title(title)
                .build();

        bookRepository.save(book);

        return bookDto;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

//    public Book getBookById(final Long id) throws BookNotFoundException{
//        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
//    }
//
//    public List<Book> getBookByTitle(String title) throws BookNotFoundException{
//        return bookRepository.findByTitleContaining(title).orElseThrow(BookNotFoundException::new);
//    }
//
//    public List<Book> getBookByAuthor(String author) throws BookNotFoundException{
//        return bookRepository.findByAuthorContaining(author).orElseThrow(BookNotFoundException::new);
//    }
//
//    public List<Book> getBookByTitleOrAuthor(String query) throws BookNotFoundException{
//        return bookRepository.findByTitleContainingOrAuthorContaining(query, query).orElseThrow(BookNotFoundException::new);
//    }
//
//    public Book saveBook(final Book book){
//        return bookRepository.save(book);
//    }
//
//    public void deleteBook(final Long id){
//        bookRepository.deleteById(id);
//    }

}
