package service;

import java.util.List;

import model.Curso;

public interface CursosService {

	boolean alta(Curso curso);

	void eliminar(String nombre);

	void actualizar(Curso curso);

	Curso buscarCurso(String nombre);

	List<Curso> devuelveCursos();

}