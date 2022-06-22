package com.example.demorest.anotaciones;

import com.example.demorest.dtos.JuegosDTO;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ValidationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;

public class Validador {
    private static final String THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK = "Throwing exception for demoing Rollback!!!";
    private static final String TIPO_DE_SEDE_ERRONEO = "Tipo de Sede erroneo: debe ser invierno o verano";

    /**
     * Si la clase que encapsula el optional esta anotada con Entidad y no hay objeto en el Optional lanza excepcion
     *
     * @param opt   Optional del que se quiere obtener el objeto
     * @param clase Clase del objeto que deberia estar encapsulado en el Optional. Se pasa en un argumento separado porque
     *              si Optional no contiene un objeto no se puede extraer la clase
     * @return El objeto que encapsula el Optional o null si no encapsula ningun objeto y la clase no tiene la anotacion Entidad
     * @throws DataIntegrityViolationException
     */
    public static Object procesarOptional(Optional opt, Class clase) throws DataIntegrityViolationException {
        final Entidad entidad = (Entidad) clase.getAnnotation(Entidad.class);
        if (entidad != null && entidad.obligatorio() && !opt.isPresent()) {
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
        }
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    /**
     * Si algun campo anotado con Estacion no tiene un valor correcto (INVIERNO , VERANO o null si puede ser null)
     * lanza una excepcion.
     *
     * @param juegosDTO DTO del que se comprueban los campos
     * @throws ValidationException
     */
    public static void procesarFields(JuegosDTO juegosDTO) throws ValidationException {
        final Set<String> estaciones = Set.of("VERANO", "INVIERNO");
        final Class clase = juegosDTO.getClass();
        final Field[] fields = clase.getDeclaredFields();
        for (Field field : fields) {
            final Estacion estacion = field.getAnnotation(Estacion.class);
            if (estacion != null) {
                String name = field.getName();
                name = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    final Method method = clase.getMethod(name);
                    final String atributo = (String) method.invoke(juegosDTO);
                    //la anotacion Estacion tiene un atributo para permitir nulos o no
                    if (!((!estacion.notNull() && atributo == null) ||  estaciones.contains(atributo))) {
                        throw new ValidationException(TIPO_DE_SEDE_ERRONEO);
                    }
                } catch (final NoSuchMethodException |  IllegalAccessException | InvocationTargetException e) {
                }
            }
        }
    }
}
