package ies.jandula.universidad.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.interfaces.IParseoMatricula;
import ies.jandula.universidad.models.Alumno;
import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Curso;
import ies.jandula.universidad.models.Matricula;
import ies.jandula.universidad.repository.AlumnoRepository;
import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.CursoRepository;
import ies.jandula.universidad.repository.MatriculaRepository;

@Service
public class ParseoMatriculaIml implements IParseoMatricula{
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Matricula matricula = new Matricula();
			
			Optional<Alumno> optionaAlumno = this.alumnoRepository.findById(Long.valueOf(lineaDelFicheroTroceada[0]));
			matricula.setIdAlumno(optionaAlumno.get());
			
			Optional<Asignatura> optionalAsignatura = this.asignaturaRepository.findById(Long.valueOf(lineaDelFicheroTroceada[1]));
			matricula.setIdAsignatura(optionalAsignatura.get());
			
			Optional<Curso> optionalCurso = this.cursoRepository.findById(Long.valueOf(lineaDelFicheroTroceada[2]));
			matricula.setIdCurso(optionalCurso.get());
			
			this.matriculaRepository.saveAndFlush(matricula);
		}
		
	}

}
