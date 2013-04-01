package com.socratesdiaz.manejadoreventos.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, ChangeListener, KeyListener, WindowListener {

	AddDialog addDialog;
	MainWindow mainWindow;
	ReportMakerGui reportMaker;
	SearchDialog searchDialog;
	ItemsToReportGui itemsToReport;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		addDialog = new AddDialog(mainWindow, this);
		searchDialog = new SearchDialog(mainWindow, this);
		reportMaker = new ReportMakerGui(mainWindow, this);
		itemsToReport = new ItemsToReportGui(reportMaker, this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		Component item_changed = (Component) arg0.getSource();
		
		{ // Controles del diálogo de búsqueda
			if(item_changed.getName().equals("searchDialogViewNamePanel")) {
				
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Component comp = (Component) ev.getSource();
		
		{// Controles de la ventana principal
			
			if(comp.getName().equals("mainHelp")) {
				System.out.println("Mostrar ayuda");
			}
			if(comp.getName().equals("mainExit")) {
				System.exit(0);
			}
			if(comp.getName().equals("mainAdd")) {
				addDialog.setVisible(true);
			}
			if(comp.getName().equals("mainDelete")) {
				System.out.println("Borrar entrada");
			}
			if(comp.getName().equals("mainRefresh")) {
				System.out.println("Actualizar tablas");
			}
			if(comp.getName().equals("mainPrint")) {
				System.out.println("Imprimir reportes");
			}
			if(comp.getName().equals("mainSearch")) {
				searchDialog.setVisible(true);
			}
			if(comp.getName().equals("mainStats")) {
				reportMaker.setVisible(true);
			}
		}
		
		{// Controles del diálogo de añadir
			
			if(comp.getName().equals("addDialogCancel")) {
				addDialog.setVisible(false);
			}
			if(comp.getName().equals("addDialogNewEntry")) {
				// Procesar
				System.out.println("Procesando entrada en la base de datos");
				addDialog.setVisible(false);
			}
		}
		
		{// Controles del diálogo de búsqueda
			
			if(comp.getName().equals("searchDialogSearchButton")) {
				// Buscar
				System.out.println("Buscando...");
				
				// Ocultar ventana
				searchDialog.setVisible(false);
			}
			if(comp.getName().equals("searchDialogCancelButton")) {
				searchDialog.setVisible(false);
			}
		}
		
		{// Controles del diálogo de reportes de estadísticas
			
			if(comp.getName().equals("reportCancelButton")) {
				reportMaker.setVisible(false);
			}
			if(comp.getName().equals("reportGenerate")) {
				// Generar reporte
				System.out.println("Generando reporte...");
				
				// Mostrar visor HTML
				System.out.println("Mostrando visor HTML");
			}
			if(comp.getName().equals("reportAddEntry")) {
				// Añadir entrada a la lista
				System.out.println("Añadiendo entrada a la lista");
				
				itemsToReport.setVisible(true);
			}
			
			if(comp.getName().equals("reportRemoveEntry")) {
				// Remover entrada
				System.out.println("Removiendo entrada de la lista");
			}
		}
		
		{// Controles del diálogo de añadir opciones para reportes
			
			if(comp.getName().equals("itemsReportCancel")) {
				itemsToReport.setVisible(false);
			}
			if(comp.getName().equals("itemsReportAdd")) {
				itemsToReport.setVisible(false);
			}
		}
		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);	// Cerrar el programa
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
