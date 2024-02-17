package com.example.BookProjectSpring.entity;

import com.example.BookProjectSpring.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Invalid title")
    private String title;
    @Min(value = 5, message = "Price must be greater than or equal to 5")
    @Max(value = 5000,  message = "Price must be less than or equal to 5000")
    private Double price;
    @Transient
    private Double discount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @NotNull
    private Author author;
    public Book(){};

    public Book(Long id, String title, double price, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    @PostLoad
    private void calculateDiscount(){
        this.setDiscount(price * .25);
    }

}