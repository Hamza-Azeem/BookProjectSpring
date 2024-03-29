package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.DTO.BookDto;
import com.example.BookProjectSpring.base.BaseService;
import com.example.BookProjectSpring.entity.Book;
import com.example.BookProjectSpring.exception.RecordNotFoundException;
import com.example.BookProjectSpring.repository.BookRepository;
import com.example.BookProjectSpring.specification.BookSearch;
import com.example.BookProjectSpring.specification.BookSpecification;
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
        try{
            Book book = findObjectById(object.getId());
            book.setTitle(object.getTitle());
            book.setPrice(object.getPrice());
            book.setStatusCode("updated");
            return super.updateObject(book);
        }catch (Exception e){
            throw new RecordNotFoundException("There is no record with id=" + object.getId()+ " in our database.");
        }

    }
    public List<Book> findAllBooksByAuthor(long id){
        return bookRepository.findAllBooksByAuthor(id);
    }
    public List<Book> searchBookBySpecification(BookSearch search){
        BookSpecification specification = new BookSpecification(search);
        return bookRepository.findAll(specification);
    }
}
