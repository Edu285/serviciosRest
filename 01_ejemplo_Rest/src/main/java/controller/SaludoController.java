package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas")
public class SaludoController {
	@GET//el método se ejecutara con peticiones GET
	@Path("/saludar")//la direccion
	@Produces(MediaType.TEXT_PLAIN)//el formato que se va a devolver, otro sera JSON por ejemplo
	public String getSaludo() {
		return "Bienvenido a mi servicio REST.";
	}

	@GET //el método se ejecutara con peticiones Get
	@Path("/saludar/{name}") // la direccion con la variable
	@Produces(MediaType.TEXT_PLAIN)// lo que devuelve el texto plano en este caso pero se puede devolver un JSON
	public String getSaludoPersonal(@PathParam("name") String nombre) {
		return "Bienvenido a mis servicios REST sr/sra "+nombre+".";
	}

	@GET //el método se ejecutara con http://localhost:8080/01_ejemplo_Rest/pruebas/info?name=Juan&age=88
	@Path("/info") // la direccion con la variable
	@Produces(MediaType.TEXT_PLAIN)// lo que devuelve el texto plano en este caso pero se puede devolver un JSON
	public String getInfo(@QueryParam("name") String nombre, @QueryParam("age") int edad) {
		return "Te llamas "+nombre+" y tienes "+edad+" años.";
	}
}
