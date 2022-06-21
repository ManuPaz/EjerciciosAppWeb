package com.example.demorest.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Entidad {


    /**
     *
     * @return the key pivot in the database table
     */
    boolean  obligatorio() default false;


}
