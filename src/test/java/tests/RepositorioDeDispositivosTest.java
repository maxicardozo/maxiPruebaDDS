package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Dispositivo;
import repositories.RepositorioDeDispositivos;

public class RepositorioDeDispositivosTest {

	@Test
	public void persistirEnMemoria() {
		// Arrange
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Dispositivo dispositivo1 = new Dispositivo();
		Dispositivo dispositivo2 = new Dispositivo();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		
		// Act
		RepositorioDeDispositivos.getInstance().setDispositivos(dispositivos);
		
		// Assert
		assertEquals(2, RepositorioDeDispositivos.getInstance().getDispositivos().size());
	}

}
