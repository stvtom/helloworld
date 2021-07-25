import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages ={"springXml", "database","core","servlet"})
@MapperScan("database.mapper")
//@ServletComponentScan(basePackages = "database.config")  // @WebFilter 支持
//@ComponentScan
@EnableAsync  // @Async支持
@EnableAspectJAutoProxy  //@Aspect 支持
public class HelloApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext
//                = new SpringApplication(HelloApplication.class).run();
        SpringApplication.run(HelloApplication.class, args);
    }

}
