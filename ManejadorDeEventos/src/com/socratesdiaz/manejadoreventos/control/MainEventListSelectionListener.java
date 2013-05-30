package com.socratesdiaz.manejadoreventos.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.Connection;
import com.socratesdiaz.manejadoreventos.core.Evento;
import com.socratesdiaz.manejadoreventos.core.QueryInfo;
import com.socratesdiaz.manejadoreventos.database.DBManager;
import com.socratesdiaz.manejadoreventos.gui.MainWindow;

public class MainEventListSelectionListener implements ListSelectionListener {

	public DBManager dbManager;
	public MainWindow gui;
	
	public MainEventListSelectionListener(MainWindow gui, DBManager dbManager) {
		this.dbManager = dbManager;
		this.gui = gui;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		JList obj = (JList)lse.getSource();
		if(!dbManager.isConnection()) return;
		
		dbManager.executeQuery("select Eventos.Descripcion from el_real_proyecto.Eventos where Eventos.Nombre='"+(String)obj.getSelectedValue()+"'");
		String desc = "";
		try {
			ResultSet result = dbManager.getResult();
			while(result.next()) {
				desc = result.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gui.getLblNombreEvento().setText((String) obj.getSelectedValue());
		gui.getLblDescripcinEvento().setText(desc);
		updateTable();
		//((GuestTableModel)obj.getModel()).updateTable(gui);
		
	}
	
	public void updateTable() {
		
		GuestTableModel model = (GuestTableModel)gui.getGuestTable().getModel();
		String eventName = (String) gui.getEventList().getSelectedValue();
		model.removeAllItems();
		
		Connection con = dbManager.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select Cliente.*, Reservacion.CantidadBoletas, Reservacion.Precio " +
				"from el_real_proyecto.Cliente, el_real_proyecto.Eventos, el_real_proyecto.Reservacion where (Reservacion.ClienteID = Cliente.ID && " +
				"Reservacion.EventoID = Eventos.ID && Eventos.Nombre = '"+eventName+"')");
			while(resultSet.next()) {
				QueryInfo qi;
				qi = new QueryInfo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4).charAt(0), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7));
				model.addNewItem(qi);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
