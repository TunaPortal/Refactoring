package co.refactoring.gateway;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/* https://github.com/springdoc/springdoc-openapi-demos/blob/master/springdoc-openapi-microservices/gateway-service/src/main/java/org/springdoc/demo/services/gateway/GatewayApplication.java */

@SpringBootApplication
@EnableWebFlux
@Log4j2
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


}
