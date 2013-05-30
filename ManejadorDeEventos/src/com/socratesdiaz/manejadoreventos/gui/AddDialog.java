package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import java.awt.Dialog.ModalityType;
import javax.swing.border.LineBorder;

import com.socratesdiaz.manejadoreventos.control.MainController;

import java.awt.Color;

public class AddDialog extends JDialog {
	private JTextField textFieldName;
	private JTextField textFieldEdad;
	private JTextField textFieldTickets;
	private JComboBox comboBoxEvents;
	private JTextField textFieldLastName;
	private JLabel lblBoletas;
	private JLabel labelPrice;
	private JComboBox sexComboBox;

	public AddDialog(JFrame parent, MainController control) {
		super(parent);
		setTitle("Agregar");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setBounds(100, 100, 450, 318);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Introduzca la informaci\u00F3n del nuevo cliente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{10, 88, 122, 107, 146, 0};
			gbl_panel.rowHeights = new int[]{33, 27, 0, 0, 27, 27, 27, 15, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			panel.add(lblNombre, gbc_lblNombre);
			
			textFieldName = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 2;
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.anchor = GridBagConstraints.NORTH;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			panel.add(textFieldName, gbc_textField);
			textFieldName.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido:");
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.anchor = GridBagConstraints.WEST;
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 1;
			gbc_lblApellido.gridy = 2;
			panel.add(lblApellido, gbc_lblApellido);
			
			textFieldLastName = new JTextField();
			GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
			gbc_textFieldLastName.gridwidth = 2;
			gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldLastName.gridx = 2;
			gbc_textFieldLastName.gridy = 2;
			panel.add(textFieldLastName, gbc_textFieldLastName);
			textFieldLastName.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo:");
			GridBagConstraints gbc_lblSexo = new GridBagConstraints();
			gbc_lblSexo.anchor = GridBagConstraints.WEST;
			gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSexo.gridx = 1;
			gbc_lblSexo.gridy = 3;
			panel.add(lblSexo, gbc_lblSexo);
			
			sexComboBox = new JComboBox();
			GridBagConstraints gbc_sexComboBox = new GridBagConstraints();
			gbc_sexComboBox.insets = new Insets(0, 0, 5, 5);
			gbc_sexComboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_sexComboBox.gridx = 2;
			gbc_sexComboBox.gridy = 3;
			panel.add(sexComboBox, gbc_sexComboBox);
			sexComboBox.addItem("M");
			sexComboBox.addItem("F");
			
			JLabel lblEdad = new JLabel("Edad:");
			GridBagConstraints gbc_lblEdad = new GridBagConstraints();
			gbc_lblEdad.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
			gbc_lblEdad.gridx = 1;
			gbc_lblEdad.gridy = 4;
			panel.add(lblEdad, gbc_lblEdad);
			
			textFieldEdad = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.anchor = GridBagConstraints.NORTH;
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 4;
			panel.add(textFieldEdad, gbc_textField_1);
			textFieldEdad.setColumns(10);
			
			JLabel lblCantBoletas = new JLabel("Cant. boletas:");
			GridBagConstraints gbc_lblCantBoletas = new GridBagConstraints();
			gbc_lblCantBoletas.anchor = GridBagConstraints.WEST;
			gbc_lblCantBoletas.insets = new Insets(0, 0, 5, 5);
			gbc_lblCantBoletas.gridx = 1;
			gbc_lblCantBoletas.gridy = 5;
			panel.add(lblCantBoletas, gbc_lblCantBoletas);
			
			textFieldTickets = new JTextField();
			GridBagConstraints gbc_textFieldTickets = new GridBagConstraints();
			gbc_textFieldTickets.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTickets.anchor = GridBagConstraints.NORTH;
			gbc_textFieldTickets.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldTickets.gridx = 2;
			gbc_textFieldTickets.gridy = 5;
			panel.add(textFieldTickets, gbc_textFieldTickets);
			textFieldTickets.setColumns(10);
			
			JLabel lblEvento = new JLabel("Evento:");
			GridBagConstraints gbc_lblEvento = new GridBagConstraints();
			gbc_lblEvento.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEvento.insets = new Insets(0, 0, 5, 5);
			gbc_lblEvento.gridx = 1;
			gbc_lblEvento.gridy = 6;
			panel.add(lblEvento, gbc_lblEvento);
			
			comboBoxEvents = new JComboBox();
			GridBagConstraints gbc_comboBoxEvents = new GridBagConstraints();
			gbc_comboBoxEvents.gridwidth = 2;
			gbc_comboBoxEvents.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxEvents.anchor = GridBagConstraints.NORTH;
			gbc_comboBoxEvents.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxEvents.gridx = 2;
			gbc_comboBoxEvents.gridy = 6;
			panel.add(comboBoxEvents, gbc_comboBoxEvents);
			
			lblBoletas = new JLabel("Boletas: ");
			GridBagConstraints gbc_lblBoletas = new GridBagConstraints();
			gbc_lblBoletas.anchor = GridBagConstraints.WEST;
			gbc_lblBoletas.insets = new Insets(0, 0, 5, 0);
			gbc_lblBoletas.gridx = 4;
			gbc_lblBoletas.gridy = 6;
			//panel.add(lblBoletas, gbc_lblBoletas);
			
			JLabel lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.NORTH;
			gbc_lblPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrecio.gridx = 1;
			gbc_lblPrecio.gridy = 7;
			panel.add(lblPrecio, gbc_lblPrecio);
			
			labelPrice = new JLabel("$ ...");
			GridBagConstraints gbc_labelPrice = new GridBagConstraints();
			gbc_labelPrice.anchor = GridBagConstraints.NORTH;
			gbc_labelPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_labelPrice.insets = new Insets(0, 0, 0, 5);
			gbc_labelPrice.gridx = 2;
			gbc_labelPrice.gridy = 7;
			panel.add(labelPrice, gbc_labelPrice);
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Procesar");
		panel.add(btnNewButton);
		btnNewButton.setName("addDialogNewEntry");
		btnNewButton.addActionListener(control);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		btnCancelar.setName("addDialogCancel");
		btnCancelar.addActionListener(control);
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldEdad() {
		return textFieldEdad;
	}

	public JTextField getTextFieldTickets() {
		return textFieldTickets;
	}

	public JComboBox getComboBoxEvents() {
		return comboBoxEvents;
	}

	public JLabel getLblBoletas() {
		return lblBoletas;
	}

	public JLabel getLabelPrice() {
		return labelPrice;
	}

	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}
	
	public String getSexValue() {
		return (String)sexComboBox.getSelectedItem();
	}
	
	public String getEventComboBoxValue() {
		return (String)comboBoxEvents.getSelectedItem();
	}
}
