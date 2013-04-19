package com.socratesdiaz.manejadoreventos.core;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Vector;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class HTMLReportGenerator {

	public DBManager dbManager;
	public String template = "<html><head>" +
			"<title>Reporte generado "+new SimpleDateFormat().format(new Date())+"</title>" +
			"</head><body><h1>Reporte generado por Manejador de Eventos</h1>";
	
	public HTMLReportGenerator(DBManager dbManager) {
		this.dbManager = dbManager;
	}
	
	public void createHTMLFile(Vector<DataQueryItem> data, File path) throws Exception {
		
		if(!dbManager.isConnection()) throw new Exception("No se pudo establecer una conexión a la base de datos. La base de datos no está conectada.");
		File output = path;
		String finalHtml = template;
		for(DataQueryItem e:data) {
			finalHtml += "<h2>'"+e.getAction()+"' en evento: '"+e.getEvento()+"'</h2>";
			finalHtml += "<table border=1><tr>";
			Connection tmp_con = dbManager.getConnection();
			PreparedStatement preparedStmt = tmp_con.prepareStatement(e.getQueryStatement());
			preparedStmt.setString(1, e.getEvento());
			ResultSet result = preparedStmt.executeQuery();
			
			for(int i = 0; i < e.getColumnNames().length; i++) {
				finalHtml += "<td>"+e.getColumnNames()[i]+"</td>\n";
				
			}
			finalHtml += "</tr>";
			
			
			while(result.next()) {
				finalHtml += "<tr>";
				for(int i = 1; i <= e.getColumnNames().length; i++) {
					finalHtml += "<td>"+result.getString(i)+"</td>\n";
				}
				finalHtml += "</tr>";
			}
			
			finalHtml += "</table><br><br>";
		}
		finalHtml += "<p><i>Momento de creación del documento: "+new SimpleDateFormat().format(new Date())+"</i></p>"+
					"</body></html>";
		if(!output.exists()) output.createNewFile();
		if(output.canWrite()) {
			Formatter formatter = new Formatter(output);
			formatter.format(finalHtml, null);
			formatter.close();
		}
	}
}
