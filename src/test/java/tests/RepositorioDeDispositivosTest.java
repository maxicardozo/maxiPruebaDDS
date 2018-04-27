package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import model.Dispositivo;
import repositories.RepositorioDeDispositivos;
import repositories.RepositorioDeUsuarios;

public class RepositorioDeDispositivosTest {
	
	List<Dispositivo> dispositivos;
	
	Dispositivo dispositivo1;
	Dispositivo dispositivo2;
	
	@Before
	public void setUp() {	
		
		dispositivos = new ArrayList<Dispositivo>();
		
		dispositivo1 = new Dispositivo();
		dispositivo2 = new Dispositivo();

	}
	
	@After
    public void tearDown() {
		RepositorioDeDispositivos.getInstance().getDispositivos().clear();
	}

	@Test
	public void persistirEnMemoria() {
		// Arrange				
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		
		// Act
		RepositorioDeDispositivos.getInstance().setDispositivos(dispositivos);
		
		// Assert
		assertEquals(2, RepositorioDeDispositivos.getInstance().getDispositivos().size());
	}

}
