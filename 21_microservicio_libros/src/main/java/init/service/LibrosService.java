package init.service;

import java.util.List;

import init.entities.Libro;
import init.model.LibroDto;

public interface LibrosService {
	List<LibroDto> buscarLibroPorTema(String tema);
	LibroDto buscarLibroPorIsbn(int isbn);
	boolean alta(LibroDto libro);
}
