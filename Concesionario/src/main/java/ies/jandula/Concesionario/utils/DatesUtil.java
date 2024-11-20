package ies.jandula.Concesionario.utils;

import java.util.Date;

import ies.jandula.Concesionario.exception.ConcesionarioException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatesUtil {
	
	public static Date crearFechaDesdeString(String fechaString) throws ConcesionarioException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return formatter.parse(fechaString);
		}
		catch (ParseException parseException) {
			throw new ConcesionarioException("Fecha con formato incorrecta: " + fechaString, parseException);
		}
	}

}
