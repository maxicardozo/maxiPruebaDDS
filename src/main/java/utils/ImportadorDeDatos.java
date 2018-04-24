package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

import model.CategoriaEnum;
import model.Cliente;
import model.Dispositivo;

public class ImportadorDeDatos {

	private ManejadorDeArchivos lectorDeArchivos;

	public ImportadorDeDatos(ManejadorDeArchivos manejadorArchivos) {
		this.lectorDeArchivos = manejadorArchivos;
	}

	/**
	 * Deserializa una fecha que tiene el formato "AAAA-MM-DD".
	 * @param fechaJson
	 * @return La fecha parseada.
	 */
	public LocalDate deserializarFechaAlta(String fechaJson) {
		LocalDate nuevaFechaAlta = LocalDate.parse(fechaJson, DateTimeFormatter.ISO_LOCAL_DATE);

		return nuevaFechaAlta;
	}

	/**
	 * Obtiene un objeto JSON y lo convierte a un Cliente.
	 * @param cliente
	 * @return El cliente parseado.
	 */
	public Cliente deserializarCliente(JsonObject cliente) {
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setNombre(cliente.get("nombre").getAsString());
		nuevoCliente.setApellido(cliente.get("apellido").getAsString());
		nuevoCliente.setTipoDocumento(cliente.get("tipoDocumento").getAsString());
		nuevoCliente.setNumeroDocumento(cliente.get("numeroDocumento").getAsString());
		nuevoCliente.setTelefono(cliente.get("telefono").getAsString());
		nuevoCliente.setDomicilio(cliente.get("domicilio").getAsString());
		// Seteamos la fecha.
		nuevoCliente.setFechaAlta(this.deserializarFechaAlta(cliente.get("fechaAlta").getAsString()));
		// Seteamos la nueva categoría.
		nuevoCliente.setCategoria(CategoriaEnum.valueOf(cliente.get("categoria").getAsString()));

		return nuevoCliente;
	}
	
	/**
	 * Deserializa un array de Clientes.
	 * @param clientes
	 * @return La lista de clientes.
	 */
	public List<Cliente> deserializarClientes(JsonArray clientes) {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		clientes.forEach(cliente -> listaClientes.add(this.deserializarCliente(cliente.getAsJsonObject())));
		return listaClientes;
	}
	
	/**
	 * Obtiene un objeto JSON y lo convierte a un Cliente.
	 * @param dispositivo
	 * @return El dispositivo ya parseado.
	 */
	public Dispositivo deserializarDispositivo(JsonObject dispositivo) {
		Dispositivo nuevoDispositivo = new Dispositivo();
		nuevoDispositivo.setNombreGenerico(dispositivo.get("nombreGenerico").getAsString());
		nuevoDispositivo.setkWHora(dispositivo.get("kWHora").getAsDouble());
		nuevoDispositivo.setEncendido(dispositivo.get("encendido").getAsBoolean());

		return nuevoDispositivo;
	}
    
	/**
	 * Deserializa un array de Dispositivos.
	 * @param dispositivos
	 * @return La lista de dispositivos.
	 */
	public List<Dispositivo> deserializarDispositivos(JsonArray dispositivos) {
		List<Dispositivo> listaDispositivos = new ArrayList<Dispositivo>();
		dispositivos.forEach(dispositivo -> listaDispositivos.add(this.deserializarDispositivo(dispositivo.getAsJsonObject())));
		return listaDispositivos;
	}

	/**
	 * Importa todos los dispositivos de un archivo de dispositivos JSON.
	 * @param filePath El path donde se encuentra el archivo JSON.
	 * @return La lista de dispositivos parseada.
	 */
	public List<Dispositivo> importarRepositorioDeDispositivos(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivo(filePath);
		Gson gson = new Gson();
		JsonArray listaDispositivos= gson.fromJson(datosLeidos, JsonElement.class).getAsJsonObject().get("dispositivos").getAsJsonArray();
		List<Dispositivo> dispositivos = this.deserializarDispositivos(listaDispositivos);
		return dispositivos;
		// RepositorioDeDispositivos.getInstance().setDispositivos(gson.fromJson(datosLeidos, RepositorioDeDispositivos.class).getDispositivos());
	}

	/**
	 * Importa todos los Clientes de un archivo de clientes JSON.
	 * @param filePath El path donde se encuentra el archivo JSON.
	 * @return La lista de clientes parseada.
	 */
	public List<Cliente> importarRepositorioDeUsuarios(String filePath) {
		String datosLeidos = this.lectorDeArchivos.leerArchivo(filePath);
		Gson gson = new Gson();
		JsonArray listaClientes = gson.fromJson(datosLeidos, JsonElement.class).getAsJsonObject().get("clientes").getAsJsonArray();
		List<Cliente> clientes = this.deserializarClientes(listaClientes);
		return clientes;
		// RepositorioDeUsuarios.getInstance().setUsuarios(gson.fromJson(datosLeidos, RepositorioDeUsuarios.class).getUsuarios());
	}
}
