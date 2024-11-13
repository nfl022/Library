
package com.nfl.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonProperty("title") String titulo,
        Integer id,
        @JsonProperty("authors") List<AuthorData> autor,
        @JsonProperty ("subjects") List<String> temas ,
        @JsonProperty("languages") List<String> idioma,
        @JsonProperty("bookshelves")List<String> categoria


){

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public List<AuthorData> autor() {
        return autor;
    }

    @Override
    public List<String> temas() {
        return temas;
    }

    @Override
    public List<String> idioma() {
        return idioma;
    }

    @Override
    public List<String> categoria() {
        return categoria;
    }
}
