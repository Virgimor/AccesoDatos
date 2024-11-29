package ies.jandula.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.universidad.dto.ProfesorDto;
import ies.jandula.universidad.exception.UniversidadException;
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/profesor", consumes = "{application/json}")
	public ResponseEntity<?> añadirProfesor(@RequestBody(required = true) ProfesorDto profesor, @RequestHeader (required = true)Integer idDepartamento) {
		
		try
		{
			this.profesorService.insertarProfesor(profesor.getId(), profesor.getNif(), profesor.getNombre(), profesor.getApellido1(), profesor.getApellido2(), 
					profesor.getCiudad(), profesor.getDireccion(), profesor.getTelefono(), profesor.getFechaNacimiento(), profesor.getSexo(), 
					idDepartamento);
			
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

}
