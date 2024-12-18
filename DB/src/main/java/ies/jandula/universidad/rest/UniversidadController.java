package ies.jandula.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.universidad.dto.ProfesorDto;
import ies.jandula.universidad.dtos.AlumnoProfesorDto;
import ies.jandula.universidad.dtos.GradoDto;
import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.repository.AlumnoRepository;
import ies.jandula.universidad.repository.GradoRepository;
import ies.jandula.universidad.repository.ProfesorRepository;
import ies.jandula.universidad.service.MatriculaService;
import ies.jandula.universidad.service.ProfesorService;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@NoArgsConstructor
@RequestMapping(value = "/universidad")
public class UniversidadController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@Autowired
	private GradoRepository gradoRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/matricula/{alumnoId}/{asignaturaId}/{cursoId}")
	public ResponseEntity<?> añadirMatricula(@PathVariable(value = "alumnoId") Integer alumnoId,
											@PathVariable(value = "asignaturaId") Integer asignaturaId,
											@PathVariable(value = "cursoId") Integer cursoId) {
		
		try
		{
			this.matriculaService.insertarMatricula(alumnoId, asignaturaId, cursoId);
			
			return ResponseEntity.ok().build() ;
			
		}
		catch (UniversidadException universidadException)
		{
			return ResponseEntity.status(400).body(universidadException.getBodyExceptionMessage()) ;
		}
		catch (Exception exception)
		{
			UniversidadException universidadException = new UniversidadException(100, "Excepción genérica", exception) ;
			
			log.error("Excepción genérica", exception) ;
			
			return ResponseEntity.status(500).body(universidadException.getBodyExceptionMessage()) ;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/profesor")
	public ResponseEntity<?> añadirProfesor(@RequestBody(required = true) ProfesorDto profesor, 
			@RequestHeader (name = "idDepartamento", required = true)Integer idDepartamento) throws UniversidadException{
		
		try
		{
			this.profesorService.insertarProfesor(profesor.getId(), profesor.getNif(), profesor.getNombre(), profesor.getApellido1(), profesor.getApellido2(), 
					profesor.getCiudad(), profesor.getDireccion(), profesor.getTelefono(), profesor.getFechaNacimiento(), profesor.getSexo(), 
					idDepartamento);
			
			return ResponseEntity.ok().build() ;
			
		}
		
		catch (Exception exception)
		{
			
			
			log.error("Excepción genérica", exception) ;
			
			return ResponseEntity.status(500).body(exception.getMessage()) ;
		}
	}
	
	//Dime el nombre del grado junto con el numero de matriculados
	@GetMapping("/grado")
	public Page<GradoDto> obtenerGrado(@PageableDefault(size=10) Pageable pageable){
		
		return this.gradoRepository.encontrarGradoConNumeroAprobados(pageable);
		
	}
	
	//Nombre de alumno y profesor que tenga la misma edad
	@GetMapping("/obtenerAlumnoYProfesor")
	public Page<AlumnoProfesorDto> obtenerAlumnoYProfesor(@PageableDefault(size=5) Pageable pageable){
		
		return this.profesorRepository.alumnoYProfesorMismaEdad(pageable);
		
	}
			
	//Dime el nombre del departamentro con el número de asignaturas que posee
//	@GetMapping("/grado")
//	public Page<GradoDto> obtenerGrado(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.gradoRepository.encontrarGradoConNumeroAprobados(pageable);
//		
//	}
			
	//Nombre y teléfono de alumno, y nombre y telefono del profesor que vivan en Andújar
//	@GetMapping("/grado")
//	public Page<GradoDto> obtenerGrado(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.gradoRepository.encontrarGradoConNumeroAprobados(pageable);
//		
//	}
			
	//Dame la información completa de matriculas, con el alumno (nombre y apellidos), asignatura (nombre y tipo) y curso (año inicio y año fin)
//	@GetMapping("/grado")
//	public Page<GradoDto> obtenerGrado(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.gradoRepository.encontrarGradoConNumeroAprobados(pageable);
//		
//	}
	
}
