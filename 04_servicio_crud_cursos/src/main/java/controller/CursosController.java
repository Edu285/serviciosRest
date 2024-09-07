package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Curso;
import service.CursosService;

@Path("/cursos")
public class CursosController {
	
	CursosService cursosService=new CursosService();

	//http://localhost:8080/04_servicio_crud_cursos/cursos/alta (pruebas + un json)
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String alta(Curso curso) {
		return String.valueOf(cursosService.alta(curso));
	}
	
	//http://localhost:8080/04_servicio_crud_cursos/cursos/eliminar/[nombre] (pruebas)
	@DELETE
	@Path("/eliminar/{nombre}")
	public void eliminar(@PathParam("nombre") String nombre) {
		cursosService.eliminar(nombre);
	}
	
	//http://localhost:8080/04_servicio_crud_cursos/cursos/actualizar (pruebas + json)
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Curso curso) {
		cursosService.modificarDatos(curso);
	}
	
	//http://localhost:8080/04_servicio_crud_cursos/cursos/buscar/[nombre] (pruebas)
	@GET
	@Path("/buscar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Curso buscarPorNombre(@PathParam("nombre") String nombre) {
		return cursosService.buscarCurso(nombre);
	}
	
	//http://localhost:8080/04_servicio_crud_cursos/cursos/recuperartodos (pruebas)
	@GET
	@Path("/recuperartodos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> recuperarTodos(){
		return cursosService.devuelveCursos();
	}
}