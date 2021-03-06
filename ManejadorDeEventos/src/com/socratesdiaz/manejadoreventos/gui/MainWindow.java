package com.socratesdiaz.manejadoreventos.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;

import com.socratesdiaz.manejadoreventos.control.EventListModel;
import com.socratesdiaz.manejadoreventos.control.GuestTableModel;
import com.socratesdiaz.manejadoreventos.control.MainController;
import com.socratesdiaz.manejadoreventos.control.MainEventListSelectionListener;
import com.socratesdiaz.manejadoreventos.core.Usuario;

public class MainWindow extends JFrame {

	private JTable guestTable;
	private JMenu mnAdministracin;
	private JMenuItem mntmAdministrarEventos;
	private JMenuItem mntmAdministrarUsuarios;
	private JList eventList;
	private JLabel lblNombreEvento;
	private JLabel lblDescripcinEvento;

	public MainWindow(MainController control) {
		super();
		setBounds(100, 100, 823, 474);
		addWindowListener(control);
		
		// Menu bar and items
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Menú archivo y sus ítems
		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mnFile.add(mntmAgregar);
		mntmAgregar.addActionListener(control);
		mntmAgregar.setName("mainAdd");
		
		/*JMenuItem mntmSearch = new JMenuItem("Buscar");
		mntmSearch.addActionListener(control);
		mntmSearch.setName("mainSearch");
		mnFile.add(mntmSearch);
		*/
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnFile.add(mntmSalir);
		mntmSalir.setName("mainExit");
		mntmSalir.addActionListener(control);
		
		
		// Menú conexión y sus ítems
		/*JMenu mnConexin = new JMenu("Conexión");
		menuBar.add(mnConexin);
		
		JMenuItem mntmConectarDB = new JMenuItem("Conectar a otra base de datos");
		mnConexin.add(mntmConectarDB);
		mntmConectarDB.addActionListener(control);
		*/
		
		// Menú estadísticas y sus ítems
		JMenu mnEstadsticas = new JMenu("Estadísticas");
		menuBar.add(mnEstadsticas);
		
		JMenuItem mntmCrearReportes = new JMenuItem("Crear reportes...");
		mnEstadsticas.add(mntmCrearReportes);
		mntmCrearReportes.setName("mainStats");
		mntmCrearReportes.addActionListener(control);
		
		// Menú administración y sus ítems
		mnAdministracin = new JMenu("Administración");
		menuBar.add(mnAdministracin);
		
		JMenuItem mntmChangeUser = new JMenuItem("Cambiar de usuario...");
		//mnAdministracin.add(mntmChangeUser);
		mntmChangeUser.setName("mainChangeUser");
		mntmChangeUser.addActionListener(control);
		
		mntmAdministrarEventos = new JMenuItem("Administrar eventos...");
		mnAdministracin.add(mntmAdministrarEventos);
		mntmAdministrarEventos.setName("mainAdminEvents");
		mntmAdministrarEventos.addActionListener(control);
		
		mntmAdministrarUsuarios = new JMenuItem("Administrar usuarios...");
		//mnAdministracin.add(mntmAdministrarUsuarios);
		mntmAdministrarUsuarios.setName("mainAdminUsers");
		mntmAdministrarUsuarios.addActionListener(control);
		
		// Menú ayuda y sus ítems
		/*JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		*/
		
		// Toolbar
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		ImageIcon imagenAgregar = new ImageIcon("iconos/add.png");
		JButton btnAgregar = new JButton("Agregar",imagenAgregar);
		toolBar.add(btnAgregar);
		btnAgregar.setName("mainAdd");
		btnAgregar.addActionListener(control);
		
		ImageIcon imagenBorrar = new ImageIcon("iconos/cross.png");
		JButton btnBorrar = new JButton("Borrar",imagenBorrar);
		toolBar.add(btnBorrar);
		btnBorrar.addActionListener(control);
		btnBorrar.setName("mainDelete");
		
		ImageIcon imagenActualizar = new ImageIcon("iconos/arrow_refresh.png");
		JButton btnActualizar = new JButton("Actualizar",imagenActualizar);
		toolBar.add(btnActualizar);
		btnActualizar.addActionListener(control);
		btnActualizar.setName("mainRefresh");
		
		ImageIcon imgenEstadisticas = new ImageIcon("iconos/table.png");
		JButton btnEstadsticas = new JButton("Estadistica",imgenEstadisticas);
		toolBar.add(btnEstadsticas);
		btnEstadsticas.setName("mainStats");
		btnEstadsticas.addActionListener(control);
		
		/*
		ImageIcon imagenImprimir = new ImageIcon("iconos/printer.png");
		JButton btnImprimir = new JButton( "Imprimir",imagenImprimir);
		toolBar.add(btnImprimir);
		btnImprimir.addActionListener(control);
		btnImprimir.setName("mainPrint");
		
		ImageIcon imagenBuscar  = new ImageIcon("iconos/magnifier.png");
		JButton btnBuscar = new JButton("Buscar",imagenBuscar);
		toolBar.add(btnBuscar);
		btnBuscar.setName("mainSearch");
		btnBuscar.addActionListener(control);
		
		ImageIcon imagenAyuda = new ImageIcon("iconos/wrench.png");
		JButton btnAyuda = new JButton("Ayuda",imagenAyuda);
		toolBar.add(btnAyuda);
		btnAyuda.setName("mainHelp");
		btnAyuda.addActionListener(control);
		*/
		
		// Panel para la lista
		JSplitPane panel = new JSplitPane();
		panel.setContinuousLayout(true);
		panel.setOneTouchExpandable(true);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 328, 359);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		// Lista
		JLabel lblLista = new JLabel("Lista de eventos");
		lblLista.setBounds(12, 5, 118, 15);
		panel_3.add(lblLista);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 32, 304, 315);
		panel_3.add(scrollPane_1);
		
		eventList = new JList();
		eventList.setModel(new EventListModel());
		eventList.addListSelectionListener(new MainEventListSelectionListener(this, control.getDBManager()));
		scrollPane_1.setViewportView(eventList);
		
		// Panel para la tabla
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(329, 12, 480, 340);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNombreEvento = new JLabel("Nombre evento");
		lblNombreEvento.setBounds(23, 12, 445, 15);
		panel_2.add(lblNombreEvento);
		
		lblDescripcinEvento = new JLabel("Descripción evento");
		lblDescripcinEvento.setBounds(22, 31, 446, 15);
		panel_2.add(lblDescripcinEvento);
		
		// Tabla
		guestTable = new JTable();
		guestTable.setModel(new GuestTableModel(control.getDBManager()));
		
		JScrollPane scrollPane = new JScrollPane(guestTable);
		scrollPane.setBounds(0, 58, 480, 276);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(guestTable);
		
		// Panel inferior
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblProgresoDelArchivo = new JLabel("Cargando base de datos...");
		//panel_1.add(lblProgresoDelArchivo);
		
		// Barra de progreso
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		//panel_1.add(progressBar);
		
		setTitle("Manejador de Eventos v1.0");
		setVisible(true);
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		
	}
	
	public JTable getGuestTable() {
		return guestTable;
	}
	
	public void setUser(Usuario user) {
		if(user.getTipo().equals("Administrador")) {
			mntmAdministrarEventos.setEnabled(true);
			mntmAdministrarUsuarios.setEnabled(true);
		}
		else {
			mntmAdministrarEventos.setEnabled(false);
			mntmAdministrarUsuarios.setEnabled(false);
		}
	}
	
	public void lock(boolean lock) {
		if(lock) getContentPane().setEnabled(false);
		else getContentPane().setEnabled(false);
	}

	public JList getEventList() {
		return eventList;
	}

	public JLabel getLblNombreEvento() {
		return lblNombreEvento;
	}

	public JLabel getLblDescripcinEvento() {
		return lblDescripcinEvento;
	}
	
}
