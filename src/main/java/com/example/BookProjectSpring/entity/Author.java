package com.example.BookProjectSpring.entity;


import com.example.BookProjectSpring.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
    @Formula(value = "(SELECT COUNT(*) FROM books book WHERE book.author_id=id)")
    private long bookCount;
    public Author(){};

    public Author(Long id, String firstName, String lastName, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Author(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
        books.add(book);
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }
}