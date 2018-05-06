package model;

public class Dispositivo {
	private String nombreGenerico;
	private double kWHora;
	private boolean encendido;

	public Dispositivo(String nombreGenerico, double kWHora, boolean encendido) {
        this.nombreGenerico = nombreGenerico;
        this.kWHora = kWHora;
        this.encendido = encendido;
	}

	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public double getkWHora() {
		return kWHora;
	}

	public boolean estaEncendido() {
		return encendido;
	}
}
