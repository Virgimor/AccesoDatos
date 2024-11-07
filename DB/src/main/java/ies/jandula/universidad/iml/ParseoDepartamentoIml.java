package ies.jandula.universidad.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.interfaces.IParseoDepartamento;
import ies.jandula.universidad.models.Departamento;
import ies.jandula.universidad.repository.DepartamentoRepository;

@Service
public class ParseoDepartamentoIml implements IParseoDepartamento{
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) { //hasNextLine: mientras sigan quedando lineas
			
			String lineaDelFichero = scanner.nextLine(); //escanea el fichero y lo guarda en la variable
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Departamento departamento = new Departamento();
			
			departamento.setId(Long.valueOf(lineaDelFicheroTroceada[0]));
			departamento.setNombre(lineaDelFicheroTroceada[1]);
			
			this.departamentoRepository.saveAndFlush(departamento);
		}
		
	}

}
