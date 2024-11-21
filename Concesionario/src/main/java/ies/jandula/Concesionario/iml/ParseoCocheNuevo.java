package ies.jandula.Concesionario.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoCoche;
import ies.jandula.Concesionario.interfaces.IParseoCocheNuevo;
import ies.jandula.Concesionario.models.Cliente;
import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.models.CocheNuevo;
import ies.jandula.Concesionario.repository.ClienteRepository;
import ies.jandula.Concesionario.repository.CocheNuevoReposiroty;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoCocheNuevo implements IParseoCocheNuevo{
	
	@Autowired
	private CocheNuevoReposiroty cocheNuevoReposiroty;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private IParseoCoche iParseoCoche;

	ConcesionarioException concesionarioException = new ConcesionarioException();

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			 
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Coche coche = this.iParseoCoche.parsearCoche(lineaDelFicheroTroceada);
			
			CocheNuevo cocheNuevo = new CocheNuevo(coche);
			
			cocheNuevo.setUnidadesExistentes(Integer.valueOf(lineaDelFicheroTroceada[5]));
			
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(lineaDelFicheroTroceada[4]);
			if(!optionalCliente.isPresent()) {
				String errorString = "Cliente no encontrado con NIF: " + lineaDelFicheroTroceada[4] ;
				log.error(errorString);
				throw new ConcesionarioException(1, errorString);
			}
			
			cocheNuevo.setNifCliente(optionalCliente.get());
			
			cocheNuevoReposiroty.saveAndFlush(cocheNuevo);
		}
		
	}

	

}
