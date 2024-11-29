package ies.jandula.universidad.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IParseoMatricula;
import ies.jandula.universidad.service.MatriculaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoMatriculaIml implements IParseoMatricula{
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Override
	public void parseaFichero(Scanner scanner) throws UniversidadException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			int alumnoId=Integer.valueOf(lineaDelFicheroTroceada[0]);
			int asignaturaId=Integer.valueOf(lineaDelFicheroTroceada[1]);
			int cursoId=Integer.valueOf(lineaDelFicheroTroceada[2]);
			
			this.matriculaService.insertarMatricula(alumnoId, asignaturaId, cursoId);
		}
		
	}

}
