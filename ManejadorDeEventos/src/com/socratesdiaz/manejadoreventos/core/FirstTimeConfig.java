package com.socratesdiaz.manejadoreventos.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FirstTimeConfig {

	
	
	public static void main(String[] args) {
		
		try {
		 
		 	String rootPassword = "root";
			Administrador root = new Administrador("root", Crypter.encrypt(rootPassword));
		 	File usersDataFile = new File("users.dat");
		 	
			// Si el archivo no existe, entonces lo creamos
			if(!usersDataFile.exists()) {
				usersDataFile.createNewFile();
			}
			
			// Ejemplo de escritura de un objeto
			if(usersDataFile.canWrite()) {
				FileOutputStream fos = new FileOutputStream(usersDataFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(((Usuario)root));
				oos.close();
				fos.close();
			}
			
			// Ejemplo de lectura de un objeto
			/*if(usersDataFile.canRead()) {
				FileInputStream fis = new FileInputStream(usersDataFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Usuario user = (Usuario) ois.readObject();
				System.out.println(user.tipo);
				ois.close();
				fis.close();
			}*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}