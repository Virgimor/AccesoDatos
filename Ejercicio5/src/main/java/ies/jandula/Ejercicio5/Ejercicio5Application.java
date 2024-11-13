package ies.jandula.Ejercicio5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ies.jandula.Ejercicio5.interfaces.IGersorParseo;
import ies.jandula.Ejercicio5.utils.Costantes;


@SpringBootApplication
public class Ejercicio5Application implements CommandLineRunner{
	
	@Autowired
	private IGersorParseo gersorParseo;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.gersorParseo.parseaFichero(Costantes.FICHERO_PROFESOR);
		this.gersorParseo.parseaFichero(Costantes.FICHERO_ALUMNO);
		this.gersorParseo.parseaFichero(Costantes.FICHERO_ASIGNATURA);
		this.gersorParseo.parseaFichero(Costantes.FICHERO_PERTENECE);
	}

}
