package com.example.BookProjectSpring.controller;

import com.example.BookProjectSpring.entity.Book;
import com.example.BookProjectSpring.service.BookService;
import com.example.BookProjectSpring.specification.BookSearch;
import com.example.BookProjectSpring.specification.BookSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<?> findBookAndAuthor(@PathVariable("id") long id){
        return new ResponseEntity<>(bookService.findBookAndItsAuthor(id), HttpStatus.OK);
    }
    @GetMapping()
    public List<Book> findAllBooks(){
        return bookService.findAllObjects();
    }
    @PostMapping("")
    public Book insertBook(@RequestBody @Valid Book book){
        return bookService.insertObejct(book);
    }
    @PutMapping("")
    public Book updateBook(@RequestBody @Valid Book book){
        return bookService.updateObject(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") long id){
        bookService.deleteObject(id);
    }
    @DeleteMapping("/author/{id}")
    public int deleteAllBooksByAuthor(@PathVariable long id){
        return bookService.deleteAllBooksByAuthor(id);
    }
    @GetMapping("/author/all/{id}")
    public ResponseEntity<?> findAllBooksByAuthor(@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.findAllBooksByAuthor(id));
    }
    @PostMapping("/search")
    public List<Book> bookSearch(@RequestBody BookSearch bookSearch){
        return bookService.searchBookBySpecification(bookSearch);
    }
}
