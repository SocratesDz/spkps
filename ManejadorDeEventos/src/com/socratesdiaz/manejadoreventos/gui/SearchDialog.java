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
	private JPanel panelCardLayout;
	private CardLayout cl_panelCardLayout;
	private JPanel panelBuscarNombre;
	private JPanel panelBuscarEvento;
	private JPanel panelBuscarBoletas;
	private JPanel panelBuscarFecha;

	public SearchDialog(JFrame parent, Controller control) {
		cl_panelCardLayout = new CardLayout(0, 0);
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
					rdbtnFecha.setName("searchDialogViewDatePanel");
				}
			}
			{
				panelCardLayout = new JPanel();
				panel.add(panelCardLayout);
				panelCardLayout.setLayout(cl_panelCardLayout);
				{
					panelBuscarNombre = new JPanel();
					panelBuscarNombre.setBorder(new TitledBorder(null, "Buscar por nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelCardLayout.add(panelBuscarNombre, "SearchNamePanel");
					{
						JLabel lblNombre = new JLabel("Nombre:");
						panelBuscarNombre.add(lblNombre);
					}
					{
						textField = new JTextField();
						panelBuscarNombre.add(textField);
						textField.setColumns(10);
					}
				}
				{
					panelBuscarEvento = new JPanel();
					FlowLayout fl_panelBuscarEvento = (FlowLayout) panelBuscarEvento.getLayout();
					panelBuscarEvento.setBorder(new TitledBorder(null, "Buscar por evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelCardLayout.add(panelBuscarEvento, "SearchEventPanel");
					{
						JLabel lblEvento = new JLabel("Evento");
						panelBuscarEvento.add(lblEvento);
					}
					
					textField_1 = new JComboBox();
					panelBuscarEvento.add(textField_1);
				}
				{
					panelBuscarBoletas = new JPanel();
					panelBuscarBoletas.setBorder(new TitledBorder(null, "Buscar por cantidad de boletas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelCardLayout.add(panelBuscarBoletas, "SearchTicketsPanel");
					
					JLabel lblCantidadDeBoletas = new JLabel("Cantidad de boletas:");
					panelBuscarBoletas.add(lblCantidadDeBoletas);
					
					textField_2 = new JTextField();
					panelBuscarBoletas.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					panelBuscarFecha = new JPanel();
					panelBuscarFecha.setBorder(new TitledBorder(null, "Buscar por fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelCardLayout.add(panelBuscarFecha, "SearchDatePanel");
					
					JLabel lblFecha = new JLabel("Fecha (DD/MM/YYYY):");
					panelBuscarFecha.add(lblFecha);
					
					JComboBox comboBox = new JComboBox();
					panelBuscarFecha.add(comboBox);
					
					JLabel label = new JLabel("/");
					panelBuscarFecha.add(label);
					
					JComboBox comboBox_1 = new JComboBox();
					panelBuscarFecha.add(comboBox_1);
					
					JLabel label_1 = new JLabel("/");
					panelBuscarFecha.add(label_1);
					
					JComboBox comboBox_2 = new JComboBox();
					panelBuscarFecha.add(comboBox_2);
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
	
	public void setPanel(String name) {
		cl_panelCardLayout.show(panelCardLayout, name);
	}
}
