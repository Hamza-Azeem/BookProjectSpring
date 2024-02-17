package com.example.BookProjectSpring.controller;

import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable("id") long id){
        return authorService.findObjectById(id);
    }
    @GetMapping("")
    public List<Author> findAllAuthors(){
        return authorService.findAllObjects();
    }
    @PostMapping("")
    public Author insertAuthor(@RequestBody @Valid Author author){
        return authorService.insertObejct(author);
    }
    @PutMapping("")
    public Author updateAuthor(@RequestBody @Valid Author author){
        return authorService.updateObject(author);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        authorService.deleteObject(id);
    }
}
