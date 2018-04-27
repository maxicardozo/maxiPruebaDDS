package repositories;

import java.util.List;

import model.Dispositivo;

public class RepositorioDeDispositivos {
	private static RepositorioDeDispositivos instance = null;
	private List<Dispositivo> dispositivos;
	
	private RepositorioDeDispositivos() {
		
	}
	
	public static RepositorioDeDispositivos getInstance() {
		if(instance == null) {
			instance = new RepositorioDeDispositivos();
		}
		return instance;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
