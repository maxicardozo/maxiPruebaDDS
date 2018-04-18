package model;

public class Categoria {
	private String nombre;
	private double condumoMensual;
	private String concepto;
	private String unidad;
	private double normal;	
	
	public Categoria() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCondumoMensual() {
		return condumoMensual;
	}

	public void setCondumoMensual(double condumoMensual) {
		this.condumoMensual = condumoMensual;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	

}
