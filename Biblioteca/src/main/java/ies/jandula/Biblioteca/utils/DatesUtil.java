package ies.jandula.Biblioteca.utils;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatesUtil {
	
	public static Date crearFechaDesdeString(String fechaString) throws BibliotecaException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return formatter.parse(fechaString);
		}
		catch (ParseException parseException) {
			throw new BibliotecaException("Fecha con formato incorrecta: " + fechaString, parseException);
		}
	}

}
