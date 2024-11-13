package ies.jandula.Ejercicio5.utils;

import java.util.Date;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatesUtil {
	
	public static Date crearFechaDesdeString(String fechaString) throws Ejercicio5Exception{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return formatter.parse(fechaString);
		}
		catch (ParseException parseException) {
			throw new Ejercicio5Exception("Fecha con formato incorrecta: " + fechaString, parseException);
		}
	}

}
