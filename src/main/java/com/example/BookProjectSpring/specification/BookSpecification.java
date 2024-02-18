package com.example.BookProjectSpring.specification;

import com.example.BookProjectSpring.entity.Author;
import com.example.BookProjectSpring.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book> {
    private final BookSearch bookSearch;

    public BookSpecification(BookSearch bookSearch) {
        this.bookSearch = bookSearch;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Book, Author> join = root.join("author");
        if(bookSearch.getTitle() != null && !bookSearch.getTitle().isEmpty()){
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + bookSearch.getTitle() + "%"));
        }
        if(bookSearch.getPrice() != null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookSearch.getPrice()));
        }
        if(bookSearch.getAuthorName() != null && !bookSearch.getAuthorName().isEmpty()){
            predicates.add(criteriaBuilder.like(join.get("firstName"), "%" + bookSearch.getAuthorName() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
