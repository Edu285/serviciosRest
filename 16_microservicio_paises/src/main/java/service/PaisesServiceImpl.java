package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {

	String url="https://restcountries.com/v2/all";
	RestClient restClient;
	
	public PaisesServiceImpl(RestClient restClient) {		
		this.restClient = restClient;
	}

	@Override
	public List<String> continentes() {
		try {
			return Arrays.stream(restClient
				.get()
				.uri(url)
				.retrieve()
				.body(Pais[].class)//Stream de objeto pais
				).map(p->p.getContinente())
				.distinct()
				.toList();
		}catch(HttpClientErrorException ex) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Pais> buscarPaisesPorContinente(String continente) {
		try {
		return Arrays.stream(restClient
				.get()
				.uri(url)
				.retrieve()
				.body(Pais[].class)
				).filter(p->p.getContinente().equals(continente))
				.toList();
		}catch(HttpClientErrorException ex) {
			throw new RuntimeException();
		}
	}
}
