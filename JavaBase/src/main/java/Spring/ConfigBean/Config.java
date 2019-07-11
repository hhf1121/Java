package Spring.ConfigBean;

import Spring.Bean.Man;
import Spring.Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Person person(){
        return new Person();
    }


    @Bean
    public Man man(){
        return new Man();
    }

}
