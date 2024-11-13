package ies.jandula.Ejercicio5.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;
import ies.jandula.Ejercicio5.interfaces.IParseoAlumno;
import ies.jandula.Ejercicio5.models.Alumno;
import ies.jandula.Ejercicio5.repository.AlumnoRepository;
import ies.jandula.Ejercicio5.utils.DatesUtil;

@Service
public class ParseoAlumno implements IParseoAlumno{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public void parseaFicheros(Scanner scanner) throws Ejercicio5Exception {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Alumno alumno = new Alumno();
			alumno.setNumMatricula(Integer.valueOf(lineaDelFicheroTroceada[0]));
			alumno.setNombre(lineaDelFicheroTroceada[1]);
			try {
				
				alumno.setFechaNacimiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[2]));
				
			} catch(Ejercicio5Exception e){
				e.printStackTrace();
			}
			alumno.setTelefono(Integer.valueOf(lineaDelFicheroTroceada[3]));
			
			this.alumnoRepository.saveAndFlush(alumno);
		}
		
	}

}
