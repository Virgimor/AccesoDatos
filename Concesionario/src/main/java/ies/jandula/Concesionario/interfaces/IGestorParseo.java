package ies.jandula.Concesionario.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.jandula.Concesionario.exception.ConcesionarioException;

@Configuration
public interface IGestorParseo {
	
	@Bean
	void parseoFichero(String nombreFichero) throws ConcesionarioException;

}
