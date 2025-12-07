package com.jamie.types.annotations;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Jamie
 * @date: 06/12/2025 16:06
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented

public @interface DCCValue {

    String value() default "";
}
