package ies.jandula.universidad.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.interfaces.IParseoGrado;
import ies.jandula.universidad.models.Grado;
import ies.jandula.universidad.repository.GradoRepository;

@Service
public class ParseoGradoIml implements IParseoGrado{
	
	@Autowired
	private GradoRepository gradoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Grado grado = new Grado();
			
			grado.setId(Integer.valueOf(lineaDelFicheroTroceada[0]));
			grado.setNombre(lineaDelFicheroTroceada[1]);
			
			this.gradoRepository.saveAndFlush(grado);
		}
		
	}
	
	

}
