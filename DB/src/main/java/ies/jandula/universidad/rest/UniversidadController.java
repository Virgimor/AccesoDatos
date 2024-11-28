package ies.jandula.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;

@Service
public class UniversidadController {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	
	@PostConstruct
	public void init() {
		//Buscar profesores de género masculino
		//System.out.println(this.profesorRepository.findBySexo("M"));
		
		//Buscar los 10 profesores más viejos
//		System.out.println(this.profesorRepository.findTop10ByOrderByFechaNacimientoDesc());
		
		//Buscar las 10 asignaturas con menos créditos de un profesor concreto
		//System.out.println(this.profesorRepository.findTop10ByFechaNacimientoDesc("Ramirez"));
		
	}
}
