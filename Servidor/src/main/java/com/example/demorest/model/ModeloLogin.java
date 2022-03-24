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
 * ModeloLogin
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-24T10:46:37.150652900+01:00[Europe/Madrid]")

public class ModeloLogin   {
  @JsonProperty("user")
  private String user;

  @JsonProperty("password")
  private String password;

  public ModeloLogin user(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public ModeloLogin password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
    return Objects.equals(this.user, modeloLogin.user) &&
        Objects.equals(this.password, modeloLogin.password);
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

