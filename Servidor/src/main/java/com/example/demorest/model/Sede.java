package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Sede
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-14T09:36:03.661556900+01:00[Europe/Madrid]")

public class Sede {
    @JsonProperty("descripcion_tipo")
    private String descripcionTipo;

    @JsonProperty("ano")
    private Integer ano;

    public Sede descripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
        return this;
    }

    /**
     * Get descripcionTipo
     *
     * @return descripcionTipo
     */
    @ApiModelProperty(value = "")


    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public Sede ano(Integer ano) {
        this.ano = ano;
        return this;
    }

    /**
     * Get ano
     *
     * @return ano
     */
    @ApiModelProperty(value = "")


    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Sede(String descripcion_tipo_jjoo, Integer año) {

        this.descripcionTipo = descripcion_tipo_jjoo;

        this.ano = año;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sede sede = (Sede) o;
        return Objects.equals(this.descripcionTipo, sede.descripcionTipo) &&
                Objects.equals(this.ano, sede.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcionTipo, ano);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Sede {\n");

        sb.append("    descripcionTipo: ").append(toIndentedString(descripcionTipo)).append("\n");
        sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

