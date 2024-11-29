package ies.jandula.universidad.iml;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IParseoProfesor;
import ies.jandula.universidad.service.ProfesorService;
import ies.jandula.universidad.utils.DatesUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoProfesorIml implements IParseoProfesor{
	
	@Autowired
	private ProfesorService profesorService;
	
	@Override
	public void parseaFichero(Scanner scanner) throws UniversidadException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String [] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			int id= Integer.valueOf(lineaDelFicheroTroceada[0]);
			String nif= lineaDelFicheroTroceada[1] ;
			String nombre= lineaDelFicheroTroceada[2] ;
			String apellido1=lineaDelFicheroTroceada[3]  ;
			String apellido2=lineaDelFicheroTroceada[4] ; 
			String ciudad=lineaDelFicheroTroceada[5] ;
			String direccion=lineaDelFicheroTroceada[6] ; 
			String telefono=lineaDelFicheroTroceada[7] ;
			Date fechaNacimiento = DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[8]) ;			
			String sexo=lineaDelFicheroTroceada[9] ;
			
			Integer idDepartamento = Integer.valueOf(lineaDelFicheroTroceada[10]);
			
			
			this.profesorService.insertarProfesor(id, nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fechaNacimiento, sexo, idDepartamento);
			
			
		}
		
	}

}
