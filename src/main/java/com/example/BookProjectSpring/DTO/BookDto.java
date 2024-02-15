package com.example.BookProjectSpring.DTO;

import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.entity.Book;
import jakarta.persistence.*;

public class BookDto {

    private Long id;
    private String title;
    private Double price;
    public BookDto(){};
    public BookDto(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
    }

    public BookDto(Long id, String title, double price, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
