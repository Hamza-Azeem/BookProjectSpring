package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.DTO.BookDto;
import com.example.BookProjectSpring.base.BaseService;
import com.example.BookProjectSpring.entity.Book;
import com.example.BookProjectSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<Book, Long> {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }
    public BookDto findBookById(long id){
        BookDto bookDto = new BookDto(findObjectById(id));
        return bookDto;
    }
    public Book findBookAndItsAuthor(long id){
        return bookRepository.findBookAndAuthor(id);
    }
    public int deleteAllBooksByAuthor(long id){
        return bookRepository.deleteBooksByAuthor(id);
    }
    @Override
    public Book updateObject(Book object) {
        Book book = findObjectById(object.getId());
        book.setTitle(object.getTitle());
        book.setPrice(object.getPrice());
        book.setStatusCode("updated");
        return super.updateObject(book);
    }
    public List<Book> findAllBooksByAuthor(long id){
        return bookRepository.findAllBooksByAuthor(id);
    }
}
