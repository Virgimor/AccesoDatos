package ies.jandula.universidad.interfaces;

import java.util.Scanner;

import ies.jandula.universidad.exception.UniversidadException;


public interface IParseo {
	
	void parseaFichero(Scanner scanner) throws UniversidadException ;

}
