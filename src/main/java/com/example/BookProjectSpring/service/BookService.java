package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.DTO.BookDto;
import com.example.BookProjectSpring.entity.Book;
import com.example.BookProjectSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookDto findBookById(long id){
        BookDto bookDto = new BookDto(bookRepository.findById(id).get());
        return bookDto;
    }
    public Book findBookAndItsAuthor(long id){
        return bookRepository.findBookAndAuthor(id);
    }
    public int deleteAllBooksByAuthor(long id){
        return bookRepository.deleteBooksByAuthor(id);
    }
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    public Book insertBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
}
