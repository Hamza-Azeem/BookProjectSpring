package com.example.BookProjectSpring.service;

import com.example.BookProjectSpring.base.BaseService;
import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService extends BaseService<Author, Long> {
    @Override
    public Author updateObject(Author author) {
        Author auth = findObjectById(author.getId());
        auth.setFirstName(author.getFirstName());
        auth.setLastName(author.getLastName());
        auth.setStatusCode("updated");
        return super.updateObject(auth);
    }
}
