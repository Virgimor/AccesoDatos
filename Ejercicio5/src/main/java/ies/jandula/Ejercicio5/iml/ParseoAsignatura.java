package ies.jandula.Ejercicio5.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;
import ies.jandula.Ejercicio5.interfaces.IParseoAsignatura;
import ies.jandula.Ejercicio5.models.Asignatura;
import ies.jandula.Ejercicio5.models.Profesor;
import ies.jandula.Ejercicio5.repository.AsignaturaRepository;
import ies.jandula.Ejercicio5.repository.ProfesorRepository;

@Service
public class ParseoAsignatura implements IParseoAsignatura{
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void parseaFicheros(Scanner scanner) throws Ejercicio5Exception {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Asignatura asignatura = new Asignatura();
			
			asignatura.setCodigoAsignatura(Integer.valueOf(lineaDelFicheroTroceada[0]));
			asignatura.setNombre(lineaDelFicheroTroceada[1]);
			
			Optional<Profesor> optionalProfesor = this.profesorRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[2]));
			asignatura.setProfesor(optionalProfesor.get());
			
			this.asignaturaRepository.saveAndFlush(asignatura);
			
		}
		
	}

}
