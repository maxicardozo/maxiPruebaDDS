package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import model.Dispositivo;

public class ClienteTest {
	
	Cliente cliente;
	
	Dispositivo dispositivoEncendido;
	Dispositivo dispositivoApagado;
	Dispositivo dispositivoApagado1;
	Dispositivo dispositivoApagado2;
	
	@Before
	public void setUp() {	
		
		cliente = new Cliente();
		
		dispositivoEncendido = new Dispositivo();
		dispositivoApagado = new Dispositivo();
		dispositivoApagado1 = new Dispositivo();
		dispositivoApagado2 = new Dispositivo();

	}

	@Test
	public void tieneAlMenosUnDispositivo_DevuelveTrue() {
		// Arrange
		boolean esperado = true;		
		dispositivoEncendido.setEncendido(true);
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
		dispositivoApagado1.setEncendido(false);			
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
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado);
		
		// Act
		long obtenido = cliente.cantidadDispositivos();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneUnDispositivoEncendido_DevuelveCantidadCorrecta() {
		// Arrange
		long esperado = 1;		
		dispositivoEncendido.setEncendido(true);			
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
		dispositivoEncendido.setEncendido(false);
		dispositivoApagado.setEncendido(false);
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado);
		
		// Act
		long obtenido = cliente.cantidadDispositivosApagados();
		
		// Assert
		assertEquals(esperado, obtenido);
	}

}
