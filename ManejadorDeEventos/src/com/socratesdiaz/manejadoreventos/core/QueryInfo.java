package com.socratesdiaz.manejadoreventos.core;

public class QueryInfo {
	
	private int id;
	private String nombreCliente;
	private String apellidoCliente;
	private char sex;
	private int edad;
	private int ticketsQuantity;
	private int price;
	
	
	public QueryInfo(int id, String nombreCliente, String apellidoCliente,
			 char sex, int edad, int ticketsQuantity, int price) {
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.sex = sex;
		this.edad = edad;
		this.ticketsQuantity = ticketsQuantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public int getEdad() {
		return edad;
	}
	public int getTicketsQuantity() {
		return ticketsQuantity;
	}
	public int getPrice() {
		return price;
	}
	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setTicketsQuantity(int ticketsQuantity) {
		this.ticketsQuantity = ticketsQuantity;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
