package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * InlineObject3
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-17T09:04:58.822522600+01:00[Europe/Madrid]")

public class InlineObject3 {
    @JsonProperty("filtro")
    private String filtro;

    public InlineObject3 filtro(String filtro) {
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
        InlineObject3 inlineObject3 = (InlineObject3) o;
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

