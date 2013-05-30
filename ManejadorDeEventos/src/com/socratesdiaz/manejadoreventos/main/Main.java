package com.socratesdiaz.manejadoreventos.main;

import javax.swing.UIManager;

import com.socratesdiaz.manejadoreventos.control.MainController;

public class Main {
	public static void main(String[] args) {
		
		// El tema de Nimbus no le pega
		/*for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                }
                catch (Exception ex) {
                    ;
                }
            }
		}*/
		
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		MainController main = new MainController();
	}
	
}
