package es.uv.bjtwcam.productores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import es.uv.bjtwcam.productores.analyzers.MyCustomException;

@Configuration
@Profile("default")
public class WebDefaultConfiguration {

    @Bean
    public void testBean() {
        throw new MyCustomException();
    }
}
