package com.example.BookProjectSpring.repository;

import com.example.BookProjectSpring.base.BaseRepository;
import com.example.BookProjectSpring.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author, Long> {
}
