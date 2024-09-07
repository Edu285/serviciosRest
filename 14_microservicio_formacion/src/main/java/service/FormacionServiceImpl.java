package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	String url="http://localhost:8000/cursos/";
	RestClient restClient;
		
	public FormacionServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient
				.get()//peticion get
				.uri(url+"recuperartodos")//damos la direccion
				.retrieve()//para realizar la llamada
				.body(Formacion[].class)//un array de objetos formacion
				).filter(f->f.getArea().equals(area)).toList();//filtrado
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		restClient
			.post()//metodo post
			.uri(url+"alta")//direccion
			.contentType(MediaType.APPLICATION_JSON)//formato
			.body(formacion)//transforma a un objeto formacion
			.retrieve();//realiza la llamada   
	}

}
