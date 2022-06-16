package com.example.demorest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//clean code: anadir lombok
@Getter
@Setter
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ModeloLogin {
    @JsonProperty("user")
    private String user;
    @JsonProperty("password")
    private String password;

    public ModeloLogin user(String user) {
        this.user = user;
        return this;
    }

    public ModeloLogin password(String password) {
        this.password = password;
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
        ModeloLogin modeloLogin = (ModeloLogin) o;
        return Objects.equals(this.user, modeloLogin.user) && Objects.equals(this.password, modeloLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModeloLogin {\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

