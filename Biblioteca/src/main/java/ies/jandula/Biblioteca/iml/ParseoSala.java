package ies.jandula.Biblioteca.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IParseoSala;
import ies.jandula.Biblioteca.models.Sala;
import ies.jandula.Biblioteca.repository.SalaRepository;
import ies.jandula.Biblioteca.utils.BibliotecaException;

@Service
public class ParseoSala implements IParseoSala{
	
	@Autowired
	private SalaRepository salaRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws BibliotecaException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Sala sala = new Sala();
			
			sala.setNombre(lineaDelFicheroTroceada[0]);
			sala.setCapacidad(Integer.valueOf(lineaDelFicheroTroceada[1]));
			
			this.salaRepository.saveAndFlush(sala);
			
		}
		
	}

}
