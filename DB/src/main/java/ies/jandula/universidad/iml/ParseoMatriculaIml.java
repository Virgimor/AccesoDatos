package ies.jandula.universidad.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IParseoMatricula;
import ies.jandula.universidad.models.Alumno;
import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Curso;
import ies.jandula.universidad.models.Matricula;
import ies.jandula.universidad.models.MatriculaId;
import ies.jandula.universidad.repository.AlumnoRepository;
import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.CursoRepository;
import ies.jandula.universidad.repository.MatriculaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
	
	UniversidadException universidadException = new UniversidadException();

	@Override
	public void parseaFichero(Scanner scanner) throws UniversidadException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Matricula matricula = new Matricula();
			
			Optional<Alumno> optionaAlumno = this.alumnoRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[0]));
			//Si no existe lanza este error
			if(!optionaAlumno.isPresent()) {
				
				log.error("No existe el alumno");
				throw new UniversidadException("2", universidadException);
			}
			
			matricula.setIdAlumno(optionaAlumno.get());
			
			Optional<Asignatura> optionalAsignatura = this.asignaturaRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[1]));
			if(!optionalAsignatura.isPresent()) {
				
				log.error("No existe la asignatura");
				throw new UniversidadException("2", universidadException);
			}
			matricula.setIdAsignatura(optionalAsignatura.get());
			
			Optional<Curso> optionalCurso = this.cursoRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[2]));
			if(!optionalCurso.isPresent()) {
				
				log.error("No existe el curso");
				throw new UniversidadException("2", universidadException);
			}
			
			matricula.setIdCurso(optionalCurso.get());
			
			MatriculaId matriculaId = new MatriculaId(optionaAlumno.get().getId(),
													  optionalAsignatura.get().getId(),
													  optionalCurso.get().getId());
			matricula.setMatriculaId(matriculaId);
			
			this.matriculaRepository.saveAndFlush(matricula);
		}
		
	}

}
