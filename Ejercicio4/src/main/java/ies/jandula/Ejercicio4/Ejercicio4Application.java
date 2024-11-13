package ies.jandula.Ejercicio4;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ies.jandula.Ejercicio4.costantes.Costantes;
import ies.jandula.Ejercicio4.interfaces.IGestorParseo;


@SpringBootApplication
public class Ejercicio4Application implements CommandLineRunner{
	
	@Autowired
	private IGestorParseo gestorParseo;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio4Application.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//String fichero = "src" + File.separator + "main" + File.separator +  "resources" + File.separator + "departamentos.csv";
		//Scanner scanner = new Scanner(fichero);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_REGION);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_PROVINCIA);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_lOCALIDAD);
		this.gestorParseo.parseaFichero(Costantes.FICHERO_EMPLEADOS);
	}

}
