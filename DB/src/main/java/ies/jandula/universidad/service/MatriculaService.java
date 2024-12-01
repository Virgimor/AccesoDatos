package ies.jandula.universidad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.models.Alumno;
import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Curso;
import ies.jandula.universidad.models.Matricula;
import ies.jandula.universidad.models.MatriculaId;
import ies.jandula.universidad.repository.AlumnoRepository;
import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.CursoRepository;
import ies.jandula.universidad.repository.MatriculaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	public void insertarMatricula(int alumnoId, int asignaturaId, int cursoId) throws UniversidadException
	{
		Matricula matricula = new Matricula();

		Optional<Alumno> optionaAlumno = this.alumnoRepository.findById(Integer.valueOf(alumnoId));
		
		// Si no existe lanza este error
		if (!optionaAlumno.isPresent()) {

			log.error("No existe el alumno");
			throw new UniversidadException(2, "No existe el alumno");
		}

		matricula.setIdAlumno(optionaAlumno.get());

		Optional<Asignatura> optionalAsignatura = this.asignaturaRepository.findById(Integer.valueOf(asignaturaId));
		if (!optionalAsignatura.isPresent())
		{
			log.error("No existe la asignatura");
			throw new UniversidadException(3, "No existe la asignatura");
		}
		
		matricula.setIdAsignatura(optionalAsignatura.get());

		Optional<Curso> optionalCurso = this.cursoRepository.findById(Integer.valueOf(cursoId));
		if (!optionalCurso.isPresent())
		{
			log.error("No existe el curso");
			throw new UniversidadException(3, "No existe el curso");
		}

		matricula.setIdCurso(optionalCurso.get());

		MatriculaId matriculaId = new MatriculaId(optionaAlumno.get().getId(), optionalAsignatura.get().getId(),
				optionalCurso.get().getId());
		matricula.setMatriculaId(matriculaId);
		
		Optional<Matricula> matriculaOptional = this.matriculaRepository.findById(matriculaId) ;
//		if (matriculaOptional.isPresent())
//		{
//			log.error("La matrícula ya existe");
//			throw new UniversidadException(3, "La matrícula ya existe");
//		}

		this.matriculaRepository.saveAndFlush(matricula);
	}
}
