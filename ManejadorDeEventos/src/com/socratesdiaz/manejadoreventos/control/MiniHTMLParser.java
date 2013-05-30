package com.socratesdiaz.manejadoreventos.control;

public final class MiniHTMLParser {

	//private static String[] CRITERIA = { 
	//	"&aacute;", "&eacute", "&iacute", "&oacute", "&uacute"
	//};
	private static final String A_ACUTE = "&aacute;";
	private static final String E_ACUTE = "&eacute;";
	private static final String I_ACUTE = "&iacute;";
	private static final String O_ACUTE = "&oacute;";
	private static final String U_ACUTE = "&uacute;";
	private static final String AMP = "&amp;";
	private static final String LOWER_THAN = "&lt;";
	private static final String GREATER_THAN = "&gt;";
	
	public static String toHTML(String text) {
		
		String dest = new String(text.toString());
		dest = dest.replaceAll("á", A_ACUTE);
		dest = dest.replaceAll("é", E_ACUTE);
		dest = dest.replaceAll("í", I_ACUTE);
		dest = dest.replaceAll("ó", O_ACUTE);
		dest = dest.replaceAll("ú", U_ACUTE);
		
		return dest;
	}
	
	public static String toText(String text) {
		
		String dest = new String(text.toString());
		dest = dest.replaceAll(A_ACUTE, "á");
		dest = dest.replaceAll(E_ACUTE, "é");
		dest = dest.replaceAll(I_ACUTE, "í");
		dest = dest.replaceAll(O_ACUTE, "ó");
		dest = dest.replaceAll(U_ACUTE, "ú");
		
		return dest;
	}
	
}
