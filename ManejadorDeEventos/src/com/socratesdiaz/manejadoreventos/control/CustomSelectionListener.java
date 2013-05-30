package com.socratesdiaz.manejadoreventos.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListSelectionModel;

import com.socratesdiaz.manejadoreventos.gui.AdminEventsGui;

public class CustomSelectionListener implements ListSelectionListener {

	private AdminEventsGui adminGui;
	private EventTableModel model;
	
	public CustomSelectionListener(AdminEventsGui adminGui) {
		this.adminGui = adminGui;
		model = (EventTableModel)adminGui.getTable().getModel();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int selectedRow = ((DefaultListSelectionModel) e.getSource()).getMinSelectionIndex();
		if(selectedRow < 0) {
			adminGui.getEditButton().setEnabled(false);
			adminGui.getDeleteButton().setEnabled(false);
			return;
		}
		
		try {
			adminGui.getTextFieldName().setText((String) model.getValueAt(selectedRow, 1));
			adminGui.getTextAreaDescription().setText((String) model.getValueAt(selectedRow, 2));
			adminGui.setSpinnersDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(((String)model.getValueAt(selectedRow, 3))+" "+
					((String)model.getValueAt(selectedRow, 4))));
			adminGui.getTextFieldPrice().setText(((Integer) model.getValueAt(selectedRow, 5)).toString());
			adminGui.getEditButton().setEnabled(true);
			adminGui.getDeleteButton().setEnabled(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
