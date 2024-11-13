
package com.nfl.library.repository;

import com.nfl.library.model.Author;
import com.nfl.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN b.autores a WHERE a.nombre IN :authorNames")
    List<Book> findByAuthorNames( List<String> authorNames);

    List<Book> findByTituloContainingIgnoreCase(String nombreLibro);

    @Query("SELECT b FROM Book b JOIN b.autores a WHERE a.nombre ILIKE %:nombreAutor%")
    List<Book>librosPorAutor (String nombreAutor);

    @Query("SELECT b from Book b JOIN b.autores a WHERE a.fechaMuerte <= %:fechaAutor%")
    List<Book> autorPorFecha( Integer fechaAutor);

    @Query(value = "SELECT * FROM Libros b WHERE LOWER(:lenguajeLibro) = ANY(SELECT unnest(b.idioma))", nativeQuery = true)
    List<Book> libroPorIdioma(String lenguajeLibro);




}
