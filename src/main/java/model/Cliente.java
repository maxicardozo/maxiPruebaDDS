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
	private CategoriaEnum categoria;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();


	public Cliente() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public CategoriaEnum getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
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
}
