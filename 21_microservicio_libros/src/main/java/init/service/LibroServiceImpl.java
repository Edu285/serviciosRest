package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.LibrosDao;
import init.model.LibroDto;
import init.utilidades.Mapeador;

@Service
public class LibroServiceImpl implements LibrosService {

	LibrosDao librosDao;
	Mapeador mapeador;
	
	public LibroServiceImpl(LibrosDao librosDao, Mapeador mapeador) {
		this.librosDao = librosDao;
		this.mapeador = mapeador;
	}
	
	@Override
	public List<LibroDto> buscarLibroPorTema(String tema) {
		return librosDao.findByIdTema(tema)
				.stream()
				.map(l->mapeador.libroEntityToDto(l))
				.toList();	
	}

	@Override
	public LibroDto buscarLibroPorIsbn(int isbn) {
		return librosDao.findById(isbn)//devuelve Optional<Libro>
				.map(l->mapeador.libroEntityToDto(l))//devuelve Optional<LibroDto>
				.orElse(null);
	}

	@Override
	public boolean alta(LibroDto libro) {
		if(librosDao.findById(libro.getIsbn()).isEmpty()) {
			librosDao.save(mapeador.libroDtoToEntity(libro));
			return true;
		}
		return false;
	}
}
