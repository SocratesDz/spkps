package com.socratesdiaz.manejadoreventos.core;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Usuario implements Serializable {
	
	protected String nombre;
	protected String password;
	protected String tipo;
	protected Date creationDate;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTipo() {
		return tipo;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	public String getFormattedDate() {
		return new SimpleDateFormat().format(creationDate);
	}

	public void setCreationDate() {
		this.creationDate = new Date();
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
