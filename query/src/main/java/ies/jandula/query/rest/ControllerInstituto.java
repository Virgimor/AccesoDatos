package ies.jandula.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.query.repository.AlumnoRepository;
import jakarta.annotation.PostConstruct;

@Service
public class ControllerInstituto {
	
	@Autowired
	 private AlumnoRepository alumnoRepository;
	
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
		System.out.println(this.alumnoRepository.encontrarPorEdadMenorQue(20));
	}

}
