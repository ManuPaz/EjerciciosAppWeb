package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * InlineObject1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-15T18:36:55.532623100+01:00[Europe/Madrid]")

public class InlineObject1 {
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

    @JsonProperty("idCiudad")
    private Integer idCiudad;

    @JsonProperty("nuevoAno")
    private Integer nuevoAno;

    @JsonProperty("nuevoTipo")
    private String nuevoTipo;

    public InlineObject1 ano(Integer ano) {
        this.ano = ano;
        return this;
    }

    /**
     * Get ano
     *
     * @return ano
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public InlineObject1 tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    /**
     * Get tipo
     *
     * @return tipo
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public InlineObject1 ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    /**
     * Get ciudad
     *
     * @return ciudad
     */
    @ApiModelProperty(value = "")


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public InlineObject1 pais(String pais) {
        this.pais = pais;
        return this;
    }

    /**
     * Get pais
     *
     * @return pais
     */
    @ApiModelProperty(value = "")


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public InlineObject1 codigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
        return this;
    }

    /**
     * Get codigoPais
     *
     * @return codigoPais
     */
    @ApiModelProperty(value = "")


    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public InlineObject1 valorPais(Integer valorPais) {
        this.valorPais = valorPais;
        return this;
    }

    /**
     * Get valorPais
     *
     * @return valorPais
     */
    @ApiModelProperty(value = "")


    public Integer getValorPais() {
        return valorPais;
    }

    public void setValorPais(Integer valorPais) {
        this.valorPais = valorPais;
    }

    public InlineObject1 idCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
        return this;
    }

    /**
     * Get idCiudad
     *
     * @return idCiudad
     */
    @ApiModelProperty(value = "")


    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public InlineObject1 nuevoAno(Integer nuevoAno) {
        this.nuevoAno = nuevoAno;
        return this;
    }

    /**
     * Get nuevoAno
     *
     * @return nuevoAno
     */
    @ApiModelProperty(value = "")


    public Integer getNuevoAno() {
        return nuevoAno;
    }

    public void setNuevoAno(Integer nuevoAno) {
        this.nuevoAno = nuevoAno;
    }

    public InlineObject1 nuevoTipo(String nuevoTipo) {
        this.nuevoTipo = nuevoTipo;
        return this;
    }

    /**
     * Get nuevoTipo
     *
     * @return nuevoTipo
     */
    @ApiModelProperty(value = "")


    public String getNuevoTipo() {
        return nuevoTipo;
    }

    public void setNuevoTipo(String nuevoTipo) {
        this.nuevoTipo = nuevoTipo;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineObject1 inlineObject1 = (InlineObject1) o;
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

