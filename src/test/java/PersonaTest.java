import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest 
{
	@Test
	public void PersonaSaluda() 
	{
		Persona nuevaPersona = new Persona();
		
		assertEquals("Hola JUnit!", nuevaPersona.saludar());
	}
}
