package com.example.onebite.core.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoValidator.class)
public @interface EstadoValid {
	
	String message() default "Estado inválido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
