package com.socratesdiaz.manejadoreventos.core;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CustomSelectionListener implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(e.getSource().getClass().getName());
		
	}

}
