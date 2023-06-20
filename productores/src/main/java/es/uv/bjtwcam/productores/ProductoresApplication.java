package es.uv.bjtwcam.productores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Productores API",
		version = "v1",
		contact = @Contact (
			name = "Benito Luongo Vegas", email = "beluonve@alumni.uv.es"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://www.apache.org/licenses/LICENSE-2.0"
		),
		description = "API para la gestion de productores y sus ficheros"
	),
	servers = @Server(
		url = "http://127.0.0.1:8080",
		description = "Servidor Productor"
	)
)
public class ProductoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoresApplication.class, args);
	}

}
