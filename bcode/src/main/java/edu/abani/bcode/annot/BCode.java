package edu.abani.bcode.annot;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
public @interface BCode {
    String table() default "user_details";
    String column() default "id";
    String prefix() default "SYS";

}
