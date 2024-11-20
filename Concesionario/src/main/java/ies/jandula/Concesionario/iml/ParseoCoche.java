package ies.jandula.Concesionario.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoCoche;
import ies.jandula.Concesionario.models.Cliente;
import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.repository.ClienteRepository;
import ies.jandula.Concesionario.repository.CocheRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoCoche implements IParseoCoche{
	
	@Autowired
	private CocheRepository cocheRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	ConcesionarioException concesionarioException = new ConcesionarioException();

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Coche coche = new Coche();
			
			coche.setMatricula(lineaDelFicheroTroceada[0]);
			coche.setColor(lineaDelFicheroTroceada[1]);
			coche.setMarca(lineaDelFicheroTroceada[2]);
			coche.setModelo(lineaDelFicheroTroceada[3]);
			
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(lineaDelFicheroTroceada[4]);
			
			if(!optionalCliente.isPresent()) {
				
				log.error("No existe el curso");
				throw new ConcesionarioException("1", concesionarioException);
			}
			
			coche.setCliente(optionalCliente.get());
			
			this.cocheRepository.saveAndFlush(coche);
			
		}
		
	}

}
