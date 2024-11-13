package ies.jandula.Ejercicio5.exception;


public class Ejercicio5Exception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6302669259191779090L;

	public Ejercicio5Exception() {
		
	}
	
	public Ejercicio5Exception(String mensaje) {
		super(mensaje);
	}
	
	public Ejercicio5Exception(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

}
