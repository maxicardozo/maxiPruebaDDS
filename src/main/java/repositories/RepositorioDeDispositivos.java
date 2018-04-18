package repositories;

import java.util.Collection;

import model.Dispositivo;

public class RepositorioDeDispositivos {
	private static RepositorioDeDispositivos instance = null;
	private Collection<Dispositivo> dispositivos;
	
	private RepositorioDeDispositivos() {
		
	}
	
	public static RepositorioDeDispositivos getInstance() {
		if(instance == null) {
			instance = new RepositorioDeDispositivos();
		}
		return instance;
	}

	public Collection<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Collection<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
