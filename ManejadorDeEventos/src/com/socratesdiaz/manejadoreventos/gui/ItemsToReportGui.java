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
import java.awt.GridLayout;
import javax.swing.Box;

import com.socratesdiaz.manejadoreventos.core.ComponentDataFiller;
import com.socratesdiaz.manejadoreventos.core.QueryCodes;

import java.awt.Component;

public class ItemsToReportGui extends JDialog {

	private JComboBox comboBoxDataItem;
	private JComboBox comboBoxEventList;

	public ItemsToReportGui(ReportMakerGui parent, Controller control) {
		super(parent);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 466, 216);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 464, 182);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 12, 464, 51);
		panel_3.setBorder(new TitledBorder(null, "Elija el \u00EDtem para a\u00F1adir al reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		comboBoxDataItem = new JComboBox(QueryCodes.DESCRIPTION);
		comboBoxDataItem.setName("comboBoxDataItem");
		panel_3.add(comboBoxDataItem);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 75, 464, 51);
		panel_4.setBorder(new TitledBorder(null, "Elija el evento para el \u00EDtem seleccionado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		comboBoxEventList = new JComboBox();
		panel_4.add(comboBoxEventList, BorderLayout.CENTER);
		comboBoxEventList.setName("comboBoxEventList");
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 146, 464, 35);
		panel_2.add(panel_1);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnAgregar = new JButton("Agregar");
		panel_1.add(btnAgregar);
		btnAgregar.addActionListener(control);
		btnAgregar.setName("itemsReportAdd");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		btnCancelar.addActionListener(control);
		btnCancelar.setName("itemsReportCancel");
	}
	
	public JComboBox getComboBoxDataItem() {
		return comboBoxDataItem;
	}
	
	public JComboBox getComboBoxEventList() {
		return comboBoxEventList;
	}

}
