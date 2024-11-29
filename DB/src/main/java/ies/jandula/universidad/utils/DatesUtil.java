package ies.jandula.universidad.utils;

import java.util.Date;

import ies.jandula.universidad.exception.UniversidadException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatesUtil {
	
	public static Date crearFechaDesdeString(String fechaString) throws UniversidadException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return formatter.parse(fechaString);
		}
		catch (ParseException parseException) {
			throw new UniversidadException(8, "Fecha con formato incorrecta: " + fechaString, parseException);
		}
	}

}
