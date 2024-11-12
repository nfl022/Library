package com.nfl.library.service;

import com.nfl.library.model.Author;
import com.nfl.library.model.Book;
import com.nfl.library.model.BookData;
import com.nfl.library.model.ResultsData;
import com.nfl.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBooksFromResultsData(ResultsData resultsData) {
        for (BookData bookData : resultsData.getResultados()) {
            Book book = new Book();
            book.setTitulo(bookData.titulo());
            book.setId(bookData.id());
            book.setTemas(bookData.temas());
            book.setIdioma(bookData.idioma());
            book.setCategoria(bookData.categoria());

            List<Author> authors = bookData.autor().stream()
                    .map(authorData -> new Author(authorData.nombre(), authorData.fechaNacimiento(), authorData.fechaMuerte()))
                    .collect(Collectors.toList());
            book.setAutores(authors);

            bookRepository.save(book);
        }
    }
}
