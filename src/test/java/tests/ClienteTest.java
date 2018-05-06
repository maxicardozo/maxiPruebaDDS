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
	Dispositivo dispositivoApagado1;
	Dispositivo dispositivoApagado2;
	
	@Before
	public void setUp() {	
		
		cliente = new Cliente(null, null, null, null, null, null, null, null);
		//cliente = new Cliente(null, null, null, null, null, null, null, null, null);
		
		dispositivoEncendido = new Dispositivo(null,100,true);
		dispositivoApagado1 = new Dispositivo(null,50,false);
		dispositivoApagado2 = new Dispositivo(null,10,false);

	}

	@Test
	public void tieneAlMenosUnDispositivo_DevuelveTrue() {
		// Arrange
		boolean esperado = true;		
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado1);
		
		// Act
		boolean obtenido = cliente.tieneDispositivoEncendido();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneAlMenosUnDispositivo_DevuelveFalse() {
		// Arrange
		boolean esperado = false;				
	
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
		cliente.getDispositivos().add(dispositivoApagado1);
		
		// Act
		long obtenido = cliente.cantidadDispositivos();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneUnDispositivoEncendido_DevuelveCantidadCorrecta() {
		// Arrange
		long esperado = 1;		
		
		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado1);
		
		// Act
		long obtenido = cliente.cantidadDispositivosEncendidos();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void tieneDosDispositivosApagados_DevuelveCantidadCorrecta() {
		// Arrange
		long esperado = 2;		
		
		cliente.getDispositivos().add(dispositivoApagado1);
		cliente.getDispositivos().add(dispositivoApagado2);
		
		// Act
		long obtenido = cliente.cantidadDispositivosApagados();
		
		// Assert
		assertEquals(esperado, obtenido);
	}

	@Test
	public void consumo_Devuelve160_CuandoSeLePasan3DispositivosCon160kwhEnTotal() {
		// Arrange
		long esperado = 160;		

		cliente.getDispositivos().add(dispositivoEncendido);
		cliente.getDispositivos().add(dispositivoApagado1);
		cliente.getDispositivos().add(dispositivoApagado2);
		
		// Act
		long obtenido = (long) cliente.consumo();
		
		// Assert
		assertEquals(esperado, obtenido);
	}
}