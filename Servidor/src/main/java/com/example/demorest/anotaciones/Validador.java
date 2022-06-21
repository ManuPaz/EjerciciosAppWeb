package com.example.demorest.anotaciones;

import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

public class Validador {
    private static final String THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK = "Throwing exception for demoing Rollback!!!";

    /**
     * @param opt   Optional del que se quiere obtener el objeto
     * @param clase Clase del objeto que deberia estar encapsulado en el Optional. Se pasa en un argumento separado porque
     *              si Optional no contiene un objeto no se puede extraer la clase
     * @return
     * @throws DataIntegrityViolationException
     */
    public static Object procesarOptional(Optional opt, Class clase) {
        final Entidad entidad = (Entidad) clase.getAnnotation(Entidad.class);
        if (entidad != null && entidad.obligatorio() && !opt.isPresent()) {
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
        }
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
}
