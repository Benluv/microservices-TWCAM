package es.uv.bjtwcam.consumidores;

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
		title = "Consumidores API",
		version = "v1",
		contact = @Contact (
			name = "Benito Luongo Vegas & Jhon Mora Aguirre", email = "beluonve@alumni.uv.es & jmoa@alumni.uv.es"
		),
		license = @License(
			name = "Apache 2.0",
			url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		),
		description = "API para obtener ficheros de datos, sus previsualizaciones y contenidos"
	),
	servers = @Server(
		description = "Servidor Consumidor"
	)
)
public class ConsumidoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidoresApplication.class, args);
	}

}
