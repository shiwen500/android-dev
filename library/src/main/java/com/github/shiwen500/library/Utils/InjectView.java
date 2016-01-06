package com.github.shiwen500.library.Utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sunyun004_macmini on 16/1/6.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectView {
    int id() default -1;
    boolean clickable() default false;
}
