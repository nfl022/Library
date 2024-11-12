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
    private List<Author> autores;

    @Column
    private List<String> temas;

    @Column
    private List<String> idioma;

    @Column
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
        return "***Libro***** \n" +
                "Nombre: " + titulo + "\n" +
                "Autores: " + autores.stream()
                .map(author -> author.getNombre() + " (Nacimiento: " + author.getFechaNacimiento() + ", Muerte: " + author.getFechaMuerte() + ")")
                .collect(Collectors.joining(", ")) + "\n" +
                "Temas: " + String.join(", ", temas) + "\n" +
                "Idioma: " + String.join(", ", idioma) + "\n" +
                "Categoría: " + categoria.stream()
                .filter(cat -> !cat.startsWith("Browsing"))
                .map(cat -> cat.replace("FR ", ""))
                .collect(Collectors.joining(", ")) + "\n" +
                "***********";





    }
}
