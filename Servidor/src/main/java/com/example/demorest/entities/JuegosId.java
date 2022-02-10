package com.example.demorest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JuegosId implements Serializable {

    @Column(name = "año")
    private Integer año;

    @Column(name = "id_tipo_jjoo")
    private Integer tipo;

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }


    public JuegosId() {

    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {

        // null check
        if (o == null) {
            return false;
        }

        // this instance check
        if (this == o) {
            return true;
        }

        // instanceof Check and actual value check
        if ((o instanceof JuegosId) && (((JuegosId) o).getAño() == this.getAño()) && (((JuegosId) o).getTipo() == this.getTipo())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (año * 10 + tipo);
        return result;
    }
}
