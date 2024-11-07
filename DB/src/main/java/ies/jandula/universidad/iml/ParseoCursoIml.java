package ies.jandula.universidad.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.interfaces.IParseoCurso;
import ies.jandula.universidad.models.Curso;
import ies.jandula.universidad.repository.CursoRepository;

@Service
public class ParseoCursoIml implements IParseoCurso{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()){
			
			String lineaDelFichero = scanner.nextLine();
			
			String [] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Curso curso = new Curso();
			
			curso.setId(Long.valueOf(lineaDelFicheroTroceada[0]));
			curso.setAnyoInicio(Integer.valueOf(lineaDelFicheroTroceada[1]));
			curso.setAnyoFin(Integer.valueOf(lineaDelFicheroTroceada[2]));
			
			this.cursoRepository.saveAndFlush(curso);
		}
		
	}
	

}
