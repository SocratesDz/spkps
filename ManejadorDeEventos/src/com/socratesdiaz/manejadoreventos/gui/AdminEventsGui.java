package com.socratesdiaz.manejadoreventos.gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.Box;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import com.socratesdiaz.manejadoreventos.control.AdminEventsControl;
import com.socratesdiaz.manejadoreventos.control.MainController;
import com.socratesdiaz.manejadoreventos.control.CustomSelectionListener;
import com.socratesdiaz.manejadoreventos.control.EventTableModel;
import com.socratesdiaz.manejadoreventos.database.DBManager;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.awt.CardLayout;
import javax.swing.ScrollPaneConstants;

public class AdminEventsGui extends JDialog {
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTable tableEvents;
	private JTextArea textAreaDescription;
	
	private JSpinner daySpinner;
	private JSpinner monthSpinner;
	private JSpinner yearSpinner;
	private JSpinner hourSpinner;
	private JSpinner minuteSpinner;
	
	private JPanel panelLateral;
	private JButton btnAadir;
	private JButton btnEditar;
	private JButton btnBorrar;
	
	private CardLayout layout;

	
	public AdminEventsGui(Frame parent, AdminEventsControl control, DBManager dbManager) {
		super(parent);
		setBounds(100, 100, 606, 446);
		getContentPane().setLayout(null);
		SpinnerDateModel dateSpinnerModel = new SpinnerDateModel();
		//Date date = new Date();
		layout = new CardLayout(0, 0); 
		
		JPanel panel_1 = new JPanel();
		
		panelLateral = new JPanel();
		panelLateral.setBounds(12, 12, 99, 135);
		getContentPane().add(panelLateral);
		panelLateral.setLayout(layout);
		
		{
			JPanel panelNormal = new JPanel();
			panelLateral.add(panelNormal, "panelNormal");
			panelNormal.setLayout(new GridLayout(0, 1, 0, 20));
		
			btnAadir = new JButton("Añadir");
			panelNormal.add(btnAadir);
			btnAadir.setName("adminEventsAddButton");
			btnAadir.addActionListener(control);
		
			btnEditar = new JButton("Editar");
			panelNormal.add(btnEditar);
			btnEditar.setName("adminEventsEditButton");
			btnEditar.setEnabled(false);
			btnEditar.addActionListener(control);
		
			btnBorrar = new JButton("Borrar");
			panelNormal.add(btnBorrar);
			btnBorrar.setName("adminEventsDeleteButton");
			btnBorrar.setEnabled(false);
			btnBorrar.addActionListener(control);
		}
		
		{
			JPanel panelAdding = new JPanel();
			panelLateral.add(panelAdding, "panelAdding");
			panelAdding.setLayout(new GridLayout(0, 1, 0, 20));
			
			JButton btnAgregar = new JButton("Agregar");
			btnAgregar.setName("adminEventsAddingModeAddButton");
			panelAdding.add(btnAgregar);
			btnAgregar.addActionListener(control);
			
			JButton btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setName("adminEventsClearButton");
			panelAdding.add(btnLimpiar);
			btnLimpiar.addActionListener(control);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setName("adminEventsCancelButton");
			panelAdding.add(btnCancelar);
			btnCancelar.addActionListener(control);
		}
		
		{
			JPanel panelEditing = new JPanel();
			panelLateral.add(panelEditing, "panelEditing");
			panelEditing.setLayout(new GridLayout(0, 1, 0, 20));
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setName("adminEventsEditingModeModifyButton");
			panelEditing.add(btnModificar);
			btnModificar.addActionListener(control);
			
			JButton buttonLimpiar2 = new JButton("Limpiar");
			buttonLimpiar2.setName("adminEventsClearButton");
			panelEditing.add(buttonLimpiar2);
			buttonLimpiar2.addActionListener(control);
			
			JButton buttonCancel2 = new JButton("Cancelar");
			buttonCancel2.setName("adminEventsCancelButton");
			panelEditing.add(buttonCancel2);
			buttonCancel2.addActionListener(control);
		}
		
		
		{
			
			panel_1.setBounds(123, 12, 469, 133);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
		
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(7, 7, 60, 15);
			panel_1.add(lblNombre);
		
			textFieldName = new JTextField();
			textFieldName.setBounds(95, 5, 162, 19);
			panel_1.add(textFieldName);
			textFieldName.setColumns(10);
		
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(275, 7, 49, 15);
			panel_1.add(lblPrecio);
		
			textFieldPrice = new JTextField();
			textFieldPrice.setBounds(324, 5, 114, 19);
			panel_1.add(textFieldPrice);
			textFieldPrice.setColumns(10);
		
			JLabel lblDescripcin = new JLabel("Descripción:");
			lblDescripcin.setBounds(7, 34, 95, 15);
			panel_1.add(lblDescripcin);
		
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(95, 36, 229, 58);
			panel_1.add(scrollPane_1);
		
			textAreaDescription = new JTextArea();
			scrollPane_1.setViewportView(textAreaDescription);
		}
		
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(7, 97, 449, 24);
			panel_1.add(panel_2);
		
			JLabel lblFecha = new JLabel("Fecha:");
			panel_2.add(lblFecha);
		
			daySpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(daySpinner);
			daySpinner.setEditor(new JSpinner.DateEditor(daySpinner, "dd"));
			((SpinnerDateModel)daySpinner.getModel()).setCalendarField(Calendar.DAY_OF_MONTH);
			daySpinner.setName("adminEventsDaySpinner");
		
			JLabel label = new JLabel("/");
			panel_2.add(label);
		
			monthSpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(monthSpinner);
			monthSpinner.setEditor(new JSpinner.DateEditor(monthSpinner, "MM"));
			((SpinnerDateModel)monthSpinner.getModel()).setCalendarField(Calendar.MONTH);
			monthSpinner.setName("adminEventsMonthSpinner");
		
			JLabel label_1 = new JLabel("/");
			panel_2.add(label_1);
		
			yearSpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(yearSpinner);
			yearSpinner.setEditor(new JSpinner.DateEditor(yearSpinner, "yyyy"));
			((SpinnerDateModel)yearSpinner.getModel()).setCalendarField(Calendar.YEAR);
			yearSpinner.setName("adminEventsYearSpinner");
			
			Box horizontalBox_1 = Box.createHorizontalBox();
			panel_2.add(horizontalBox_1);
		
			JLabel lblHora = new JLabel("Hora:");
			panel_2.add(lblHora);
		
			hourSpinner = new JSpinner(new SpinnerDateModel());
			hourSpinner.setName("adminEventsHourSpinner");
			hourSpinner.setEditor(new JSpinner.DateEditor(hourSpinner, "hh"));
			((SpinnerDateModel)hourSpinner.getModel()).setCalendarField(Calendar.HOUR_OF_DAY);
			panel_2.add(hourSpinner);
		
			JLabel label_2 = new JLabel(":");
			panel_2.add(label_2);
		
			minuteSpinner = new JSpinner(new SpinnerDateModel());
			minuteSpinner.setName("adminEventsMinuteSpinner");
			panel_2.add(minuteSpinner);
			minuteSpinner.setEditor(new JSpinner.DateEditor(minuteSpinner, "mm"));
			((SpinnerDateModel)minuteSpinner.getModel()).setCalendarField(Calendar.MINUTE);
		
			Box horizontalBox = Box.createHorizontalBox();
			panel_2.add(horizontalBox);
		}
		
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 159, 580, 241);
			getContentPane().add(scrollPane);
		
			tableEvents = new JTable(new EventTableModel(dbManager));
			tableEvents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel model = tableEvents.getSelectionModel();
			model.addListSelectionListener(new CustomSelectionListener(this));
			scrollPane.setViewportView(tableEvents);
		}

	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public JTable getTable() {
		return tableEvents;
	}

	public JTextArea getTextAreaDescription() {
		return textAreaDescription;
	}
	
	public JButton getAddButton() {
		return btnAadir;
	}
	
	public JButton getEditButton() {
		return btnEditar;
	}
	
	public JButton getDeleteButton() {
		return btnBorrar;
	}
	
	public JPanel getButtonsPanel() {
		return panelLateral;
	}
	
	public void setSpinnersDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		daySpinner.setValue(date);
		monthSpinner.setValue(date);
		yearSpinner.setValue(date);
		hourSpinner.setValue(date);
		minuteSpinner.setValue(date);
	}
	
	public Date getSpinnersDate() {
		String dayOfMonth = new SimpleDateFormat("dd").format(((SpinnerDateModel)daySpinner.getModel()).getDate());
		String month = new SimpleDateFormat("MM").format(((SpinnerDateModel)monthSpinner.getModel()).getDate());
		String year = new SimpleDateFormat("yyyy").format(((SpinnerDateModel)yearSpinner.getModel()).getDate());
		String hour = new SimpleDateFormat("hh").format(((SpinnerDateModel)hourSpinner.getModel()).getDate());
		String minute = new SimpleDateFormat("mm").format(((SpinnerDateModel)minuteSpinner.getModel()).getDate());
		
		try {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(year+"-"+month+"-"+dayOfMonth+" "+hour+":"+minute);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setPanel(String panelName) {
		layout.show(panelLateral, panelName);
	}
	
	public void clearAllFields() {
		textFieldName.setText("");
		textFieldPrice.setText("");
		textAreaDescription.setText("");
		setSpinnersDate(new Date(0L));
	}
	
	public boolean checkFields() {
		try {
			Integer.valueOf(textFieldPrice.getText());
			return true;
		}
		catch(InputMismatchException ex) {
			return false;
		}
	}
}
