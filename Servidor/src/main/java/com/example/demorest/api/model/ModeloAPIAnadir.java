package com.example.demorest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

//clean code: anadir lombok
@Getter
@Setter
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-15T18:36:55.532623100+01:00[Europe/Madrid]")
public class ModeloAPIAnadir {
    @JsonProperty("ano")
    private Integer ano;
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
    @JsonProperty("valorCiudad")
    private Integer valorCiudad;

    public ModeloAPIAnadir ano(Integer ano) {
        this.ano = ano;
        return this;
    }

    public ModeloAPIAnadir tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ModeloAPIAnadir ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ModeloAPIAnadir pais(String pais) {
        this.pais = pais;
        return this;
    }

    public ModeloAPIAnadir codigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
        return this;
    }

    public ModeloAPIAnadir valorCiudad(Integer valorCiudad) {
        this.valorCiudad = valorCiudad;
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
        ModeloAPIAnadir inlineObject = (ModeloAPIAnadir) o;
        return Objects.equals(this.ano, inlineObject.ano) && Objects.equals(this.tipo, inlineObject.tipo) && Objects.equals(this.ciudad, inlineObject.ciudad) && Objects.equals(this.pais, inlineObject.pais) && Objects.equals(this.codigoPais, inlineObject.codigoPais) && Objects.equals(this.valorPais, inlineObject.valorPais) && Objects.equals(this.valorCiudad, inlineObject.valorCiudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, tipo, ciudad, pais, codigoPais, valorPais, valorCiudad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineObject {\n");
        sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
        sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
        sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
        sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
        sb.append("    codigoPais: ").append(toIndentedString(codigoPais)).append("\n");
        sb.append("    valorPais: ").append(toIndentedString(valorPais)).append("\n");
        sb.append("    valorCiudad: ").append(toIndentedString(valorCiudad)).append("\n");
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

