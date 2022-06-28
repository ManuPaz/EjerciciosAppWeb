package com.example.demorest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

//clean code: anadir lombok
@Getter
@Setter
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ModeloAPIEditar {
    @JsonProperty("ano")
    private Integer ano;
    @NotNull
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("ciudad")
    private String ciudad;
    @JsonProperty("pais")
    private String pais;
    @JsonProperty("codigoPais")
    private String codigoPais;
    @JsonProperty("valorPais")
    private Integer valorPais;
    @JsonProperty("idCiudad")
    private Integer idCiudad;
    @JsonProperty("nuevoAno")
    private Integer nuevoAno;
    @JsonProperty("nuevoTipo")
    private String nuevoTipo;

    public ModeloAPIEditar ano(Integer ano) {
        this.ano = ano;
        return this;
    }

    public ModeloAPIEditar tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ModeloAPIEditar ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ModeloAPIEditar pais(String pais) {
        this.pais = pais;
        return this;
    }

    public ModeloAPIEditar codigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
        return this;
    }

    public ModeloAPIEditar valorPais(Integer valorPais) {
        this.valorPais = valorPais;
        return this;
    }

    public ModeloAPIEditar idCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
        return this;
    }

    public ModeloAPIEditar nuevoAno(Integer nuevoAno) {
        this.nuevoAno = nuevoAno;
        return this;
    }

    public ModeloAPIEditar nuevoTipo(String nuevoTipo) {
        this.nuevoTipo = nuevoTipo;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModeloAPIEditar inlineObject1 = (ModeloAPIEditar) o;
        return Objects.equals(this.ano, inlineObject1.ano) &&
                Objects.equals(this.tipo, inlineObject1.tipo) &&
                Objects.equals(this.ciudad, inlineObject1.ciudad) &&
                Objects.equals(this.pais, inlineObject1.pais) &&
                Objects.equals(this.codigoPais, inlineObject1.codigoPais) &&
                Objects.equals(this.valorPais, inlineObject1.valorPais) &&
                Objects.equals(this.idCiudad, inlineObject1.idCiudad) &&
                Objects.equals(this.nuevoAno, inlineObject1.nuevoAno) &&
                Objects.equals(this.nuevoTipo, inlineObject1.nuevoTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, tipo, ciudad, pais, codigoPais, valorPais, idCiudad, nuevoAno, nuevoTipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineObject1 {\n");
        sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
        sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
        sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
        sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
        sb.append("    codigoPais: ").append(toIndentedString(codigoPais)).append("\n");
        sb.append("    valorPais: ").append(toIndentedString(valorPais)).append("\n");
        sb.append("    idCiudad: ").append(toIndentedString(idCiudad)).append("\n");
        sb.append("    nuevoAno: ").append(toIndentedString(nuevoAno)).append("\n");
        sb.append("    nuevoTipo: ").append(toIndentedString(nuevoTipo)).append("\n");
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

