package com.socratesdiaz.manejadoreventos.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.socratesdiaz.manejadoreventos.core.Evento;
import com.socratesdiaz.manejadoreventos.gui.AdminEventsGui;

public class AdminEventsControl implements ActionListener {

	private AdminEventsGui gui;
	
	public AdminEventsControl() {
		
	}
	
	public void setGUI(AdminEventsGui gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		Component comp = (Component) ev.getSource();
		
		if(comp.getName().equals("adminEventsAddButton")) {
			gui.setPanel("panelAdding");
			gui.clearAllFields();
		}
		if(comp.getName().equals("adminEventsEditButton")) {
			gui.setPanel("panelEditing");
			if(gui.checkFields()) {
				// TODO: Editar objetos de la tabla
				// Tomar un objeto del vector que está en el model y editar sus atributos
				// Buscar la forma de hacer un update a la tabla de eventos
			}
		}
		if(comp.getName().equals("adminEventsDeleteButton")) {
			((EventTableModel)gui.getTable().getModel()).removeItem(
					gui.getTable().getSelectedRow());
			gui.clearAllFields();
		}
		if(comp.getName().equals("adminEventsAddingModeAddButton")) {
			if(gui.checkFields()) {
				((EventTableModel)gui.getTable().getModel()).addNewItem(createEvent());
			}
			else {
				JOptionPane.showMessageDialog(gui, "Escriba los datos correctamente", "Error", JOptionPane.WARNING_MESSAGE);
			}
			gui.setPanel("panelNormal");
			
		}
		if(comp.getName().equals("adminEventsClearButton")) {
			gui.clearAllFields();
		}
		if(comp.getName().equals("adminEventsCancelButton")) {
			gui.setPanel("panelNormal");
		}
		if(comp.getName().equals("adminEventsEditingModeModifyButton")) {
			
		}
		
	}
	
	public Evento createEvent() {
		int id = ((int) gui.getTable().getModel().getValueAt(gui.getTable().getModel().getRowCount()-1, 0))+1;
		String name = gui.getTextFieldName().getText();
		String desc = gui.getTextAreaDescription().getText();
		int precio = Integer.valueOf(gui.getTextFieldPrice().getText());
		Date date = gui.getSpinnersDate();
		
		return new Evento(id, name, desc, date, precio);
	}

}
