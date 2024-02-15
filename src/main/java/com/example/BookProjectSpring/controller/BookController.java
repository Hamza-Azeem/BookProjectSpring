package com.example.BookProjectSpring.controller;

import com.example.BookProjectSpring.entity.Book;
import com.example.BookProjectSpring.service.BookService;
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
        return bookService.findAllBooks();
    }
    @PostMapping("")
    public Book insertBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }
    @PutMapping("")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") long id){
        bookService.deleteBook(id);
    }
    @DeleteMapping("/author/{id}")
    public int deleteAllBooksByAuthor(@PathVariable long id){
        return bookService.deleteAllBooksByAuthor(id);
    }
}
