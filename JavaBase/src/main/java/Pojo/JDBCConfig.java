package Pojo;
 
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target(ElementType.METHOD)  //用于方法上
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
	
	 //注解的属性
     String ip();
     int port() default 3306;
     String database();
     String encoding();
     String loginName();
     String password();
}