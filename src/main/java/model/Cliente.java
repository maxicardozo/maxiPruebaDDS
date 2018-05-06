package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String numeroDocumento;
	private String telefono;
	private String domicilio;
	private LocalDate fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

	//public Cliente(String nombre, String apellido, String tipoDocumento, String numeroDocumento, String telefono, String domicilio, LocalDate fechaAlta, Categoria categoria, List<Dispositivo> dispositivos) {
	public Cliente(String nombre, String apellido, String tipoDocumento, String numeroDocumento, String telefono, String domicilio, LocalDate fechaAlta, Categoria categoria) {
	    this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.categoria = categoria;
    	//this.dispositivos = dispositivos;
    }

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	/**
	 * Metodo que solo debe ser utilizado por la clase Categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Indica si al menos un dispositivo está encendido.
	 * @return Si tiene un dispositivo encendido.
	 */
	public boolean tieneDispositivoEncendido() {
		return this.dispositivos.stream().anyMatch(dispositivo -> dispositivo.estaEncendido());
	}
	
	/**
	 * Devuelve la cantidad de dispositivos que tiene este cliente.
	 * @return La cantidad de dispositivos de este cliente.
	 */
	public long cantidadDispositivos() {
		return this.dispositivos.stream().count();
	}
	
	/**
	 * Devuelve la cantidad de dispositivos encendidos que tiene este cliente.
	 * @return La cantidad de dispositivos encendidos de este cliente.
	 */
	public long cantidadDispositivosEncendidos() {
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.estaEncendido()).count();
	}
	
	/**
	 * Devuelve la cantidad de dispositivos apagados que tiene este cliente.
	 * @return La cantidad de dispositivos apagados de este cliente.
	 */
	public long cantidadDispositivosApagados() {
		return this.dispositivos.stream().filter(dispositivo -> !dispositivo.estaEncendido()).count();
	}
	
	/**
	 * Devuelve el consumo de este cliente.
	 * @return El consumo de este cliente.
	 */
	public double consumo()
	{
		return this
			.getDispositivos()
			.stream()
			.mapToDouble(dispositivo -> dispositivo.getkWHora())
			.sum();
	}
	
}