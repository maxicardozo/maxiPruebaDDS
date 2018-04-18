package repositories;

import java.util.Collection;

import model.Dispositivo;
import model.Usuario;

public class RepositorioDeUsuarios {
	private static RepositorioDeUsuarios instance = null;
	private Collection<Usuario> usuarios;
	
	private RepositorioDeUsuarios() {
		
	}
	
	public static RepositorioDeUsuarios getInstance() {
		if(instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
