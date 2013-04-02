package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SearchDialog extends JDialog {
	private JTextField textField;
	private JComboBox textField_1;
	private JTextField textField_2;
	private JPanel panel_4;

	public SearchDialog(JFrame parent, Controller control) {
		setBounds(100, 100, 450, 300);
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Seleccione el criterio de b\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panel_1);
				ButtonGroup radioGroup = new ButtonGroup();
				{
					JRadioButton rdbtnNombre = new JRadioButton("Nombre");
					radioGroup.add(rdbtnNombre);
					panel_1.add(rdbtnNombre);
					rdbtnNombre.addChangeListener(control);
					rdbtnNombre.setName("searchDialogViewNamePanel");
				}
				{
					JRadioButton rdbtnEvento = new JRadioButton("Evento");
					radioGroup.add(rdbtnEvento);
					panel_1.add(rdbtnEvento);
					rdbtnEvento.addChangeListener(control);
					rdbtnEvento.setName("searchDialogViewEventPanel");
				}
				{
					JRadioButton rdbtnCantidadDeBoletas = new JRadioButton("Cantidad de boletas");
					radioGroup.add(rdbtnCantidadDeBoletas);
					panel_1.add(rdbtnCantidadDeBoletas);
					rdbtnCantidadDeBoletas.addChangeListener(control);
					rdbtnCantidadDeBoletas.setName("searchDialogViewTicketPanel");
				}
				{
					JRadioButton rdbtnFecha = new JRadioButton("Fecha");
					radioGroup.add(rdbtnFecha);
					panel_1.add(rdbtnFecha);
					rdbtnFecha.addChangeListener(control);
					rdbtnFecha.setName("searchDialogViewEventPanel");
				}
			}
			{
				panel_4 = new JPanel();
				panel.add(panel_4);
				panel_4.setLayout(new CardLayout(0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new TitledBorder(null, "Buscar por nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_4.add(panel_2, "name_11005597118258");
					{
						JLabel lblNombre = new JLabel("Nombre:");
						panel_2.add(lblNombre);
					}
					{
						textField = new JTextField();
						panel_2.add(textField);
						textField.setColumns(10);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
					panel_2.setBorder(new TitledBorder(null, "Buscar por evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_4.add(panel_2, "name_11043263450658");
					{
						JLabel lblEvento = new JLabel("Evento");
						panel_2.add(lblEvento);
					}
					
					textField_1 = new JComboBox();
					panel_2.add(textField_1);
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setBorder(new TitledBorder(null, "Buscar por cantidad de boletas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_4.add(panel_3, "name_11097345723820");
					
					JLabel lblCantidadDeBoletas = new JLabel("Cantidad de boletas:");
					panel_3.add(lblCantidadDeBoletas);
					
					textField_2 = new JTextField();
					panel_3.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new TitledBorder(null, "Buscar por fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_4.add(panel_2, "name_11126997309903");
					
					JLabel lblFecha = new JLabel("Fecha (DD/MM/YYYY):");
					panel_2.add(lblFecha);
					
					JComboBox comboBox = new JComboBox();
					panel_2.add(comboBox);
					
					JLabel label = new JLabel("/");
					panel_2.add(label);
					
					JComboBox comboBox_1 = new JComboBox();
					panel_2.add(comboBox_1);
					
					JLabel label_1 = new JLabel("/");
					panel_2.add(label_1);
					
					JComboBox comboBox_2 = new JComboBox();
					panel_2.add(comboBox_2);
				}
			}
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar);
		btnBuscar.setName("searchDialogSearchButton");
		btnBuscar.addActionListener(control);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		btnCancelar.setName("searchDialogCancelButton");
		btnCancelar.addActionListener(control);
	}
	
	public void setPanel(int index) {
<<<<<<< HEAD
		// Cambiar a la siguiente tarjeta del CardLayout
=======
		//
>>>>>>> 9c8f592686400a2a8688e049e524f862fc1a6a21
	}
}
