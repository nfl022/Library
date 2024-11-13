

package com.nfl.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorData(
        @JsonIgnoreProperties(ignoreUnknown = true)

        @JsonProperty ("name") String nombre,

        @JsonProperty("birth_year") Integer fechaNacimiento,

        @JsonProperty("death_year") Integer fechaMuerte) {

        @Override
        public String nombre() {
                return nombre;
        }

        @Override
        public Integer fechaNacimiento() {
                return fechaNacimiento;
        }

        @Override
        public Integer fechaMuerte() {
                return fechaMuerte;
        }
}
