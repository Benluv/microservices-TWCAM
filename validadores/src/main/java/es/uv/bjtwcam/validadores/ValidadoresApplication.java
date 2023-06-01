package es.uv.bjtwcam.validadores;

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
		title = "Validadores API",
		version = "v1",
		contact = @Contact (
			name = "Benito Luongo Vegas & Jhon Mora Aguirre", email = "beluonve@alumni.uv.es & jmoa@alumni.uv.es"
		),
		license = @License(
			name = "Apache 2.0",
			url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		),
		description = "API para aprobar productores y publicar ficheros"
	),
	servers = @Server(
		description = "Servidor Validador"
	)
)
public class ValidadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidadoresApplication.class, args);
	}

}
