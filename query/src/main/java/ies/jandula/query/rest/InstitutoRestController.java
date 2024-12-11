package ies.jandula.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.query.models.Alumno;
import ies.jandula.query.repository.AlumnoRepository;

@RestController

public class InstitutoRestController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@GetMapping("/obtenerAlumno")
	public Page<Alumno> obtenerAlumno(@PageableDefault(size=10, sort = "id") Pageable pageable){
		return this.alumnoRepository.findAll(pageable);
		
	}

}
