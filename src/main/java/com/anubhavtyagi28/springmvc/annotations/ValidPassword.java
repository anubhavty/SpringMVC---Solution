package com.anubhavtyagi28.springmvc.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default
            "Password must contain at least one uppercase letter, one lowercase letter, one special character and be at least 10 characters long";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
