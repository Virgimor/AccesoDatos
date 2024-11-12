package ies.jandula.universidad.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IParseoProfesor;
import ies.jandula.universidad.models.Departamento;
import ies.jandula.universidad.models.Profesor;
import ies.jandula.universidad.repository.DepartamentoRepository;
import ies.jandula.universidad.repository.ProfesorRepository;
import ies.jandula.universidad.utils.DatesUtil;

@Service
public class ParseoProfesorIml implements IParseoProfesor{
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String [] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Profesor profesor = new Profesor();
			
			profesor.setId(Integer.valueOf(lineaDelFicheroTroceada[0]));
			profesor.setNif(lineaDelFicheroTroceada[1]);
			profesor.setNombre(lineaDelFicheroTroceada[2]);
			profesor.setApellido1(lineaDelFicheroTroceada[3]);
			profesor.setApellido2(lineaDelFicheroTroceada[4]);
			profesor.setCiudad(lineaDelFicheroTroceada[5]);
			profesor.setDireccion(lineaDelFicheroTroceada[6]);
			profesor.setTelefono(lineaDelFicheroTroceada[7]);
			try {
				profesor.setFechaNacimiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[8]));
			} catch (UniversidadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			profesor.setSexo(lineaDelFicheroTroceada[9]);
			
			Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[10]));
			profesor.setIdDepartamento(optionalDepartamento.get());
			
			this.profesorRepository.saveAndFlush(profesor);
		}
		
	}

}
