package model;
//Servicio REST formación
//Crear un servicio REST que exponga un recurso que, a partir de un área recibida en la 
//URL, devuelva una listado de cursos que pertenezcan a dicha área.

public class Formacion {
	private String nombre;
	private String area;
	private int duracion;
	private double precio;

	public Formacion() {
		super();
	}

	public Formacion(String nombre, String area, int duracion, double precio) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

