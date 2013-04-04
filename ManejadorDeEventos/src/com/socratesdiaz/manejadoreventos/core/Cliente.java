package com.socratesdiaz.manejadoreventos.core;

public class Cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	private boolean sexo;
	private int edad;
	
	public Cliente(int id, String nombre, String apellido, boolean sexo,
			int edad) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
