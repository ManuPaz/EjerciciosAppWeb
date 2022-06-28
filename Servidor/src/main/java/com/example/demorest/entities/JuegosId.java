package com.example.demorest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class JuegosId implements Serializable {
    @Column(name = "año")
    private Integer año;
    @Column(name = "id_tipo_jjoo")
    private Integer tipo;

    public JuegosId(Integer año,Integer tipo){
        this.año=año;
        this.tipo=tipo;
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
