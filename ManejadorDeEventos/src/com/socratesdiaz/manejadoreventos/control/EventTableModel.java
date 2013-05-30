package com.socratesdiaz.manejadoreventos.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.socratesdiaz.manejadoreventos.core.Evento;
import com.socratesdiaz.manejadoreventos.database.DBManager;

public class EventTableModel extends AbstractTableModel {

	private String[] columnNames = { "ID", "Nombre", "Descripción", "Fecha", "Hora", "PrecioBoleta" };
	private Vector<Evento> eventArray;
	DBManager dbManager;
	
	public EventTableModel(DBManager dbManager) {
		super();
		eventArray = new Vector<Evento>();
		this.dbManager = dbManager;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public int getRowCount() {
		return eventArray.size();
	}
	
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0:
			return (Integer) eventArray.get(row).getId();
		case 1:
			return (String) eventArray.get(row).getNombre();
		case 2:
			return (String) eventArray.get(row).getDescripcion();
		case 3:
			return (String) eventArray.get(row).getFecha();
		case 4:
			return (String) eventArray.get(row).getHora();
		case 5:
			return (Integer) eventArray.get(row).getPrecio();
		default:
			return "";
		}
	}
	
	public void addItem(Evento ev) {
		eventArray.addElement(ev);
		fireTableDataChanged();
	}
	
	public void addNewItem(Evento ev) {
		dbManager.executeUpdate("INSERT INTO el_real_proyecto.Eventos (Eventos.ID, Eventos.Nombre, Eventos.Descripcion, Eventos.Fecha, Eventos.Hora, Eventos.PrecioBoleta)" +
				" VALUES ('"+ev.getId()+"', '"+ev.getNombre() +"', '"+ev.getDescripcion()+"', '"+ev.getFecha()+"', " +
						"'"+ev.getHora()+"', '"+ev.getPrecio()+"')");
		addItem(ev);
		System.out.println(dbManager.getError());
	}
	
	public void editItem() {
		
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void removeItem(int row) {
		
		// TODO: Remover item de la base de datos
		dbManager.executeUpdate("DELETE FROM el_real_proyecto.Eventos WHERE " +
				"(Eventos.ID='"+ eventArray.get(row).getId() +"' && Eventos.Nombre='"+ eventArray.get(row).getNombre() +"')");
		
		eventArray.remove(row);
		
		fireTableDataChanged();
	}
	
	public void repopulateFromDB() {
		if(!dbManager.isConnection()) return;
		eventArray.removeAllElements();
		dbManager.executeQuery("SELECT * FROM el_real_proyecto.Eventos");
		ResultSet result = dbManager.getResult();
		if(!dbManager.getError().equals("")) System.err.println(dbManager.getError());

			try {
				while(result.next()) {
					this.addItem(new Evento(result.getInt(1), result.getString(2), result.getString(3),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(result.getDate(4).toString()+" "+result.getTime(5).toString()),
						result.getInt(6)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
	}
}
