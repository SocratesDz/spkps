package com.socratesdiaz.manejadoreventos.core;

/**
 * Gracias a Farhan Khwaja de Code2Learn, por enseñarme
 * a usar Cipher con el algoritmo AES de una manera simple.
 * 
 * URL: http://www.code2learn.com/2011/06/encryption-and-decryption-of-data-using.html
 * 
 * Nota.: Para que funcione con Eclipse y evitar el error de acceso restringido:
 * 	Window --> Preferences --> Java --> Compiler --> Error/Warnings
 * 	Seleccionamos Deprecated and Restricted API. 
 * 	Cambias a Warning, las opciones de Forbidden and Discouraged Reference.
 */

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class Crypter {
	
	// Se especifica el algoritmo, en este caso AES
	private static final String ALGORITHM = "AES";
	private static byte[] keyValue =	// Se crea una keyValue de 16 bits de longitud, ya que el Algoritmo AES soporta sólo 128 bits (16 * 8)
		new byte[]{ 'T', 'h', 'e', 'C', 'o', 'o', 'l',
		'S', 'e', 'c', 'r', 'e', 't',
		'K', 'e', 'y'};
	
	public static String encrypt(String Data) throws Exception {
		// Creamos una clave secreta con el keyValue y el algoritmo deseado
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		Cipher c = Cipher.getInstance(ALGORITHM);	// Obtenemos una instancia de Cipher con el Algoritmo que queremos		
		c.init(Cipher.ENCRYPT_MODE, key);	// Lo inicializamos en modo de encriptación con la clave secreta que tenemos
		byte[] encVal = c.doFinal(Data.getBytes());	// Obtenemos el array de bytes del string Data y entonces lo encriptamos
		String encryptedValue = new BASE64Encoder().encode(encVal);	// Mediante el array de bytes que obtuvimos lo codificamos con BASE64Enconder
		return encryptedValue;
	}
	
	public static String decrypt(String encryptedData) throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decodedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

}