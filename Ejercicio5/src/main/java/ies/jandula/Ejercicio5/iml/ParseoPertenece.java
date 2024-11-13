package ies.jandula.Ejercicio5.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;
import ies.jandula.Ejercicio5.interfaces.IParseoPertenece;
import ies.jandula.Ejercicio5.models.Alumno;
import ies.jandula.Ejercicio5.models.Asignatura;
import ies.jandula.Ejercicio5.models.Pertenece;
import ies.jandula.Ejercicio5.repository.AlumnoRepository;
import ies.jandula.Ejercicio5.repository.AsignaturaRepository;
import ies.jandula.Ejercicio5.repository.PerteneceRepository;

@Service
public class ParseoPertenece implements IParseoPertenece{
	
	@Autowired
	private PerteneceRepository perteneceRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	

	@Override
	public void parseaFicheros(Scanner scanner) throws Ejercicio5Exception {
		// TODO Auto-generated method stub
		
scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Pertenece pertenece = new Pertenece();
			
			Optional<Alumno> optionalAlumno = this.alumnoRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[1]));
			pertenece.setAlumno(optionalAlumno.get());
			
			Optional<Asignatura> optionalAsignatura = this.asignaturaRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[1]));
			pertenece.setAsignatura(optionalAsignatura.get());
			
			pertenece.setCurso(lineaDelFicheroTroceada[2]);
			
			this.perteneceRepository.saveAndFlush(pertenece);
			
		}
		
	}

}
