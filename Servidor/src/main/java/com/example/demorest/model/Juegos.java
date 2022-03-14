package com.example.demorest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Juegos
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-14T09:36:03.661556900+01:00[Europe/Madrid]")

public class Juegos   {
  @JsonProperty("nombre_ciudad")
  private String nombreCiudad;

  @JsonProperty("nombre_pais")
  private String nombrePais;

  @JsonProperty("id_pais")
  private Long idPais;

  @JsonProperty("id_ciudad")
  private Long idCiudad;

  @JsonProperty("valor")
  private Long valor;

  @JsonProperty("descripcion_tipo_jjoo")
  private String descripcionTipoJjoo;

  @JsonProperty("numero_veces_sede")
  private Long numeroVecesSede;

  public Juegos nombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
    return this;
  }

  /**
   * Get nombreCiudad
   * @return nombreCiudad
  */
  @ApiModelProperty(value = "")


  public String getNombreCiudad() {
    return nombreCiudad;
  }

  public void setNombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
  }

  public Juegos nombrePais(String nombrePais) {
    this.nombrePais = nombrePais;
    return this;
  }

  /**
   * Get nombrePais
   * @return nombrePais
  */
  @ApiModelProperty(value = "")


  public String getNombrePais() {
    return nombrePais;
  }

  public void setNombrePais(String nombrePais) {
    this.nombrePais = nombrePais;
  }

  public Juegos idPais(Long idPais) {
    this.idPais = idPais;
    return this;
  }

  /**
   * Get idPais
   * @return idPais
  */
  @ApiModelProperty(value = "")


  public Long getIdPais() {
    return idPais;
  }

  public void setIdPais(Long idPais) {
    this.idPais = idPais;
  }

  public Juegos idCiudad(Long idCiudad) {
    this.idCiudad = idCiudad;
    return this;
  }

  /**
   * Get idCiudad
   * @return idCiudad
  */
  @ApiModelProperty(value = "")


  public Long getIdCiudad() {
    return idCiudad;
  }

  public void setIdCiudad(Long idCiudad) {
    this.idCiudad = idCiudad;
  }

  public Juegos valor(Long valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Get valor
   * @return valor
  */
  @ApiModelProperty(value = "")


  public Long getValor() {
    return valor;
  }

  public void setValor(Long valor) {
    this.valor = valor;
  }

  public Juegos descripcionTipoJjoo(String descripcionTipoJjoo) {
    this.descripcionTipoJjoo = descripcionTipoJjoo;
    return this;
  }

  /**
   * Get descripcionTipoJjoo
   * @return descripcionTipoJjoo
  */
  @ApiModelProperty(value = "")


  public String getDescripcionTipoJjoo() {
    return descripcionTipoJjoo;
  }

  public void setDescripcionTipoJjoo(String descripcionTipoJjoo) {
    this.descripcionTipoJjoo = descripcionTipoJjoo;
  }

  public Juegos numeroVecesSede(Long numeroVecesSede) {
    this.numeroVecesSede = numeroVecesSede;
    return this;
  }

  /**
   * Get numeroVecesSede
   * @return numeroVecesSede
  */
  @ApiModelProperty(value = "")


  public Long getNumeroVecesSede() {
    return numeroVecesSede;
  }

  public void setNumeroVecesSede(Long numeroVecesSede) {
    this.numeroVecesSede = numeroVecesSede;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Juegos juegos = (Juegos) o;
    return Objects.equals(this.nombreCiudad, juegos.nombreCiudad) &&
        Objects.equals(this.nombrePais, juegos.nombrePais) &&
        Objects.equals(this.idPais, juegos.idPais) &&
        Objects.equals(this.idCiudad, juegos.idCiudad) &&
        Objects.equals(this.valor, juegos.valor) &&
        Objects.equals(this.descripcionTipoJjoo, juegos.descripcionTipoJjoo) &&
        Objects.equals(this.numeroVecesSede, juegos.numeroVecesSede);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombreCiudad, nombrePais, idPais, idCiudad, valor, descripcionTipoJjoo, numeroVecesSede);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Juegos {\n");
    
    sb.append("    nombreCiudad: ").append(toIndentedString(nombreCiudad)).append("\n");
    sb.append("    nombrePais: ").append(toIndentedString(nombrePais)).append("\n");
    sb.append("    idPais: ").append(toIndentedString(idPais)).append("\n");
    sb.append("    idCiudad: ").append(toIndentedString(idCiudad)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    descripcionTipoJjoo: ").append(toIndentedString(descripcionTipoJjoo)).append("\n");
    sb.append("    numeroVecesSede: ").append(toIndentedString(numeroVecesSede)).append("\n");
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

