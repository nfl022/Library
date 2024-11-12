package com.nfl.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;


public class ResultsData {
    @JsonProperty("count")  int total;
    @JsonProperty("next") String siguiente;
    @JsonProperty("previous")  String anterior;


    @JsonProperty("results")
    List<BookData> resultados;

    public String getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public List<BookData> getResultados() {
        return resultados;
    }

    public void setResultados(List<BookData> resultados) {
        this.resultados = resultados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "AuthorData{" +
                "Total resultados='" + total + '\'' +
                ", Anterios=" + anterior +
                ", Siguiente=" + siguiente +
                ": " + resultados +

                '}';
    }
}
