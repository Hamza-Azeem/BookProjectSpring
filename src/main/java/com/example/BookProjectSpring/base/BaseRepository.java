package com.example.BookProjectSpring.base;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} t SET t.statusCode=:statusCode WHERE t.id=:id")
    public T updateStatusCode(String statusCode, ID id);

}
