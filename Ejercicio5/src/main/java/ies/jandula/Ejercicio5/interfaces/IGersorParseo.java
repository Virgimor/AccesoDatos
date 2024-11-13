package ies.jandula.Ejercicio5.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;

@Configuration
public interface IGersorParseo {
	
	@Bean
	void parseaFichero(String nombreFichero) throws Ejercicio5Exception;

}
