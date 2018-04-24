package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Administrador {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String numeroIdentificacion;
	private LocalDate fechaAlta;


	public Administrador() {
		super();
	}
	
	/**
	 * Informa la cantidad de meses que este administrador lleva ocupando ese rol.
	 * @return La cantidad de meses.
	 */
	public long mesesSiendoAdministrador()
	{
		return Period.between(this.fechaAlta, LocalDate.now()).toTotalMonths();
	}
}
