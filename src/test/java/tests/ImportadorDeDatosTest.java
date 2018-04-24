package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.CategoriaEnum;
import model.Cliente;
import model.Dispositivo;
import utils.ImportadorDeDatos;
import utils.ManejadorDeArchivos;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

public class ImportadorDeDatosTest {

	@Test
	public void ImportadorDeDatos_deserializaCliente() {
		// Arrange
		ManejadorDeArchivos manejador = mock(ManejadorDeArchivos.class);
		ImportadorDeDatos importador = new ImportadorDeDatos(manejador);

		String contenidoJSON = "{\"clientes\": ["
			+ "{\"nombre\": \"Juan\","
			+ "\"apellido\": \"Quinteros\","
			+ "\"tipoDocumento\": \"DNI\","
			+ "\"numeroDocumento\": \"36159783\","
			+ "\"telefono\": \"41111111\","
			+ "\"domicilio\": \"Calle Falsa 123\","
			+ "\"fechaAlta\": \"1991-10-14\","
			+ "\"categoria\": \"R1\""
			+ "}]}";

		// Act
		when(manejador.leerArchivo(anyString())).thenReturn(contenidoJSON);
		List<Cliente> clientesObtenidos = importador.importarRepositorioDeUsuarios("C:/alguna_ruta_que_sea_posta");

		// Assert
		assertEquals(1, clientesObtenidos.size());
		assertEquals("Juan", clientesObtenidos.get(0).getNombre());
		assertEquals("Quinteros", clientesObtenidos.get(0).getApellido());
		assertEquals("DNI", clientesObtenidos.get(0).getTipoDocumento());
		assertEquals("36159783", clientesObtenidos.get(0).getNumeroDocumento());
		assertEquals("41111111", clientesObtenidos.get(0).getTelefono());
		assertEquals("Calle Falsa 123", clientesObtenidos.get(0).getDomicilio());
		assertTrue(clientesObtenidos.get(0).getFechaAlta().equals(LocalDate.of(1991, 10, 14)));
		assertEquals(CategoriaEnum.R1, clientesObtenidos.get(0).getCategoria());
	}

	@Test
	public void ImportadorDeDatos_deserializaDispositivo() {
		// Arrange
		ManejadorDeArchivos manejador = mock(ManejadorDeArchivos.class);
		ImportadorDeDatos importador = new ImportadorDeDatos(manejador);
		String contenidoJSON = "{\"dispositivos\": ["
			+ "{\"nombreGenerico\": \"Pava electrica\","
			+ "\"kWHora\": 5,"
			+ "\"encendido\": true"
			+ "}]}";

		// Act
		when(manejador.leerArchivo(anyString())).thenReturn(contenidoJSON);
		List<Dispositivo> dispositivosObtenidos = importador.importarRepositorioDeDispositivos("C:/alguna_ruta_que_sea_posta");

		// Assert
		assertEquals(1, dispositivosObtenidos.size());
		assertEquals("Pava electrica", dispositivosObtenidos.get(0).getNombreGenerico());
		assertEquals((double) 5, dispositivosObtenidos.get(0).getkWHora(), 0.01);
		assertTrue(dispositivosObtenidos.get(0).estaEncendido());
	}


}
