package ies.jandula.Biblioteca.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.jandula.Biblioteca.utils.BibliotecaException;

@Configuration
public interface IGestorParseo {
	
	@Bean
	void parseaFichero(String nombreFichero) throws BibliotecaException;

}
