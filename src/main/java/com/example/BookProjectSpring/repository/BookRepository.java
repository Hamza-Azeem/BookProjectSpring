package com.example.BookProjectSpring.repository;

import com.example.BookProjectSpring.base.BaseRepository;
import com.example.BookProjectSpring.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends BaseRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll(Specification<Book> spec);

    @Query("SELECT book FROM Book book WHERE book.id=:id")
    @EntityGraph(attributePaths = {"author"})
    Book findBookAndAuthor(long id);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("DELETE FROM Book WHERE author.id = :id")
    int deleteBooksByAuthor(long id);
    @Query(value = "SELECT book FROM Book book WHERE book.author.id=:id")
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAllBooksByAuthor(long id);
}
