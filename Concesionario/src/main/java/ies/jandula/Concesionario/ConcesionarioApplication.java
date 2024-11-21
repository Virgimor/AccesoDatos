package ies.jandula.Concesionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ies.jandula.Concesionario.interfaces.IGestorParseo;
import ies.jandula.Concesionario.utils.Costantes;


@SpringBootApplication
//@ComponentScan(basePackages = {"es.iesjandula.Concesionario"})
public class ConcesionarioApplication  implements CommandLineRunner{
	
	@Autowired
	private IGestorParseo gestorParseo;

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.gestorParseo.parseoFichero(Costantes.FICHERO_MECANICO);
		this.gestorParseo.parseoFichero(Costantes.FICHERO_CLIENTE);
		this.gestorParseo.parseoFichero(Costantes.FICHERO_COCHE_NUEVO);
		this.gestorParseo.parseoFichero(Costantes.FICHERO_COCHE_SEMINUEVO);
		this.gestorParseo.parseoFichero(Costantes.FICHERO_REPARAR);
		this.gestorParseo.parseoFichero(Costantes.FICHERO_DESCUENTO);
		
		
	}

}
