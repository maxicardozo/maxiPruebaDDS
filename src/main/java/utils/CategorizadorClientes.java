package utils;

import java.util.Arrays;
import java.util.Optional;
import model.CategoriaEnum;
import model.Cliente;

public class CategorizadorClientes {
	
	public CategorizadorClientes()
	{
		super();
	}
	
	/**
	 * Devuelve la categoria a la que debería pertenecer un cliente teniendo en cuenta su consumo.
	 * @param cliente
	 * @return La categoria a la que deberia pertenecer.
	 */
	public CategoriaEnum categoriaCliente(Cliente cliente)
	{
		// Obtenemos el consumo del cliente (esta lógica va a ser modificada...
		double clienteConsumo = this.consumoCliente(cliente);
		
		// Buscamos si el consumo del cliente se encuentra dentro del consumo minimo y maximo de alguna
		// categoría.
		Optional<CategoriaEnum> categoriaCorrespondiente = Arrays.stream(CategoriaEnum.values())
			.filter(categoria -> categoria.getConsumoMinimo() < clienteConsumo && clienteConsumo < categoria.getConsumoMaximo())
			.findFirst();
		
		// Devolvemos esa categoría si existe, si no, devuelve excepción.
		return categoriaCorrespondiente.get();
	}
	
	/**
	 * Devuelve el consumo de un cliente.
	 * @param cliente
	 * @return El consumo del cliente.
	 */
	public double consumoCliente(Cliente cliente)
	{
		return cliente
			.getDispositivos()
			.stream()
			.mapToDouble(dispositivo -> dispositivo.getkWHora())
			.sum();
	}
}
