package repositories;

import java.util.List;

import model.Dispositivo;

public class RepositorioDeDispositivos {
	private static RepositorioDeDispositivos instance = new RepositorioDeDispositivos();
	private List<Dispositivo> dispositivos;
	
	private RepositorioDeDispositivos() {
		
	}
	
	public static RepositorioDeDispositivos getInstance() {
		return instance;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
