package ies.jandula.Concesionario.exception;

public class ConcesionarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147990807403278808L;
	
	
	public ConcesionarioException() {
		
	}
	
	public ConcesionarioException(String mensaje) {
		super(mensaje);
			
	}
	
	public ConcesionarioException(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

}
