package com.socratesdiaz.manejadoreventos.core;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class DataQueryTableModel extends AbstractTableModel {

	private String[] columnNames = { "Item a reportar", "Evento" };
	private Vector<DataQueryItem> data;
	
	public DataQueryTableModel() {
		super();
		data = new Vector<DataQueryItem>();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		switch(col) {
		case 0:
			return data.get(row).getAction();
		case 1:
			return data.get(row).getEvento();
		default:
			return "";
		}
	}
	
	public void addItem(DataQueryItem item) {
		data.add(item);
		fireTableDataChanged();
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void removeItem(int index) {
		if(index < 0) return;
		data.remove(index);
		fireTableDataChanged();
	}

	public void removeAllItems() {
		data.removeAllElements();
		fireTableDataChanged();
	}
	
	public Vector<DataQueryItem> getVectorData() {
		
		return data;
	}

}
