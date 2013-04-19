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

import com.socratesdiaz.manejadoreventos.core.CustomSelectionListener;
import com.socratesdiaz.manejadoreventos.core.DBManager;
import com.socratesdiaz.manejadoreventos.core.EventTableModel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;

public class AdminEventsGui extends JDialog {
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTable tableEvents;
	private JTextArea textAreaDescription;

	/**
	 * Create the dialog.
	 */
	public AdminEventsGui(Frame parent, Controller control, DBManager dbManager) {
		super(parent);
		setBounds(100, 100, 606, 446);
		getContentPane().setLayout(null);
		SpinnerDateModel dateSpinnerModel = new SpinnerDateModel();
		Date date = new Date();
		
		JPanel panel_1 = new JPanel();
		
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 12, 99, 135);
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(3, 0, 0, 20));
		
			JButton btnAadir = new JButton("Añadir");
			panel.add(btnAadir);
			btnAadir.setName("adminEventsAddButton");
			btnAadir.addActionListener(control);
		
			JButton btnEditar = new JButton("Editar");
			panel.add(btnEditar);
			btnEditar.setName("adminEventsEditButton");
			btnEditar.addActionListener(control);
		
			JButton btnBorrar = new JButton("Borrar");
			panel.add(btnBorrar);
			btnBorrar.setName("adminEventsDeleteButton");
			btnBorrar.addActionListener(control);
		}
		
		{
			
			panel_1.setBounds(123, 12, 469, 133);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
		
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(7, 7, 60, 15);
			panel_1.add(lblNombre);
		
			textFieldName = new JTextField();
			textFieldName.setBounds(95, 5, 114, 19);
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
		
			JSpinner daySpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(daySpinner);
			daySpinner.setEditor(new JSpinner.DateEditor(daySpinner, "dd"));
			((SpinnerDateModel)daySpinner.getModel()).setCalendarField(Calendar.DAY_OF_MONTH);
			daySpinner.setName("adminEventsDaySpinner");
		
			JLabel label = new JLabel("/");
			panel_2.add(label);
		
			JSpinner monthSpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(monthSpinner);
			monthSpinner.setEditor(new JSpinner.DateEditor(monthSpinner, "MM"));
			((SpinnerDateModel)monthSpinner.getModel()).setCalendarField(Calendar.MONTH);
			monthSpinner.setName("adminEventsMonthSpinner");
		
			JLabel label_1 = new JLabel("/");
			panel_2.add(label_1);
		
			JSpinner yearSpinner = new JSpinner(new SpinnerDateModel());
			panel_2.add(yearSpinner);
			yearSpinner.setEditor(new JSpinner.DateEditor(yearSpinner, "yyyy"));
			((SpinnerDateModel)yearSpinner.getModel()).setCalendarField(Calendar.YEAR);
			yearSpinner.setName("adminEventsYearSpinner");
			
			Box horizontalBox_1 = Box.createHorizontalBox();
			panel_2.add(horizontalBox_1);
		
			JLabel lblHora = new JLabel("Hora:");
			panel_2.add(lblHora);
		
			JSpinner hourSpinner = new JSpinner(new SpinnerDateModel());
			hourSpinner.setName("adminEventsHourSpinner");
			hourSpinner.setEditor(new JSpinner.DateEditor(hourSpinner, "hh"));
			((SpinnerDateModel)hourSpinner.getModel()).setCalendarField(Calendar.HOUR_OF_DAY);
			panel_2.add(hourSpinner);
		
			JLabel label_2 = new JLabel(":");
			panel_2.add(label_2);
		
			JSpinner minuteSpinner = new JSpinner(new SpinnerDateModel());
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
			model.addListSelectionListener(new CustomSelectionListener());
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
}
