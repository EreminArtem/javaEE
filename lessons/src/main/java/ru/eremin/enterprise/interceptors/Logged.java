package ru.eremin.enterprise.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Inherited
@InterceptorBinding
@Target({TYPE, METHOD, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface Logged {
}
