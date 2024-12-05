package ies.jandula.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.query.repository.AlumnoRepository;
import ies.jandula.query.repository.TutorRepository;
import jakarta.annotation.PostConstruct;

@Service
public class ControllerInstituto {
	
	@Autowired
	 private AlumnoRepository alumnoRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	//cuando se crea una intancia de controllerInstituto
	@PostConstruct
	public void init() {
//		System.out.println(this.alumnoRepository.findByNif("123456789A"));
		
		//System.out.println(this.usuarioRepository.findByNifContaining("1"));
		//System.out.println(this.usuarioRepository.findByAprobadoFalse());
		//System.out.println(this.usuarioRepository.findByAprobadoTrue());
		//System.out.println(this.usuarioRepository.findByEdadOrderByEdadAsc(10));
		//System.out.println(this.usuarioRepository.findTop10ByDireccionOrderByEdadDesc("1"));
		
		//System.out.println(this.usuarioRepository.findByEdadBetween(20, 30));
		
//		System.out.println(this.alumnoRepository.findByNif("55667788E"));
//		System.out.println(this.alumnoRepository.findByNifContaining("1"));
//		System.out.println(this.alumnoRepository.findByAprobadoTrue());
//		System.out.println(this.alumnoRepository.findByAprobadoFalse());
//		System.out.println(this.alumnoRepository.findByEdadOrderByEdadAsc(10));
//		System.out.println(this.alumnoRepository.findTop10ByNifOrderByEdadDesc("50"));
//		System.out.println(this.alumnoRepository.findByEdadBetween(15, 20));
//	
//		System.out.println(this.alumnoRepository.findNifByDireccion("Calle"));
				
//		System.out.println(this.alumnoRepository.encontrarPorDireccion("Calle Amapola 1"));
//		System.out.println(this.alumnoRepository.encontrarPorDireccionQueContiene("3"));
//		System.out.println(this.alumnoRepository.encontrarPorEdadMenorQue(20));
//		System.out.println(this.alumnoRepository.encontrarPorAprobados());
//		System.out.println(this.alumnoRepository.encontrarPorSuspensos());
//		System.out.println(this.alumnoRepository.encontrarDireccionYEdad("Calle Amapola 3", 25));
//		System.out.println(this.alumnoRepository.encontrarDireccionOEdad("Calle Amapola 3", 35));
//		System.out.println(this.alumnoRepository.encontrarDireccionOrdenadoPorEdadAsc("Calle Amapola 3"));
		
//		System.out.println(this.alumnoRepository.encontrarLos10PrimerosOrdenadosAsc());
//		System.out.println(this.alumnoRepository.encontrarPorDireccionDistintos("Calle Amapola 1"));
//		System.out.println(this.alumnoRepository.encontrarAlumnoPorTutor("Laura"));
//		System.out.println(this.alumnoRepository.encontrarAlumnoPorTutor("Laura"));
//		System.out.println(this.tutorRepository.encontrarTutorPorNifAlumno("123456789B"));
//		System.out.println(this.alumnoRepository.encontrarAlumnosPorTutorCuandoTenga2OMas());
//		System.out.println(this.alumnoRepository.mediaEdadDeLosAlumnos());
		
		System.out.println("Cuenta cuántos alumnos de Española tienen como tutor a pepe");
		System.out.println(this.alumnoRepository.cuantosAlumnosEspaniolesYPepeComoTutor("Luisa", "Española"));
		
//		System.out.println("Dime el mentor con más alumnos que tengan como tutor a pepe");
//		System.out.println(this.alumnoRepository.mentorConMasAlumnosConTutorEspecifico("Luisa", "Española"));
	}

}
