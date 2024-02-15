package com.example.BookProjectSpring.repository;

import com.example.BookProjectSpring.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();
    @Query("SELECT book FROM Book book WHERE book.id=:id")
    @EntityGraph(attributePaths = {"author"})
    Book findBookAndAuthor(long id);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("DELETE FROM Book WHERE author.id = :id")
    int deleteBooksByAuthor(long id);
}
