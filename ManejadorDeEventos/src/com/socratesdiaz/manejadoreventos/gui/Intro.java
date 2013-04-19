package com.socratesdiaz.manejadoreventos.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Intro extends JFrame {
	
	private JLabel imagen = null;
	private JProgressBar  JProgressBar2 = null; 
	private JPanel barra = null;
	private int i;
	private JFrame ventana;
	
	public JProgressBar getbarra(){
		initComponents(); 
		
		JProgressBar2 = new JProgressBar();
		JProgressBar2.setOpaque(true);
		JProgressBar2.setTransferHandler(getTransferHandler());
		JProgressBar2.setStringPainted(true);
	
		new Thread(){
			
			
			public void run(){
				
				for(i=0; i<=100; i++){
					
				
					try {
						sleep(60);
						
						 JProgressBar2.setValue(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
//					if(i == 25 ){
//						
//						ventana.setOpacity(0.8f);
//							
//						
//							
//						}if(i == 50){
//							
//							ventana.setOpacity(0.3f);
//							
//					}if(i == 75 ){
//							
//							ventana.setOpacity(0.2f);
//							
//						}if(i == 100){
//							
//							ventana.setVisible(false);
//							
//					}
//						
//					
				}
				for(int j=100; j>=0; j --){
					ventana.setOpacity((j*0.01f));
					if(j==0){
						
					System.exit(0);
					}
					}
				
		}
			
			
			
		}.start();
	
	return JProgressBar2;
		}


	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

	
	public JPanel getpanaeldebrra(){
		
		barra = new JPanel();
		barra.setBounds(180, 350, 150, 20);
		barra.add(getbarra(),BorderLayout.SOUTH);
		
		return barra;
		
	}

	public JLabel getimagen(){
		
		if(imagen == null){
			ImageIcon h = new ImageIcon("iconos/yordi.png");
			
			
			imagen = new JLabel(h);
			imagen.setVisible(true);
	
			
		}
		return imagen;
	
	}
	
	
		
	
	
	
	
	
	public void getventna(){
		
	ventana = new JFrame();
	ventana.setLayout(new BorderLayout());
	ventana.setUndecorated(true);
	
	ventana.setSize(500, 400);
	ventana.add(getpanaeldebrra());
	ventana.add(getimagen());
	ventana.setLocationRelativeTo(null);
	
	ventana.setVisible(true);
	

	}
}
