package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.CategoriaEnum;
import model.Cliente;

import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;

import utils.CategorizadorClientes;

public class CategorizadorClientesTest {

	@Test
	public void categoriaCliente_devuelveR3_cuandoSeLePasa375DeConsumo() 
	{
		// Arrange
		CategorizadorClientes categorizador = spy(CategorizadorClientes.class);
		Cliente cliente = mock(Cliente.class);
		CategoriaEnum categoriaEsperada = CategoriaEnum.R3;
		
		// Act
		doReturn(375.00).when(categorizador).consumoCliente(any(Cliente.class));
		CategoriaEnum categoriaObtenida = categorizador.categoriaCliente(cliente);
		
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
	@Test
	public void categoriaCliente_devuelveR1_cuandoSeLePasa50DeConsumo() 
	{
		// Arrange
		CategorizadorClientes categorizador = spy(CategorizadorClientes.class);
		Cliente cliente = mock(Cliente.class);
		CategoriaEnum categoriaEsperada = CategoriaEnum.R1;
		
		// Act
		doReturn(50.00).when(categorizador).consumoCliente(any(Cliente.class));
		CategoriaEnum categoriaObtenida = categorizador.categoriaCliente(cliente);
		
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
	@Test
	public void categoriaCliente_devuelveR9_cuandoSeLePasaMaxDelMaximo() 
	{
		// Arrange
		CategorizadorClientes categorizador = spy(CategorizadorClientes.class);
		Cliente cliente = mock(Cliente.class);
		CategoriaEnum categoriaEsperada = CategoriaEnum.R9;
		
		// Act
		doReturn(2000.00).when(categorizador).consumoCliente(any(Cliente.class));
		CategoriaEnum categoriaObtenida = categorizador.categoriaCliente(cliente);
		
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void categoriaCliente_devuelveExcepcion_cuandoNoEncuentraCategoria() 
	{
		// Arrange
		CategorizadorClientes categorizador = spy(CategorizadorClientes.class);
		Cliente cliente = mock(Cliente.class);
		
		// Act
		doReturn(-10.00).when(categorizador).consumoCliente(any(Cliente.class));
		categorizador.categoriaCliente(cliente);
	}

}
