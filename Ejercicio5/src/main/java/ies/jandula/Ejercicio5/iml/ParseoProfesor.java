package ies.jandula.Ejercicio5.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;
import ies.jandula.Ejercicio5.interfaces.IParseoProfesor;
import ies.jandula.Ejercicio5.models.Profesor;
import ies.jandula.Ejercicio5.repository.ProfesorRepository;

@Service
public class ParseoProfesor implements IParseoProfesor{
	
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void parseaFicheros(Scanner scanner) throws Ejercicio5Exception {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Profesor profesor = new Profesor();
			
			profesor.setIdProfesor(Integer.valueOf(lineaDelFicheroTroceada[0]));
			profesor.setDni(lineaDelFicheroTroceada[1]);
			profesor.setNombre(lineaDelFicheroTroceada[2]);
			profesor.setEspecialidad(lineaDelFicheroTroceada[3]);
			profesor.setTelefono(Integer.valueOf(lineaDelFicheroTroceada[4]));
			
			this.profesorRepository.saveAndFlush(profesor);
		}
		
	}

}
