package ies.jandula.universidad.exception;

public class UniversidadException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 202410541044894671L;
	
	public UniversidadException() {
		
	}
	
	public UniversidadException(String mensaje) {
		super(mensaje);
			
	}
	
	public UniversidadException(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}
	
	

}
