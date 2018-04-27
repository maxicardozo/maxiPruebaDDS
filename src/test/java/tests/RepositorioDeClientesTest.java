package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Cliente;
import repositories.RepositorioDeUsuarios;;

public class RepositorioDeClientesTest {

	@Test
	public void persistirEnMemoria() {
		// Arrange
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		// Act
		RepositorioDeUsuarios.getInstance().setUsuarios(clientes);
		
		// Assert
		assertEquals(2, RepositorioDeUsuarios.getInstance().getUsuarios().size());
	}

}
