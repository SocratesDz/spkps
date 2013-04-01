package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class ItemsToReportGui extends JDialog {

	public ItemsToReportGui(ReportMakerGui parent, Controller control) {
		super(parent);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 450, 119);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Elija el \u00EDtem para a\u00F1adir al reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar");
		panel_1.add(btnAgregar);
		btnAgregar.addActionListener(control);
		btnAgregar.setName("itemsReportAdd");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		btnCancelar.addActionListener(control);
		btnCancelar.setName("itemsReportCancel");
	}

}
