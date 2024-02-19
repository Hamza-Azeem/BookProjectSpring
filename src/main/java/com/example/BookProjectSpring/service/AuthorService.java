package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.base.BaseService;
import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthorService extends BaseService<Author, Long> {
    @Override
    public Author updateObject(Author author) {
        try{
            Author auth = findObjectById(author.getId());
            auth.setFirstName(author.getFirstName());
            auth.setLastName(author.getLastName());
            auth.setStatusCode("updated");
            return super.updateObject(auth);
        }catch (Exception e){
            throw new RecordNotFoundException("There is no record with id=" + author.getId()+ " in our database.");
        }
    }
}
