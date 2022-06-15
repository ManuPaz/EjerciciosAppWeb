package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * InlineObject2
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")

public class ModeloAPIEliminar {
    @JsonProperty("ano")
    private Integer ano;

    @JsonProperty("tipo")
    private String tipo;

    public ModeloAPIEliminar ano(Integer ano) {
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

    public ModeloAPIEliminar tipo(String tipo) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModeloAPIEliminar inlineObject2 = (ModeloAPIEliminar) o;
        return Objects.equals(this.ano, inlineObject2.ano) &&
                Objects.equals(this.tipo, inlineObject2.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, tipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineObject2 {\n");

        sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
        sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

