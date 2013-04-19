package com.socratesdiaz.manejadoreventos.core;

public final class QueryCodes {

	public static final int MAX_PEOPLE_IN_EVENT = 0;
	public static final int MAX_FEMALES_IN_EVENT = 1;
	public static final int MIN_PEOPLE_IN_EVENT = 2;
	
	public static final String[] DESCRIPTION = {
		"Mayor cantidad de personas en un evento",
		"Mayor cantidad de mujeres en un evento",
		"Menor cantidad de personas en un evento"
	};
	
	public static final String[] CODES = {
		"", // TODO: Mayor cantidad de personas en evento
		
		// Mayor cantidad de mujeres en un evento
		"SELECT Cliente.Nombre, Cliente.Apellido, Cliente.Edad, Eventos.Nombre, Eventos.Fecha, Eventos.Hora" +
		" from el_real_proyecto.Cliente, el_real_proyecto.Reservacion, el_real_proyecto.Eventos where" +
		" (Sexo = 'F' && Reservacion.EventoID = Eventos.ID" +
		" && Reservacion.ClienteID = Cliente.ID && Eventos.Nombre = ?)",
		
		"" // TODO: Menor cantidad de personas en evento
	};
	
	public static final String[][] COLUMN_QUERY_NAMES = {
		{""},
		{"Nombre", "Apellido", "Edad", "Nombre del Evento", "Fecha", "Hora"},
		{""}
	};
}
