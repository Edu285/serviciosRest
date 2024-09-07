package service;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import model.Formacion;

public class FormacionService {

	String url="http://localhost:8080/04_servicio_crud_cursos/cursos";
	
	WebTarget wt=ClientBuilder
			.newClient()
			.target(url);
	
	public List<Formacion> buscarPorArea(String area) {
		Formacion[] todos=wt
				.path("/recuperartodos")
				.request(MediaType.APPLICATION_JSON)
				.get(Formacion[].class);
		
		return Arrays.stream(todos)
				.filter(f->f.getArea().equals(area))
				.toList();
	}
	
	public void altaFormacion(Formacion formacion) {
		wt
		.path("/alta")
		.request(MediaType.TEXT_PLAIN)
		.post(Entity.entity(formacion, MediaType.APPLICATION_JSON));//response
		/*Si quisieramos que devolviera algo por ejemplo un String
		 * String res=(String)wt
		.path("/alta")
		.request(MediaType.TEXT_PLAIN)
		.post(Entity.entity(formacion, MediaType.APPLICATION_JSON))
		.getEntity();// no usamos el string devuelto por el servicio cursos*/
	}

}
