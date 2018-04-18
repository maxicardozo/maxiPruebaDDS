package utils;

import java.util.Collection;

import com.google.gson.Gson;

import model.Dispositivo;
import repositories.RepositorioDeDispositivos;
import repositories.RepositorioDeUsuarios;

public class ImportadorDeDatos {

	private ManejadorDeArchivos lectorDeArchivos;
	
	public ImportadorDeDatos() {
		this.lectorDeArchivos = new ManejadorDeArchivos();
	}
	
	public void importarRepositorioDeDispositivos(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivoJson(filePath);
		Gson gson = new Gson();		
		//Collection<Dispositivo> dddddd = (Collection<Dispositivo>) gson.fromJson(datosLeidos, Dispositivo.class);
		RepositorioDeDispositivos.getInstance().setDispositivos(gson.fromJson(datosLeidos, RepositorioDeDispositivos.class).getDispositivos());		
	}
	
	public void importarRepositorioDeUsuarios(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivoJson(filePath);
		Gson gson = new Gson();
		RepositorioDeUsuarios.getInstance().setUsuarios(gson.fromJson(datosLeidos, RepositorioDeUsuarios.class).getUsuarios());
	}
}
