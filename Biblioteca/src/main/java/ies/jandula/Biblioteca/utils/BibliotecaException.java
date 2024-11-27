package ies.jandula.Biblioteca.utils;

public class BibliotecaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4972565987386400928L;

	public BibliotecaException() {

	}

	public BibliotecaException(int codigo, String mensaje) {
		super(mensaje);

	}

	public BibliotecaException(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

}
