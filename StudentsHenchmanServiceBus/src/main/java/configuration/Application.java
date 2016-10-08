package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author Mateusz Wieczorek on 9/30/16.
 */

@EnableJpaRepositories("repository")
@Configuration
@EnableAutoConfiguration
@ComponentScan("controller")
@EntityScan("model")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}