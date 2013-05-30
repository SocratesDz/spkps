package com.socratesdiaz.manejadoreventos.control;

import java.util.Vector;

import javax.swing.AbstractListModel;

import com.socratesdiaz.manejadoreventos.core.DataQueryItem;
import com.socratesdiaz.manejadoreventos.core.Evento;

public class EventListModel extends AbstractListModel {
	
	private Vector<Evento> data;
	
	public EventListModel() {
		data = new Vector<Evento>();
	}
	
	public void addElement(Object obj) {
		data.add((Evento)obj);
		this.fireContentsChanged(this, 0, data.size()-1);
	}
	
	public void removeItem(int index) {
		data.remove(index);
		this.fireContentsChanged(this, 0, data.size()-1);
	}
	
	@Override
	public Evento getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

}
