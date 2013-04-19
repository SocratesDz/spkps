package com.socratesdiaz.manejadoreventos.core;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserManager {
	
	String username;
	String password;
	Usuario target;
	
	public UserManager(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Usuario getUser() {
		
		
		File file = new File("users.dat");

		if(!file.exists()) {
			// Lanzar una excepción diciendo que el archivo no existe
			// o llamar a la clase FirstTimeConfig (que todavía no existe)
			// si eso falla, pues hay un error "grave"
			return null;
			
		}

		if(file.canRead()) {
			
			try {
				// Lee el archivo en busca de usuarios
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				boolean eof = false;
				
				while(!eof) {
					target = (Usuario) ois.readObject();
					if(target.getNombre().equals(this.username) && Crypter.decrypt(target.getPassword()).equals(this.password)) {
						return target;
					}
				}
				
				
			} catch (EOFException eof_ex) {
				System.out.println("El usuario especificado no fue encontrado.");
				return null;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				return null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
}
