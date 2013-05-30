package com.socratesdiaz.manejadoreventos.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;

import com.socratesdiaz.manejadoreventos.core.DataQueryItem;
import com.socratesdiaz.manejadoreventos.core.Evento;
import com.socratesdiaz.manejadoreventos.core.QueryCodes;
import com.socratesdiaz.manejadoreventos.database.DBManager;

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

	public static void fillItemList(JList eventList, DBManager dbmanager) {
		if(!dbmanager.isConnection()) return;
		
		// Eliminando lo que está en la lista
		eventList.removeAll();
		
		Vector<String> eventsName = new Vector<String>();
		dbmanager.executeQuery("select Eventos.Nombre from el_real_proyecto.Eventos");
		ResultSet result = dbmanager.getResult();
		System.out.println(dbmanager.getError());
		try {
			
			while(result.next()) {
				eventsName.add(result.getString(1));
			}	
			
			eventList.setListData(eventsName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
	}
	
	public static void fillEventList(JList eventList, DBManager dbmanager) {
		if(!dbmanager.isConnection()) return;
		
		// Eliminando lo que está en la lista
		eventList.removeAll();
	
		//Vector<Evento> eventsName = new Vector<Evento>();
		dbmanager.executeQuery("select * from el_real_proyecto.Eventos");
		ResultSet result = dbmanager.getResult();
	
		try {
		
			while(result.next()) {
				Evento evento = new Evento(result.getInt(1), result.getString(2), result.getString(3),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(result.getDate(4).toString()+" "+result.getTime(5).toString()),
						result.getInt(6));
				
				//eventsName.add(evento);
				((EventListModel)eventList.getModel()).addElement(evento);
			}	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
