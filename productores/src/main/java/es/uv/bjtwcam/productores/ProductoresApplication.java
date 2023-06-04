package es.uv.bjtwcam.productores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@ComponentScan(basePackages = "es.uv.bjtwcam.productores")
@OpenAPIDefinition(
	info = @Info(
		title = "Productores API",
		version = "v1",
		contact = @Contact (
			name = "Benito Luongo Vegas & Jhon Mora Aguirre", email = "beluonve@alumni.uv.es & jmoa@alumni.uv.es"
		),
		license = @License(
			name = "Apache 2.0",
			url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		),
		description = "API para la gestion de productores y sus ficheros"
	),
	servers = @Server(
		description = "Servidor Productor"
	)
)
public class ProductoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoresApplication.class, args);
	}

}
