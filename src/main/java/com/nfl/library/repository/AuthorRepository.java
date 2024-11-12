package com.nfl.library.repository;

import com.nfl.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> findByAllWithBooks();

}
