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
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoProfesorIml implements IParseoProfesor{
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws UniversidadException {
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
			
			if(!optionalDepartamento.isPresent()) {
				
				UniversidadException universidadException= new UniversidadException();
				log.error("No existe el departamento");
				throw new UniversidadException("2", universidadException);
				
			}
			
			profesor.setIdDepartamento(optionalDepartamento.get());
			
			this.profesorRepository.saveAndFlush(profesor);
		}
		
	}

}
