package com.example.demorest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//clean code: anadir lombok
@Getter
@Setter
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ModeloAPIFiltrar {
    @JsonProperty("filtro")
    private String filtro;

    public ModeloAPIFiltrar filtro(String filtro) {
        this.filtro = filtro;
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

