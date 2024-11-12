package ies.jandula.universidad.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IParseoAlumno;
import ies.jandula.universidad.models.Alumno;
import ies.jandula.universidad.repository.AlumnoRepository;
import ies.jandula.universidad.utils.DatesUtil;

@Service
public class ParseoAlumnoIml implements IParseoAlumno{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");			
			
			Alumno alumno = new Alumno();
			alumno.setId(Integer.valueOf(lineaDelFicheroTroceada[0]));
			alumno.setNif(lineaDelFicheroTroceada[1]);
			alumno.setNombre(lineaDelFicheroTroceada[2]);
			alumno.setApellido1(lineaDelFicheroTroceada[3]);
			alumno.setApellido2(lineaDelFicheroTroceada[4]);
			alumno.setCiudad(lineaDelFicheroTroceada[5]);
			alumno.setDireccion(lineaDelFicheroTroceada[6]);
			alumno.setTelefono(lineaDelFicheroTroceada[7]);
			try {
				alumno.setFechaNacimiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[8]));
			} catch (UniversidadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			alumno.setSexo(lineaDelFicheroTroceada[9]);
			
			this.alumnoRepository.saveAndFlush(alumno);
			
		}
	}

}
