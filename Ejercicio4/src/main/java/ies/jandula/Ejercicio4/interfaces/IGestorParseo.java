package ies.jandula.Ejercicio4.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;

@Configuration
public interface IGestorParseo {
	
	@Bean
	void parseaFichero(String nombreFichero) throws Ejercicio4Excepcion;

}
