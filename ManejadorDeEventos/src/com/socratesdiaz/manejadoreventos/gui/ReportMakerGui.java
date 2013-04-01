package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;

public class ReportMakerGui extends JDialog {

	public ReportMakerGui(JFrame mainWindow, Controller control) {
		super(mainWindow);
		setResizable(false);
		setTitle("Estadísticas");
		setBounds(100, 100, 609, 490);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 385, 177, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 38, 0, 0, 0, 250, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
				gbc_verticalStrut.fill = GridBagConstraints.VERTICAL;
				gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
				gbc_verticalStrut.gridx = 0;
				gbc_verticalStrut.gridy = 0;
				panel.add(verticalStrut, gbc_verticalStrut);
			}
			{
				JLabel lblReportesAGenerar = new JLabel("Reportes a generar:");
				GridBagConstraints gbc_lblReportesAGenerar = new GridBagConstraints();
				gbc_lblReportesAGenerar.anchor = GridBagConstraints.WEST;
				gbc_lblReportesAGenerar.insets = new Insets(0, 0, 5, 5);
				gbc_lblReportesAGenerar.gridx = 1;
				gbc_lblReportesAGenerar.gridy = 2;
				panel.add(lblReportesAGenerar, gbc_lblReportesAGenerar);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 5;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 4;
				panel.add(scrollPane, gbc_scrollPane);
				{
					JList list = new JList();
					scrollPane.setViewportView(list);
				}
			}
			{
				JButton btnAadir = new JButton("Añadir...");
				GridBagConstraints gbc_btnAadir = new GridBagConstraints();
				gbc_btnAadir.insets = new Insets(0, 0, 5, 0);
				gbc_btnAadir.gridx = 2;
				gbc_btnAadir.gridy = 4;
				panel.add(btnAadir, gbc_btnAadir);
				btnAadir.addActionListener(control);
				btnAadir.setName("reportAddEntry");
			}
			{
				JButton btnRemover = new JButton("Remover");
				GridBagConstraints gbc_btnRemover = new GridBagConstraints();
				gbc_btnRemover.insets = new Insets(0, 0, 5, 0);
				gbc_btnRemover.gridx = 2;
				gbc_btnRemover.gridy = 5;
				panel.add(btnRemover, gbc_btnRemover);
				btnRemover.setName("reportRemoveEntry");
				btnRemover.addActionListener(control);
			}
			{
				JButton btnGenerarReporte = new JButton("Generar reporte...");
				GridBagConstraints gbc_btnGenerarReporte = new GridBagConstraints();
				gbc_btnGenerarReporte.insets = new Insets(0, 0, 5, 0);
				gbc_btnGenerarReporte.gridx = 2;
				gbc_btnGenerarReporte.gridy = 6;
				panel.add(btnGenerarReporte, gbc_btnGenerarReporte);
				btnGenerarReporte.addActionListener(control);
				btnGenerarReporte.setName("reportGenerate");
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
				gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
				gbc_btnCancelar.gridx = 2;
				gbc_btnCancelar.gridy = 7;
				panel.add(btnCancelar, gbc_btnCancelar);
				btnCancelar.setName("reportCancelButton");
				btnCancelar.addActionListener(control);
			}
		}
	}

}
