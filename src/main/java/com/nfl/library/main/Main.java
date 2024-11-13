
package com.nfl.library.main;

import com.nfl.library.model.Author;
import com.nfl.library.model.Book;
import com.nfl.library.model.BookData;
import com.nfl.library.model.ResultsData;
import com.nfl.library.repository.AuthorRepository;
import com.nfl.library.repository.BookRepository;
import com.nfl.library.service.ConsumeAPI;
import com.nfl.library.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConsumeAPI consumoAPI = new ConsumeAPI();
    private ConvertData convertData = new ConvertData();
    private List<Book> books = new ArrayList<>();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private final String URL_FINAL = "&sort=ascending";
    private  final BookRepository repository;
    private final AuthorRepository authorRepository;
    private List<Book> libros;
    List <Book> libroBuscado;
    List<Author> autorBuscado;


    public Main(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            var menu = """
                    1- Buscar libros
                    2- Buscar libro por titulo
                    3 - Mostrar libros buscados
                    4 - Mostrar autores buscados
                    5 - Buscar por autores vivos en cierto periodo
                    6 - Buscar por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            option = teclado.nextInt();
            teclado.nextLine();

            switch (option) {
                case 1 -> searchBooks();
                case 2 -> searchBookByTitle();
                case 3 -> showSearchedBooks();
                case 4 -> showSearchedAuthors();
                case 5 -> searchAliveAuthorsByDate();
                case 6 -> searchByLanguage();
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void searchBooks() {

        System.out.println("Escribe el nombre del libro");
        var nombreLibro = teclado.nextLine();


        ConsumeAPI consumoAPI = new ConsumeAPI();
        var json = consumoAPI.getData(URL_BASE + nombreLibro.replace(" ", "%20") + URL_FINAL);
        System.out.println(json);

        ConvertData convertData = new ConvertData();
        var data = convertData.obtainData(json, ResultsData.class);
        System.out.println(data);


        for (BookData bookData : data.getResultados()) {

            Book book = new Book();
            book.setTitulo(bookData.titulo());
            book.setId(bookData.id());
            book.setTemas(bookData.temas());
            book.setIdioma(bookData.idioma());
            book.setCategoria(bookData.categoria());


            List<Author> authors = bookData.autor().stream()
                    .map(a -> {
                        Author author = new Author(a.nombre(), a.fechaNacimiento(), a.fechaMuerte());
                        author.getBooks().add(book);  // Add book to author's books list
                        return author;
                    })
                    .collect(Collectors.toList());

            book.setAutores(authors);

            Optional<Book> existingBook = repository.findById(book.getId());

            if (existingBook.isEmpty()) {
                repository.save(book);

                System.out.println(book);
            } else {
                System.out.println("El libro ya está guardado: " + book.getTitulo());
            }


        }

    }

    private void searchBookByTitle() {
        System.out.println("Escriba el nombre del libro");
        var nombreLibro = teclado.nextLine();
        libroBuscado = repository.findByTituloContainingIgnoreCase(nombreLibro);
        if(libroBuscado.isEmpty()){
            System.out.println("Libro no encontrado");
        } else {
            System.out.println("Quisiste decir");
            libroBuscado.forEach(System.out::println);
        }

    }



    private void showSearchedBooks() {
        List<Book> libros = repository.findAllWithAuthors();
        libros.forEach(System.out::println);

    }

    private void showSearchedAuthors() {
        List<Author> authors = authorRepository.findByAllWithBooks();
        if (authors.isEmpty()) {
            System.out.println("Ningun autor encontrado.");
        } else {

            authors.forEach(author -> System.out.println(author.toString()));
        }
    }


    private void searchAliveAuthorsByDate() {
        System.out.println("Por que fecha desea buscar?");
        var fechaAutor = teclado.nextInt();
        List<Book> fechaEncontrada = repository.autorPorFecha(fechaAutor);
        if(fechaEncontrada.isEmpty()){
            System.out.println(" Ningun autor encontrado con esa fecha");

        } else {
            System.out.println("Autores ecnontrados: " + fechaAutor + ": " );
            fechaEncontrada.forEach(System.out::println);
        }

    }
    private void searchByLanguage() {
        System.out.println("En que idioma desea buscar? ");
        var lenguajeLibro = teclado.nextLine();
        List<Book> lenguajeEncontrado = repository.libroPorIdioma(lenguajeLibro);
        if(lenguajeEncontrado.isEmpty()){
            System.out.println(" Ningun libro encontrado en: " + lenguajeLibro);

        } else {
            System.out.println("Libros encontrados: " + lenguajeLibro + ": " );
            lenguajeEncontrado.forEach(System.out::println);
        }



    }



}
