package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * InlineObject3
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")

public class ModeloAPIFiltrar {
    @JsonProperty("filtro")
    private String filtro;

    public ModeloAPIFiltrar filtro(String filtro) {
        this.filtro = filtro;
        return this;
    }

    /**
     * Get filtro
     *
     * @return filtro
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModeloAPIFiltrar inlineObject3 = (ModeloAPIFiltrar) o;
        return Objects.equals(this.filtro, inlineObject3.filtro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filtro);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineObject1 {\n");

        sb.append("    filtro: ").append(toIndentedString(filtro)).append("\n");
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

