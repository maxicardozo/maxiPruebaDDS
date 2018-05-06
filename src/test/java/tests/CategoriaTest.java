package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import model.Categoria;
import model.Cliente;
import model.Dispositivo;

import static org.mockito.Mockito.*;

public class CategoriaTest {

	Cliente cliente;
	Dispositivo dispositivo1;
	Dispositivo dispositivo2;
	Dispositivo dispositivo3;
	Dispositivo dispositivo4;
	
	@Before
	public void setUp() {	
				
		cliente = new Cliente(null, null, null, null, null, null, null, null);
		// cliente = new Cliente(null, null, null, null, null, null, null, null, null);
		dispositivo1 = new Dispositivo(null,50,true);
		dispositivo2 = new Dispositivo(null,100,true);
		dispositivo3 = new Dispositivo(null,200,true);
		dispositivo4 = new Dispositivo(null,1200,true);
		
	}

	@Test
	public void categorizarCliente_devuelveR3_cuandoSeLeAsignanDispositivosCon350DeConsumoTotal() 
	{
		// Arrange
		cliente.getDispositivos().add(dispositivo1);
		cliente.getDispositivos().add(dispositivo2);
		cliente.getDispositivos().add(dispositivo3);
		Categoria categoriaEsperada = Categoria.R3;

		// Act
		Categoria categoriaObtenida = categoriaEsperada.categorizar(cliente);
		
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
	@Test
	public void categorizarCliente_devuelveR1_cuandoSeLeAsignanDispositivosCon50DeConsumoTotal() 
	{
		// Arrange
		cliente.getDispositivos().add(dispositivo1);
		Categoria categoriaEsperada = Categoria.R1;

		// Act
		Categoria categoriaObtenida = categoriaEsperada.categorizar(cliente);

				
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
	@Test
	public void categorizarCliente_devuelveR1_cuandoSeLeAsignanDispositivosConMasDe1400DeConsumoTotal()
	{
		// Arrange
		cliente.getDispositivos().add(dispositivo1);
		cliente.getDispositivos().add(dispositivo2);
		cliente.getDispositivos().add(dispositivo3);
		cliente.getDispositivos().add(dispositivo4);
		Categoria categoriaEsperada = Categoria.R9;

		// Act
		Categoria categoriaObtenida = categoriaEsperada.categorizar(cliente);

			
		// Assert
		assertEquals(categoriaEsperada, categoriaObtenida);
	}
	
}