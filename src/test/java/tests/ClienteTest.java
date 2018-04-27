package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Cliente;
import model.Dispositivo;

public class ClienteTest {

	@Test
	public void tieneAlMenosUnDispositivo_DevuelveTrue() {
		// Arrange
		boolean esperado = true;
		Cliente cliente = new Cliente();
		Dispositivo dispositivoEncendido = new Dispositivo();
		dispositivoEncendido.setEncendido(true);
		
		Dispositivo dispositivoApagado = new Dispositivo();
		dispositivoApagado.setEncendido(false);
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado);
		
		// Act
		boolean obtenido = cliente.tieneDispositivoEncendido();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneAlMenosUnDispositivo_DevuelveFalse() {
		// Arrange
		boolean esperado = false;
		Cliente cliente = new Cliente();
		Dispositivo dispositivoApagado1 = new Dispositivo();
		dispositivoApagado1.setEncendido(false);
		
		Dispositivo dispositivoApagado2 = new Dispositivo();
		dispositivoApagado2.setEncendido(false);
		
		cliente.getDispositivos().add(dispositivoApagado1);
		cliente.getDispositivos().add(dispositivoApagado2);
		
		// Act
		boolean obtenido = cliente.tieneDispositivoEncendido();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void cantidadDeDispositivos_DevuelveTamanioCorrecto() {
		// Arrange
		long esperado = 2;
		Cliente cliente = new Cliente();
		Dispositivo dispositivo1 = new Dispositivo();
		Dispositivo dispositivo2 = new Dispositivo();
		
		cliente.getDispositivos().add(dispositivo1);
		cliente.getDispositivos().add(dispositivo2);
		
		// Act
		long obtenido = cliente.cantidadDispositivos();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneUnDispositivoEncendido_DevuelveCantidadCorrecta() {
		// Arrange
		long esperado = 1;
		Cliente cliente = new Cliente();
		Dispositivo dispositivoEncendido = new Dispositivo();
		dispositivoEncendido.setEncendido(true);
		
		Dispositivo dispositivoApagado = new Dispositivo();
		dispositivoApagado.setEncendido(false);
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado);
		
		// Act
		long obtenido = cliente.cantidadDispositivosEncendidos();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneDosDispositivosApagados_DevuelveCantidadCorrecta() {
		// Arrange
		long esperado = 2;
		Cliente cliente = new Cliente();
		Dispositivo dispositivoEncendido = new Dispositivo();
		dispositivoEncendido.setEncendido(false);
		
		Dispositivo dispositivoApagado = new Dispositivo();
		dispositivoApagado.setEncendido(false);
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado);
		
		// Act
		long obtenido = cliente.cantidadDispositivosApagados();
		
		// Assert
		assertEquals(esperado, obtenido);
	}

}
