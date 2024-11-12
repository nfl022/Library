
package com.nfl.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nombre;


    private Integer fechaNacimiento;


    private Integer fechaMuerte;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(String nombre, Integer fechaNacimiento, Integer fechaMuerte) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Book> getBooks() {
        return books;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    @Override
    public String toString() {
         return "******************" + "\n" +
                "Author: " + nombre + '\n' +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de Muerte: " + fechaMuerte + "\n" +
                "Libros: " + (books != null ? books.stream()
                .map(Book::getTitulo)
                .collect(Collectors.joining(", ")) : "N/A") + "\n" +
                "*******************";
    }


}

