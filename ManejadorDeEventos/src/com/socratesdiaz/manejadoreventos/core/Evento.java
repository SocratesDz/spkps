package com.socratesdiaz.manejadoreventos.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {

	private int id;
	private String nombre;
	private String descripcion;
	private int precio;
	private Date date;
	
	public Evento(int id, String nombre, String descripcion, Date date, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.date = date;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getFecha() {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public String getHora() {
		return new SimpleDateFormat("hh:mm:ss").format(date);
	}
	
	public String toString() {
		return descripcion;
	}
	
}
