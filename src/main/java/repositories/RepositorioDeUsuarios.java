package repositories;

import java.util.List;

import model.Cliente;

public class RepositorioDeUsuarios {
	private static RepositorioDeUsuarios instance = new RepositorioDeUsuarios();
	private List<Cliente> clientes;
	
	private RepositorioDeUsuarios() {
		
	}
	
	public static RepositorioDeUsuarios getInstance() {
		return instance;
	}

	public List<Cliente> getUsuarios() {
		return clientes;
	}

	public void setUsuarios(List<Cliente> usuarios) {
		this.clientes = usuarios;
	}
}