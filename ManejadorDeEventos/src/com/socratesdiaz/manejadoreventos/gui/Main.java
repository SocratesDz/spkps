package com.socratesdiaz.manejadoreventos.gui;

import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		
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
		Controller main = new Controller();
	}
	
}
