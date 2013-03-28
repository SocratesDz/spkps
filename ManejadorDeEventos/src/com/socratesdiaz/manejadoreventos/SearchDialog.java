package com.socratesdiaz.manejadoreventos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class SearchDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchDialog dialog = new SearchDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchDialog() {
		setBounds(100, 100, 450, 300);
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Seleccione el criterio de b\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panel_1);
				ButtonGroup radioGroup = new ButtonGroup();
				{
					JRadioButton rdbtnNombre = new JRadioButton("Nombre");
					radioGroup.add(rdbtnNombre);
					panel_1.add(rdbtnNombre);
				}
				{
					JRadioButton rdbtnEvento = new JRadioButton("Evento");
					radioGroup.add(rdbtnEvento);
					panel_1.add(rdbtnEvento);
				}
				{
					JRadioButton rdbtnCantidadDeBoletas = new JRadioButton("Cantidad de boletas");
					radioGroup.add(rdbtnCantidadDeBoletas);
					panel_1.add(rdbtnCantidadDeBoletas);
				}
				{
					JRadioButton rdbtnFecha = new JRadioButton("Fecha");
					radioGroup.add(rdbtnFecha);
					panel_1.add(rdbtnFecha);
				}
			}
		}
	}

}
