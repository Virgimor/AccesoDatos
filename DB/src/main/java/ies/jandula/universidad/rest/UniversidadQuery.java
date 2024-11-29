package ies.jandula.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.models.Departamento;
import ies.jandula.universidad.models.Profesor;
import ies.jandula.universidad.repository.AsignaturaRepository;
import ies.jandula.universidad.repository.DepartamentoRepository;
import ies.jandula.universidad.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;

@Service
public class UniversidadQuery {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@PostConstruct
	public void init() {
		Profesor profesor = new Profesor();
		profesor.setId(2);
		//Buscar profesores de género masculino
//		System.out.println(this.profesorRepository.findBySexo("M"));
		
		//Buscar los 10 profesores más viejos
//		System.out.println(this.profesorRepository.findTop10ByOrderByFechaNacimientoDesc());
		
		//Buscar las 10 asignaturas con menos créditos de un profesor concreto
//		System.out.println(this.asignaturaRepository.findTop10ByIdProfesorOrderByCreditosDesc(profesor));
		
		//Buscar asignaturas con más de 5 créditos
		//System.out.println(this.asignaturaRepository.findByCreditosGreaterThan(5));
		
		//Buscar los 5 profesores más jóvenes (por fecha de nacimiento descendente):
//		System.out.println(this.profesorRepository.findTop5ByOrderByFechaNacimientoDesc());
		
		//Buscar asignaturas impartidas por un profesor específico, ordenadas alfabéticamente por su nombre:
//		System.out.println(this.asignaturaRepository.findByIdProfesorOrderByNombreAsc(profesor));
		
		//Buscar asignaturas con nombres que contengan una palabra específica (búsqueda parcial):
//		System.out.println(this.asignaturaRepository.findByNombreContaining("Cál"));
		
		//Buscar todos los profesores de un departamento específico:
		Departamento departamento = new Departamento();
		departamento.setId(1);
//		System.out.println(this.profesorRepository.findByIdDepartamento(departamento));
		
		//Buscar las 3 asignaturas con más créditos:
		//System.out.println(this.asignaturaRepository.findTop3ByOrderByCreditosDesc());
		
		//Buscar profesores con nombres que comiencen con una letra específica:
		System.out.println(this.profesorRepository.findByNombreStartingWith("M"));
	}
}
