package ies.jandula.Concesionario.interfaces;

import java.util.Scanner;

import ies.jandula.Concesionario.exception.ConcesionarioException;

public interface IParseo {
	
	void parsearFichero(Scanner scanner) throws ConcesionarioException;

}
