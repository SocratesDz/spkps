package com.socratesdiaz.manejadoreventos.control;

import java.util.Vector;

import javax.swing.AbstractListModel;

import com.socratesdiaz.manejadoreventos.core.DataQueryItem;

public class DataQueryListModel extends AbstractListModel {

	private Vector<DataQueryItem> data;
	
	public DataQueryListModel() {
		data = new Vector<DataQueryItem>();
	}
	
	public void addElement(Object obj) {
		data.add((DataQueryItem)obj);
		this.fireContentsChanged(this, 0, data.size()-1);
	}
	
	public void removeItem(int index) {
		data.remove(index);
		this.fireContentsChanged(this, 0, data.size()-1);
	}
	
	@Override
	public Object getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	
}
