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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.socratesdiaz.manejadoreventos.core.ComponentDataFiller;
import com.socratesdiaz.manejadoreventos.core.DBManager;
import com.socratesdiaz.manejadoreventos.core.DataQueryItem;
import com.socratesdiaz.manejadoreventos.core.DataQueryListModel;
import com.socratesdiaz.manejadoreventos.core.DataQueryTableModel;
import com.socratesdiaz.manejadoreventos.core.EventTableModel;
import com.socratesdiaz.manejadoreventos.core.HTMLReportGenerator;
import com.socratesdiaz.manejadoreventos.core.UserManager;
import com.socratesdiaz.manejadoreventos.core.Usuario;

public class Controller implements ActionListener, ChangeListener, KeyListener, WindowListener {

	AddDialog addDialog;
	ItemsToReportGui itemsToReport;
	Login loginWindow;
	MainWindow mainWindow;
	ReportMakerGui reportMaker;
	SearchDialog searchDialog;
	DataQueryTableModel dataQueryTableModel;
	AdminEventsGui adminEvents;
	
	DBManager dbManager;
	Usuario user;
	
	
	public Controller() {
		mainWindow = new MainWindow(this);
		addDialog = new AddDialog(mainWindow, this);
		searchDialog = new SearchDialog(mainWindow, this);
		reportMaker = new ReportMakerGui(mainWindow, this);
		itemsToReport = new ItemsToReportGui(reportMaker, this);
		loginWindow = new Login(mainWindow, this);
		dbManager = new DBManager();
		adminEvents = new AdminEventsGui(mainWindow, this, dbManager);
		dataQueryTableModel = (DataQueryTableModel)reportMaker.getDataQueryTable().getModel();
		
		loginWindow.setVisible(true);
		
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
		JRadioButton item_changed = (JRadioButton) arg0.getSource();
		
		{ // Controles del diálogo de búsqueda
			if(item_changed.getName().equals("searchDialogViewNamePanel")) {
				if(item_changed.isSelected()) searchDialog.setPanel("SearchNamePanel");
			}
			if(item_changed.getName().equals("searchDialogViewEventPanel")) {
				if(item_changed.isSelected()) searchDialog.setPanel("SearchEventPanel");
			}
			if(item_changed.getName().equals("searchDialogViewTicketPanel")) {
				if(item_changed.isSelected()) searchDialog.setPanel("SearchTicketsPanel");
			}
			if(item_changed.getName().equals("searchDialogViewDatePanel")) {
				if(item_changed.isSelected()) searchDialog.setPanel("SearchDatePanel");
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Component comp = (Component) ev.getSource();
		
		{// Controles de la ventana de logueo
			if(comp.getName().equals("Login_OK")) {
				
				// Revisar los campos de texto para ver si están llenos
				// De lo contrario, mostrar un mensaje de error al usuario
				
				if(loginWindow.getUsernameField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(loginWindow, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(loginWindow.getDbusernameField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(loginWindow, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(loginWindow.getDbhostField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(loginWindow, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				// Loguea al usuario
				user = new UserManager(loginWindow.getUsernameField().getText(), new String(loginWindow.getPasswordField().getPassword())).getUser();
				
				if(user != null) {
					mainWindow.setUser(user);
					dbManager.connect(loginWindow.getDbusernameField().getText(), new String(loginWindow.getDbpasswordField().getPassword()),
							loginWindow.getDbhostField().getText());
					
					if(!dbManager.isConnection()) {
						JOptionPane.showMessageDialog(loginWindow, "Error conectando a la base de datos.\nPor favor rellene los campos correctamente" +
								" o contacte a un administrador.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
				}else {
					JOptionPane.showMessageDialog(loginWindow, "Error de autenticación. Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Por razones de seguridad borramos los fields de los passwords
				loginWindow.getPasswordField().setText("");
				loginWindow.getDbpasswordField().setText("");
				
				loginWindow.setVisible(false);
			}
			if(comp.getName().equals("Login_Cancel")) {
				System.out.println("Saliendo");
				loginWindow.setVisible(false);
				
				mainExit();
			}
		}
		
		{// Controles de la ventana principal
			
			if(comp.getName().equals("mainHelp")) {
				System.out.println("Mostrar ayuda");
			}
			if(comp.getName().equals("mainExit")) {
				mainExit();
			}
			if(comp.getName().equals("mainAdd")) {
				ComponentDataFiller.fillItemEventComboBox(addDialog.getComboBoxEvents(), dbManager);
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
			if(comp.getName().equals("mainChangeUser")) {
				loginWindow.setVisible(true);
			}
			if(comp.getName().equals("mainAdminEvents")) {
				((EventTableModel)adminEvents.getTable().getModel()).repopulateFromDB();
				adminEvents.setVisible(true);
			}
			if(comp.getName().equals("mainAdminUsers")) {
				// Muestra la ventana de administración de usuarios
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
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Escriba el nombre del archivo a guardar");
				int rtnval = fileChooser.showSaveDialog(reportMaker);
				if(rtnval == fileChooser.CANCEL_OPTION) return;
				HTMLReportGenerator htmlReport = new HTMLReportGenerator(dbManager);
				try {
					htmlReport.createHTMLFile(dataQueryTableModel.getVectorData(), fileChooser.getSelectedFile());
					JOptionPane.showConfirmDialog(mainWindow, "Reporte generado exitosamente en : '"+fileChooser.getSelectedFile().getAbsolutePath()+"'");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(mainWindow, "No se pudo generar el reporte", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				dataQueryTableModel.removeAllItems();
				
				// Mostrar visor HTML
				//System.out.println("Mostrando visor HTML");
			}
			if(comp.getName().equals("reportAddEntry")) {
				// Añadir entrada a la lista
				
				
				ComponentDataFiller.fillItemComboBox(itemsToReport.getComboBoxDataItem());
				ComponentDataFiller.fillItemEventComboBox(itemsToReport.getComboBoxEventList(), dbManager);
				
				itemsToReport.setVisible(true);
			}
			
			if(comp.getName().equals("reportRemoveEntry")) {
				// Remover entrada
				dataQueryTableModel.removeItem(reportMaker.getDataQueryTable().getSelectedRow());
			}
		}
		
		{// Controles del diálogo de añadir opciones para reportes
			
			if(comp.getName().equals("itemsReportCancel")) {
				itemsToReport.setVisible(false);
			}
			if(comp.getName().equals("itemsReportAdd")) {
				DataQueryItem data = new DataQueryItem(itemsToReport.getComboBoxDataItem().getSelectedIndex());
				data.setEvento((String) itemsToReport.getComboBoxEventList().getSelectedItem());
				
				dataQueryTableModel.addItem(data);
				
				
				itemsToReport.setVisible(false);
			}
		}
		
		{// Controles del diálogo de administrar eventos
			
			if(comp.getName().equals("adminEventsAddButton")) {
				// Agrega lo que está en los textfields a la tabla
				
			}
			if(comp.getName().equals("adminEventsEditButton")) {
				// Si hay un elemento seleccionado, agrega la información de los textfields a la tabla
			}
			if(comp.getName().equals("adminEventsDeleteButton")) {
				// Si hay un elemento seleccionado, se borra de la tabla
			}
			if(comp.getName().equals("adminEventsDaySpinner")) {
				// nothing to do here...
			}
			if(comp.getName().equals("adminEventsMonthSpinner")) {
				// nothing to do here...				
			}
			if(comp.getName().equals("adminEventsYearSpinner")) {
				// nothing to do here...				
			}
			if(comp.getName().equals("adminEventsHourSpinner")) {
				// nothing to do here...				
			}
			if(comp.getName().equals("adminEventsMinuteSpinner")) {
				// nothing to do here...				
			}
			if(comp.getName().equals("adminEventsSecondSpinner")) {
				// nothing to do here...				
			}
		}
		
		{// Controles del diálogo para administrar usuarios
			
			
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
		mainExit();	// Cerrar el programa
		
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
	
	public void mainExit() {
		if(dbManager.isConnection()) dbManager.disconnect();
		System.exit(0);
	}

}
