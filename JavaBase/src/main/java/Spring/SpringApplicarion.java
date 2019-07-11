package Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Spring.Bean.Person;

public class SpringApplicarion {

	public static void main(String[] args) {
		
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("bean.xml");
		Person bean = (Person)ctx.getBean("personId");
		System.out.println(bean.getName()+"-"+bean.getAge());
	}
	
}
