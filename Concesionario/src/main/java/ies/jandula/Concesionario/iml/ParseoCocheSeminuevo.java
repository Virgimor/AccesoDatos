package ies.jandula.Concesionario.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoCoche;
import ies.jandula.Concesionario.interfaces.IParseoCocheSeminuevo;
import ies.jandula.Concesionario.models.Cliente;
import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.models.CocheSeminuevo;
import ies.jandula.Concesionario.repository.ClienteRepository;
import ies.jandula.Concesionario.repository.CocheSeminuevoRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoCocheSeminuevo implements IParseoCocheSeminuevo{
	
	@Autowired
	private CocheSeminuevoRepository cocheSeminuevoReposiroty;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private IParseoCoche iParseoCoche;

	ConcesionarioException concesionarioException = new ConcesionarioException();

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		//Nos saltamos la cabecera
		scanner.nextLine();
		
		// Scannea el fichero línea a línea mientras existan líneas disponibles.
		while(scanner.hasNextLine()) {
			 
			// Lee una línea completa del fichero.
			String lineaDelFichero = scanner.nextLine();
			
			// Divide la línea en partes, separadas por comas
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			// Llama al método parsearCoche de la interfaz para crear un objeto Coche a partir de los datos de la línea.
			Coche coche = this.iParseoCoche.parsearCoche(lineaDelFicheroTroceada) ;
			
			// Crea un objeto CocheSeminuevo utilizando el coche previamente parseado.
			CocheSeminuevo cocheSeminuevo = new CocheSeminuevo(coche);
			
			// Setea los kilometros recorridos, obtenidos de la sexta posicion de array
			cocheSeminuevo.setKilometrosRecorridos(Double.valueOf(lineaDelFicheroTroceada[5]));
			
			// Busca el cliente en el repositorio utilizando el NIF, obtenidos de la quinta posicion de array
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(lineaDelFicheroTroceada[4]);
			
			// Si el cliente no existe, lanza una excepción personalizada con un mensaje descriptivo.
			if(!optionalCliente.isPresent()) {
				String errorString = "Cliente no encontrado con NIF: " + lineaDelFicheroTroceada[4] ;
				log.error(errorString);
				throw new ConcesionarioException(1, errorString);
			}
			
			// Setea el nif del cliente asociado al coche seminuevo
			cocheSeminuevo.setNifCliente(optionalCliente.get());

			// Guarda el coche seminuevo en base de datos y actualiza su estado inmediatamente.
			this.cocheSeminuevoReposiroty.saveAndFlush(cocheSeminuevo);
		}
		
	}


}
