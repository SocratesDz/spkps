package com.socratesdiaz.manejadoreventos.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;

public class ComponentDataFiller {
	
	public static void fillItemComboBox(JComboBox combo) {
		DataQueryItem[] dataArray = new DataQueryItem[QueryCodes.CODES.length];
		for(int i = 0; i < QueryCodes.CODES.length; i++) {
			dataArray[0] = new DataQueryItem(i);
		}
		
		combo = new JComboBox(dataArray);
	}

	public static void fillItemEventComboBox(JComboBox combo, DBManager dbmanager) {
		if(!dbmanager.isConnection()) return;
		
		// Eliminando lo que está en el combobox
		combo.removeAllItems();
		
		Vector<String> eventsName = new Vector<String>();
		dbmanager.executeQuery("select Eventos.Nombre from el_real_proyecto.Eventos");
		ResultSet result = dbmanager.getResult();
		
		try {
			
			while(result.next()) {
				eventsName.add(result.getString(1));
				combo.addItem(result.getString(1));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
	}
}
