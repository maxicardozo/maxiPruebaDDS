package repositories;

import java.util.Collection;

import model.Cliente;
import model.Dispositivo;

public class RepositorioDeUsuarios {
	private static RepositorioDeUsuarios instance = null;
	private Collection<Cliente> clientes;
	
	private RepositorioDeUsuarios() {
		
	}
	
	public static RepositorioDeUsuarios getInstance() {
		if(instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}

	public Collection<Cliente> getUsuarios() {
		return clientes;
	}

	public void setUsuarios(Collection<Cliente> usuarios) {
		this.clientes = usuarios;
	}
}
