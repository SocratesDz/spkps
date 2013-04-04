package com.socratesdiaz.manejadoreventos.core;

public class Administrador extends Usuario {

	public Administrador(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
		this.tipo = "Administrador";
	}
}
