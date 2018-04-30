package utils;

import java.util.Arrays;
import java.util.Optional;
import model.Categoria;
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
	public Categoria categoriaCliente(Cliente cliente)
	{
		double clienteConsumo = this.consumoCliente(cliente);
		return Arrays.stream(Categoria.values())
			.filter(categoria -> categoria.getConsumoMinimo() < clienteConsumo && clienteConsumo < categoria.getConsumoMaximo()) 
			.findFirst()
			.get();
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
