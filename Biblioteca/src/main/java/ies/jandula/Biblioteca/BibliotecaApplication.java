package ies.jandula.Biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ies.jandula.Biblioteca.interfaces.IGestorParseo;
import ies.jandula.Biblioteca.utils.Costantes;


@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	
	@Autowired
	private IGestorParseo parseoFicheros;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_USUARIO);
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_SALA);
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_REVISTA);
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_LIBRO);
		this.parseoFicheros.parseaFichero(Costantes.NOMBRE_FICHERO_PRESTAMO);
	}

}
