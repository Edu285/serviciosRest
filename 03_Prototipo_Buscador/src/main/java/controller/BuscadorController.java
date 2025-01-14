package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import service.BuscadorService;

@Path("/buscador")
public class BuscadorController {
	
	BuscadorService buscador= new BuscadorService();
	
	@GET
	@Path("/buscar/{tematica}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> buscar(@PathParam("tematica") String tematica){
		return buscador.busqueda(tematica);
	}
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alta(Resultado resultado) {
		buscador.alta(resultado);
	} 
	
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> eliminiar(@QueryParam("url") String url) {//se podria mandar con FormParam
		return buscador.eliminar(url);
	}
}
