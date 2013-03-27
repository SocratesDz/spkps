package com.socratesdiaz.manejadoreventos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;

public class MainWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);
		
		JMenu mnConexin = new JMenu("Conexión");
		menuBar.add(mnConexin);
		
		JMenu mnEstadsticas = new JMenu("Estadísticas");
		menuBar.add(mnEstadsticas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnAgregar = new JButton("Agregar");
		toolBar.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		toolBar.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		toolBar.add(btnActualizar);
		
		JButton btnEstadsticas = new JButton("Estadísticas...");
		toolBar.add(btnEstadsticas);
		
		JButton btnImprimir = new JButton("Imprimir");
		toolBar.add(btnImprimir);
		
		JButton btnBuscar = new JButton("Buscar");
		toolBar.add(btnBuscar);
		
		
		JButton btnAyuda = new JButton("Ayuda");
		toolBar.add(btnAyuda);
		
		JSplitPane panel = new JSplitPane();
		panel.setContinuousLayout(true);
		panel.setOneTouchExpandable(true);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 328, 359);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLista = new JLabel("Lista de eventos");
		lblLista.setBounds(12, 5, 118, 15);
		panel_3.add(lblLista);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 32, 304, 315);
		panel_3.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(329, 12, 480, 340);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombreEvento = new JLabel("Nombre evento");
		lblNombreEvento.setBounds(23, 12, 126, 15);
		panel_2.add(lblNombreEvento);
		
		JLabel lblDescripcinEvento = new JLabel("Descripción evento");
		lblDescripcinEvento.setBounds(22, 31, 175, 15);
		panel_2.add(lblDescripcinEvento);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 58, 480, 276);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblProgresoDelArchivo = new JLabel("Cargando base de datos...");
		panel_1.add(lblProgresoDelArchivo);
		
		JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar);
		
		
	}
}
