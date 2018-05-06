package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import repositories.RepositorioDeUsuarios;
import utils.ImportadorDeDatos;
import utils.ManejadorDeArchivos;;

public class RepositorioDeClientesTest {

	List<Cliente> clientes;
	
	Cliente cliente1;
	Cliente cliente2;
	
	@Before
	public void setUp() {	
		
		clientes = new ArrayList<Cliente>();
		
		cliente1 = new Cliente(null, null, null, null, null, null, null, null);
		cliente2 = new Cliente(null, null, null, null, null, null, null, null);
		//cliente1 = new Cliente(null, null, null, null, null, null, null, null, null);
		//cliente2 = new Cliente(null, null, null, null, null, null, null, null, null);
		
	}
	
	@After
    public void tearDown() {
		RepositorioDeUsuarios.getInstance().getUsuarios().clear();
	}	

	@Test
	public void persistirEnMemoria() {
		// Arrange				
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		// Act
		RepositorioDeUsuarios.getInstance().setUsuarios(clientes);
		
		// Assert
		assertEquals(2, RepositorioDeUsuarios.getInstance().getUsuarios().size());
	}

}
