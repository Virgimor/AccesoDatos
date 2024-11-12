package ies.jandula.universidad.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.interfaces.IParseoAsignatura;
import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Grado;
import ies.jandula.universidad.models.Profesor;
import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.GradoRepository;
import ies.jandula.universidad.repository.ProfesorRepository;

@Service
public class ParseoAsignaturaIml implements IParseoAsignatura{
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private GradoRepository gradoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String [] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Asignatura asignatura = new Asignatura();
			
			asignatura.setId(Integer.valueOf(lineaDelFicheroTroceada[0]));
			asignatura.setNombre(lineaDelFicheroTroceada[1]);
			asignatura.setCreditos(Double.valueOf(lineaDelFicheroTroceada[2]));
			asignatura.setTipo(lineaDelFicheroTroceada[3]);
			asignatura.setCurso(Integer.valueOf(lineaDelFicheroTroceada[4]));
			asignatura.setCuatrimestre(Integer.valueOf(lineaDelFicheroTroceada[5]));
			
			Optional<Profesor> optionalProfesor = this.profesorRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[6]));
			asignatura.setIdProfesor(optionalProfesor.get());
			
			Optional<Grado> optionalGrado = this.gradoRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[7]));
			asignatura.setIdGrado(optionalGrado.get());
			
			this.asignaturaRepository.saveAndFlush(asignatura);
		}
		
	}

}
