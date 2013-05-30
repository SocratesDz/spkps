package com.socratesdiaz.manejadoreventos.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.socratesdiaz.manejadoreventos.core.QueryInfo;
import com.socratesdiaz.manejadoreventos.database.DBManager;
import com.socratesdiaz.manejadoreventos.gui.MainWindow;

public class GuestTableModel extends AbstractTableModel {

	private String[] columnNames = { "ID", "Nombre", "Apellido", "Sexo", "Edad", "Cantidad de boletas", "Precio a Pagar" };
	private Vector<QueryInfo> data;
	DBManager dbManager;
	
	public GuestTableModel(DBManager dbManager) {
		data = new Vector<QueryInfo>();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int index) {
		return columnNames[index];
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
			return data.get(row).getId();
		case 1:
			return data.get(row).getNombreCliente();
		case 2:
			return data.get(row).getApellidoCliente();
		case 3:
			return data.get(row).getSex();
		case 4:
			return data.get(row).getEdad();
		case 5:
			return data.get(row).getTicketsQuantity();
		case 6:
			return data.get(row).getPrice();
		default:
			return "";
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void addNewItem(QueryInfo qi) {
		data.add(qi);
		fireTableDataChanged();
		
	}
	
	public void removeAllItems() {
		data.removeAllElements();
		fireTableDataChanged();
	}
}
