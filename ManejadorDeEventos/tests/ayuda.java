package com.socratesdiaz.manejadoreventos.gui;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
public class ayuda extends JFrame {
	
	private JFrame ayuda = null;
	private JPanel panelAyuda = null;
	private JLabel textoayuda = null;
	
	
	
	
	public ayuda(ayuda ayudame, Controller controller){
		
		
	}
	
	JLabel gettextoayuda(){
		
		if(textoayuda == null){
			
			textoayuda = new JLabel();
			textoayuda.setSize(300, 300);
			
			textoayuda.setText("Este programa esta diseñado para que  cualquier cliente lo pueda " + "\n" +
					"utilizar,ya que su interfas  es muy comoda y facilde manejar ");
		}
		return textoayuda;
	}
	
	JPanel getpanelayuda(){
		
		if(panelAyuda == null){
		//porque no puedo poner esta imagende fondo dejare eso y voy con lo  k sigue
			//ImageIcon imgenayuda = new ImageIcon("iconos/serenidad1.png");
			panelAyuda = new JPanel();
			
			panelAyuda.setBackground(Color.BLUE);
			panelAyuda.setSize(400, 400);
			
			
			
		}
		return panelAyuda;
	}
	JFrame getay(){
		
		if(ayuda == null){
			ayuda = new JFrame();
			ayuda.setTitle("ayuda del sistema");
			ayuda.add(gettextoayuda());
			ayuda.add(getpanelayuda());
			ayuda.setSize(400, 400);
			ayuda.setVisible(true);
			
			
			
		}
		
		return ayuda;
	}

}
