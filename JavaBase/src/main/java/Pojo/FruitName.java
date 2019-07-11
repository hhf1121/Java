package Pojo;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 水果名称注解
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}