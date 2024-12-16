package ies.jandula.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.query.models.Alumno;
import ies.jandula.query.models.Ejemplo;
import ies.jandula.query.models.Nacionalidad;
import ies.jandula.query.repository.AlumnoRepository;
import ies.jandula.query.repository.EjemploRepository;
import ies.jandula.query.repository.NacionalidadRepository;

@RestController

public class InstitutoRestController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	@Autowired
	private EjemploRepository ejemploRepository;
	
	@GetMapping("/obtenerAlumno")
	public Page<Alumno> obtenerAlumno(@PageableDefault(size=5, sort = "id") Pageable pageable){
		
		return this.alumnoRepository.findAll(pageable);
		
	}
	
	@GetMapping("/nacionalidades")
	public Page<Nacionalidad> obtenerNacionalidades(
			@PageableDefault(size = 5,sort = "nacionalidad") Pageable pageable)
	{
		return nacionalidadRepository.findAll(pageable);
	}
	
	@GetMapping("/obtenerEjemplo")
	public Page<Ejemplo> obtenerEjemplo(@PageableDefault(size=10, sort = "id") Pageable pageable){
		return this.ejemploRepository.findAll(pageable);
		
	}

}
