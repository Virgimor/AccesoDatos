package ies.jandula.Ejercicio4.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Ejercicio4Excepcion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4295192348202493268L;
	
	public Ejercicio4Excepcion(String mensaje) {
		super(mensaje);
	}
	
	public Ejercicio4Excepcion(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

}
