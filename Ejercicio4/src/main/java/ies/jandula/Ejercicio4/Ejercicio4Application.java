package ies.jandula.Ejercicio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ies.jandula.Ejercicio4.costantes.Costantes;
import ies.jandula.Ejercicio4.interfaces.IGestorParseo;
import ies.jandula.Ejercicio4.interfaces.IParseo;

@SpringBootApplication
public class Ejercicio4Application implements CommandLineRunner{
	
	@Autowired
	private IGestorParseo gestorParseo;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.gestorParseo.parseaFichero(Costantes.FICHERO_REGION);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_PROVINCIA);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_lOCALIDAD);
		
	}

}