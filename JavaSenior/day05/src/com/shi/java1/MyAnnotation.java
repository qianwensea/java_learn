package com.shi.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author 千文sea
 * @create 2020-04-01 17:23
 */
@Repeatable(MyAnnotations.class)
@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
