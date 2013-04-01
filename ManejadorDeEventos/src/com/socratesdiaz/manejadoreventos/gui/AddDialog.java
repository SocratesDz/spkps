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

public class AddDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox textField_2;
	private JTextField textField_3;
	private JComboBox textField_4;

	public AddDialog(JFrame parent, Controller control) {
		super(parent);
		setTitle("Agregar");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setBounds(100, 100, 450, 300);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Introduzca la informaci\u00F3n del nuevo invitado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{59, 88, 33, 122, 146, 0};
			gbl_panel.rowHeights = new int[]{33, 27, 27, 27, 27, 25, 15, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			panel.add(lblNombre, gbc_lblNombre);
			
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.anchor = GridBagConstraints.NORTH;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 1;
			panel.add(textField, gbc_textField);
			textField.setColumns(10);
			
			JLabel lblEdad = new JLabel("Edad:");
			GridBagConstraints gbc_lblEdad = new GridBagConstraints();
			gbc_lblEdad.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
			gbc_lblEdad.gridx = 1;
			gbc_lblEdad.gridy = 2;
			panel.add(lblEdad, gbc_lblEdad);
			
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.anchor = GridBagConstraints.NORTH;
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = 2;
			panel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			
			JLabel lblCantBoletas = new JLabel("Cant. boletas:");
			GridBagConstraints gbc_lblCantBoletas = new GridBagConstraints();
			gbc_lblCantBoletas.anchor = GridBagConstraints.WEST;
			gbc_lblCantBoletas.insets = new Insets(0, 0, 5, 5);
			gbc_lblCantBoletas.gridx = 1;
			gbc_lblCantBoletas.gridy = 3;
			panel.add(lblCantBoletas, gbc_lblCantBoletas);
			
			textField_3 = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.anchor = GridBagConstraints.NORTH;
			gbc_textField_3.insets = new Insets(0, 0, 5, 5);
			gbc_textField_3.gridx = 3;
			gbc_textField_3.gridy = 3;
			panel.add(textField_3, gbc_textField_3);
			textField_3.setColumns(10);
			
			JLabel lblTipoDePago = new JLabel("Tipo de pago:");
			GridBagConstraints gbc_lblTipoDePago = new GridBagConstraints();
			gbc_lblTipoDePago.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblTipoDePago.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoDePago.gridx = 1;
			gbc_lblTipoDePago.gridy = 4;
			panel.add(lblTipoDePago, gbc_lblTipoDePago);
			
			textField_2 = new JComboBox();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.anchor = GridBagConstraints.NORTH;
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.insets = new Insets(0, 0, 5, 5);
			gbc_textField_2.gridx = 3;
			gbc_textField_2.gridy = 4;
			panel.add(textField_2, gbc_textField_2);
			
			JLabel lblEvento = new JLabel("Evento:");
			GridBagConstraints gbc_lblEvento = new GridBagConstraints();
			gbc_lblEvento.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEvento.insets = new Insets(0, 0, 5, 5);
			gbc_lblEvento.gridx = 1;
			gbc_lblEvento.gridy = 5;
			panel.add(lblEvento, gbc_lblEvento);
			
			textField_4 = new JComboBox();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.anchor = GridBagConstraints.NORTH;
			gbc_textField_4.insets = new Insets(0, 0, 5, 5);
			gbc_textField_4.gridx = 3;
			gbc_textField_4.gridy = 5;
			panel.add(textField_4, gbc_textField_4);
			
			JLabel lblBoletas = new JLabel("Boletas: ");
			GridBagConstraints gbc_lblBoletas = new GridBagConstraints();
			gbc_lblBoletas.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblBoletas.insets = new Insets(0, 0, 5, 0);
			gbc_lblBoletas.gridx = 4;
			gbc_lblBoletas.gridy = 5;
			panel.add(lblBoletas, gbc_lblBoletas);
			
			JLabel lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.NORTH;
			gbc_lblPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrecio.gridx = 1;
			gbc_lblPrecio.gridy = 6;
			panel.add(lblPrecio, gbc_lblPrecio);
			
			JLabel label = new JLabel("$ ...");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.NORTH;
			gbc_label.fill = GridBagConstraints.HORIZONTAL;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 3;
			gbc_label.gridy = 6;
			panel.add(label, gbc_label);
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
}
