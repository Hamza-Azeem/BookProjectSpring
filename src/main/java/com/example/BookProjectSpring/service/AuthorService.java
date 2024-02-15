package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author findAuthorById(long id){
        return authorRepository.findById(id).get();
    }
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
    public Author insertAuthor(Author author){

        return authorRepository.save(author);
    }
    public Author updateAuthor(Author author){
        return authorRepository.save(author);
    }
    public void deleteAuthor(long id){
        authorRepository.deleteById(id);
    }
}
