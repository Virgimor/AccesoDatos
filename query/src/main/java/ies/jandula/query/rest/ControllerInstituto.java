package ies.jandula.query.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.query.repository.AlumnoRepository;
import ies.jandula.query.repository.NacionalidadRepository;
import ies.jandula.query.repository.TutorRepository;
import jakarta.annotation.PostConstruct;

@Service
public class ControllerInstituto {
	
	@Autowired
	 private AlumnoRepository alumnoRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	//cuando se crea una intancia de controllerInstituto
	@PostConstruct
	public void init() {
		
//		System.out.println("Encuentra a los alumnos que contengan un dni especifco");
//		System.out.println(this.alumnoRepository.findByNif("123456789A"));
		
//		System.out.println("Encontrar a los alumnos que contenga un 1 en su nif");
//		System.out.println(this.alumnoRepository.findByNifContaining("1"));
		
//		System.out.println("Encontrar a los alumnos que tendan menos de 20 años");
//		System.out.println(this.alumnoRepository.findByEdadLessThan(20));
		
//		System.out.println("Encuentra a los alumnos que esten aprobados");
//		System.out.println(this.alumnoRepository.findByAprobadoTrue());
		
//		System.out.println("Encuentra a los alumnos que esten suspenso");
//		System.out.println(this.alumnoRepository.findByAprobadoFalse());
		
//		System.out.println("Encuentra a los alumnos por direccion y edad");
//		System.out.println(this.alumnoRepository.findByDireccionAndEdad("Calle Amapola 1", 10));

//		System.out.println("Encuentra a los alumnos por direccion o edad");
//		System.out.println(this.alumnoRepository.findByDireccionOrEdad("Calle Amapola 1", 10));
		
//		System.out.println("Encuentra a los alumnos por su nif ordenados por la edad de forma ascendente");
//		System.out.println(this.alumnoRepository.findByNifOrderByEdadAsc("123456789A"));
		
//		System.out.println("Encuentra a los alumnos por su nif ordenados por la edad de forma descendente");
//		System.out.println(this.alumnoRepository.findByNifOrderByEdadDesc("123456789A"));
		
//		System.out.println("Encuentra los 10 primeros alumnos por nif ordenador por la edad de forma descendente");
//		System.out.println(this.alumnoRepository.findTop10ByNifOrderByEdadDesc("123456789A"));
		
//		System.out.println("Encuentra a los alumnos que esten entre dos edades especificas");
//		System.out.println(this.alumnoRepository.findByEdadBetween(20, 30));
		
//		System.out.println("Encuentra a los alumnos que tengan el mismo nif pero lo demas sea distinto");
//		System.out.println(this.alumnoRepository.findDistinctByNif("123456789A"));
		
//		QUERYS CON SELECT
		
//		System.out.println("Encontrar Alumno por direccion Especifica");
//		System.out.println(this.alumnoRepository.encontrarPorDireccion("Calle Amapola 1"));
		
//		System.out.println("Encontrar alumno por la direccion que contenga algo que le indiquemos");
//		System.out.println(this.alumnoRepository.encontrarPorDireccionQueContiene("3"));
		
//		System.out.println("Encontrar Alumno cuando la edad sea menor que la especificada");
//		System.out.println(this.alumnoRepository.encontrarPorEdadMenorQue(20));
		
//		System.out.println("Encontrar los alumnos que esten aprobados");
//		System.out.println(this.alumnoRepository.encontrarPorAprobados());
		
//		System.out.println("Encontrar los alumnos que esten suspensos");
//		System.out.println(this.alumnoRepository.encontrarPorSuspensos());
		
//		System.out.println("Encontrar los alumnos que tengas una direccion y una edad especifica");
//		System.out.println(this.alumnoRepository.encontrarDireccionYEdad("Calle Amapola 3", 25));
		
//		System.out.println("Encontrar los alumnos que tengas una direccion o una edad especifica");
//		System.out.println(this.alumnoRepository.encontrarDireccionOEdad("Calle Amapola 3", 35));
		
//		System.out.println("Encontrar una direccion Especifica ordenada de forma ascendente");
//		System.out.println(this.alumnoRepository.encontrarDireccionOrdenadoPorEdadAsc("Calle Amapola 3"));
		
//		System.out.println("Encontrar una direccion Especifica ordenada de forma descendente");
//		System.out.println(this.alumnoRepository.encontrarDireccionOrdenadoPorEdadDesc("Calle Amapola 3"));
		
//		System.out.println("Encuentra los 10 primeros por orden de edad ascendente");
//		System.out.println(this.alumnoRepository.encuentra10PrimerosOrdenadosPorEdadAsc());
		
//		System.out.println("Encuentra las direcciones que sean distintas");
//		System.out.println(this.alumnoRepository.encontrarDireccionesDistintas());
		
//		System.out.println("Buscar alumno por direccion ignorando si es mayuscula o minuscula");
//		System.out.println(this.alumnoRepository.encontrarPorDireccionIgnardoMayusculas("calle amapola 3"));
		
//		System.out.println("Encontrar alumno entre dos edades");
//		System.out.println(this.alumnoRepository.encontrarAlumnoEntre2Edades(10, 25));
		
//		QUERYS CON JOIN
		
//		System.out.println("Alumnos con un tutor específica");
//		System.out.println(this.alumnoRepository.encontrarPorElNombreDelTutor("Juan"));
		
//		System.out.println("Alumnos de un tutor especifico y ordenarlos por edad");
//		System.out.println(this.alumnoRepository.encontrarPorElNombreDelTutorOrdenadorPorEdadAsc("Juan"));
		
//		System.out.println("Tutor de un Alumno por su nif");
//		System.out.println(this.tutorRepository.encontrarTutorPorNifAlumnoEspecifico("123456789A"));
		
//		System.out.println("Tutores que tengan más de 3 Alumnos");
//		System.out.println(this.tutorRepository.encontrarTutoresCon3oMasAlumnos());
		
//		System.out.println("Edad promedio de los Alumnos de un tutor");
//		System.out.println(this.alumnoRepository.edadPromedioAlumnosDeTutorEspecifico("Juan"));
		
//		System.out.println("Número de alumnos de un tutor");
//		System.out.println(this.alumnoRepository.numeroAlumnosDeTutorEspecifico("Juan"));
		
//		System.out.println("Edad promedio de los alumnos agrupados por tutor");
//		System.out.println(this.alumnoRepository.edadPromedioAlumnosAgrupadosPorTutor());
		
//		System.out.println("Número de alumnos por tutor, pero solo de aquellas que tienen más de 3 alumnos");
//		System.out.println(this.alumnoRepository.numeroAlumnosDeTutorEspecificoConMasDe3Alumnos());
//		
//		System.out.println("Suma de las edades de los alumnos de un tutor");
//		System.out.println(this.alumnoRepository.sumaEdadesAlumnosDeTutorEspecifico("Juan"));
		
//		QUERYS PACO
		
//		System.out.println("Encontrar a los alumnos que tengan un tutor especifico");
//		System.out.println(this.alumnoRepository.encontrarAlumnoPorTutor("Laura"));
//		
//		System.out.println("Encontrar a los tutores que tengas alumnos mayores de 18 años");
//		System.out.println(this.tutorRepository.encontrarTutoresConAlumnosMayores18());
//		
//		System.out.println("Encontrar los tutores que tengan como alumno con un nif especifico");
//		System.out.println(this.tutorRepository.encontrarTutorPorNifAlumno("123456789B"));
//		
//		System.out.println("Encuentra los alumnos cuyos tutores tienen más de 2 alumnos asignados");
//		System.out.println(this.alumnoRepository.encontrarAlumnosPorTutorCuandoTenga2OMas());
//		
//		System.out.println("Media de edad de los alumnos");
//		System.out.println(this.alumnoRepository.mediaEdadDeLosAlumnos());
//		
//		System.out.println("Cuenta cuántos alumnos de Española tienen como tutor a pepe");
//		System.out.println(this.alumnoRepository.cuantosAlumnosEspaniolesYPepeComoTutor("Española", "Luisa"));
//		
//		System.out.println("Dime el mentor con más alumnos que tengan como un tutor especifico");
//		System.out.println(this.alumnoRepository.mentorConMasAlumnosConTutorEspecifico("Luisa"));
//		
//		System.out.println("Busca los alumnos que no tienen mentor ni tampoco tutor que sean españoles");
//		System.out.println(this.alumnoRepository.alumnosSinTutoYSinMentor("Española"));
		
//		System.out.println("Dime el tutor cuyo alumnos asociado no tenga mentor");
//		System.out.println(this.tutorRepository.encontrarTutor());
		
		System.out.println("Dime la nacionalidad de aquellos alumnos con nif especifico que tienen mentor pero no tutor");
		System.out.println(this.nacionalidadRepository.encontrarNacionalidad("123456789A"));
	}

}
