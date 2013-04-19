package com.socratesdiaz.manejadoreventos.core;

public class Portero extends Usuario {
	
	public Portero(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
		this.tipo = "Portero";
		this.setCreationDate();
	}
}
