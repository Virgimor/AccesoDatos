package ies.jandula.universidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ies.jandula.universidad.interfaces.IGestorParseo;
import ies.jandula.universidad.utils.Costantes;

@SpringBootApplication
public class UniversidadApplication implements CommandLineRunner {

	@Autowired
	private IGestorParseo parseoFicheros;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}
	
	@Transactional(readOnly = false)
	public void run(String... args) throws Exception{
		
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_DEPARTAMENTO) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_ALUMNO) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_PROFESOR) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_GRADO) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_ASIGNATURA) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_CURSO) ;
    	this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_MATRICULA) ;
    }

}
