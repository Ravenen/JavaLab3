package ua.lviv.iot.christmasfair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.christmasfair.business", "ua.lviv.iot.christmasfair.dataaccess",
    "ua.lviv.iot.christmasfair.controller" })
@EnableJpaRepositories("ua.lviv.iot.christmasfair.dataaccess")
public class RestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }

}
