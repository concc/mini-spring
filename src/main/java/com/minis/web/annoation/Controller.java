package com.minis.web.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

    String value() default "";
}
