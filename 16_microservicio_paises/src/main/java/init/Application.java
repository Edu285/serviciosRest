/*Microservicio paises

Crear un microservicio cliente del servicio público de paises. Este servicio tendrá dos recursos:

-lista de continentes
-lista de paises del continente cuyo nombre se recibe en url

Cada pais tiene los siguientes campos: nombre,continente,capital, población y bandera */
package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = {"service", "controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestClient getClient(){
		return RestClient.create();
	}
}

