
package com.nfl.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "autores_id")
    )
    private List<Author> autores;

    @Column(columnDefinition = "text[]")
    private List<String> temas;

    @Column(columnDefinition = "text[]")
    private List<String> idioma;

    @Column(columnDefinition = "text[]")
    private List<String> categoria;

    public Book() {

    }

    public Book(String nombre, Integer fechaNacimiento, Integer fechaMuerte) {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Author> getAutores() {
        return autores;
    }

    public void setAutores(List<Author> autores) {
        this.autores = autores;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "*****Libro***** \n" +
                "Nombre: " + titulo + "\n" +
                "Autores: " + autores.stream()
                .map(author -> author.getNombre() + " (Nacimiento: " + author.getFechaNacimiento() + ", Muerte: " + author.getFechaMuerte() + ")")
                .collect(Collectors.joining(", ")) + "\n" +
                "Temas: " + String.join(", ", temas) + "\n" +
                "Idioma: " + String.join(", ", idioma) + "\n" +
                "Categoría: " +
                (categoria != null && !categoria.isEmpty() ?
                        categoria.stream()
                                .map(cat -> cat.startsWith("[") && cat.endsWith("]") ?
                                        cat.substring(1, cat.length() - 1) : cat)
                                .collect(Collectors.joining(", "))
                        : "N/A") +  
                "\n" +
                "***********";







    }
}
