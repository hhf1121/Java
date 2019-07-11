package Spring;

import Spring.ConfigBean.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Spring.Bean.Person;

public class SpringApplicarion {

	public static void main(String[] args) {

		//创建ioc容器，用xml的方式
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("bean.xml");
		//创建ioc容器，用注解的方式
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		Person bean = (Person)ctx.getBean("person");
		System.out.println(bean.getName()+"-"+bean.getAge());
	}
	
}
