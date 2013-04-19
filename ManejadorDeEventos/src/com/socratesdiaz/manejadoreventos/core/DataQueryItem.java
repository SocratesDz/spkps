package com.socratesdiaz.manejadoreventos.core;


public class DataQueryItem {
	
	private int id;
	private String action;
	private String evento;
	private String queryStatement;
	private String[] columnNames;
	
	public DataQueryItem(int id) {
		this.id = id;
		this.action = QueryCodes.DESCRIPTION[id];
		queryStatement = QueryCodes.CODES[id];
		setColumnNames();
	}
	
	public DataQueryItem(int id, String action) {
		this(id);
		this.setAction(action);
	}
	
	public DataQueryItem(int id, String action, String evento) {
		this(id, action);
		this.setEvento(evento);
	}
	
	public void setId(int id) {
		this.id = id;
		setAction(QueryCodes.DESCRIPTION[id]);
		createQueryStatement();
	}
	
	public void setEvento(String evento) {
		this.evento = evento;  
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public void createQueryStatement() {
		queryStatement = QueryCodes.CODES[id];
	}
	
	public void setColumnNames() {
		columnNames = QueryCodes.COLUMN_QUERY_NAMES[id];
	}
	
	public String getAction() {
		return action;
	}
	
	public String getEvento() {
		return evento;
	}
	
	public String getQueryStatement() {
		return queryStatement;
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	
	@Override
	public String toString() {
		return action;
	}
}
