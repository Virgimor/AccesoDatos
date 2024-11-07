package ies.jandula.universidad.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.jandula.universidad.exception.UniversidadException;

@Configuration
public interface IGestorParseo {
	
	@Bean
	void parseaFichero(String nombreFichero) throws UniversidadException;

}
