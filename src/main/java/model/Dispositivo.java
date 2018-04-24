package model;

public class Dispositivo {
	private String nombreGenerico;
	private double kWHora;
	private boolean encendido;
	
	public Dispositivo() {
		super();
	}

	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public double getkWHora() {
		return kWHora;
	}

	public void setkWHora(double kWHora) {
		this.kWHora = kWHora;
	}

	public boolean estaEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
}
