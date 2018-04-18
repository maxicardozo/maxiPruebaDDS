package model;

import java.util.Collection;

public class Usuario {
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private long numeroDocumento;
	private long telefono;
	private String domicilio;
	private String fechaAlta;	
	private String nombreUsuario;
	private String contrasenia;
	private Categoria categoria;
	private Collection<Dispositivo> dispositivos;
	
	
	public Usuario() {
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


	public long getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public Collection<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	public void setDispositivos(Collection<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
}
