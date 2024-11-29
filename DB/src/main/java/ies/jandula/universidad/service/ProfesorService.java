package ies.jandula.universidad.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.models.Departamento;
import ies.jandula.universidad.models.Profesor;
import ies.jandula.universidad.repository.DepartamentoRepository;
import ies.jandula.universidad.repository.ProfesorRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public void insertarProfesor(Integer id, String nif, String nombre, String apellido1, String apellido2,
			String ciudad, String direccion, String telefono, Date fechaNacimiento, String sexo,
			Integer idDepartamento) throws UniversidadException {
		
		Profesor profesor = new Profesor();
		
		profesor.setId(Integer.valueOf(id));
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setApellido1(apellido1);
		profesor.setApellido2(apellido2);
		profesor.setCiudad(ciudad);
		profesor.setDireccion(direccion);
		profesor.setTelefono(telefono);
		profesor.setFechaNacimiento(fechaNacimiento);
		profesor.setSexo(sexo);
		
		Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(idDepartamento);
		
		if(!optionalDepartamento.isPresent()) {
			
			log.error("No existe el departamento");
			throw new UniversidadException(7, "No existe el departamento");
			
		}
		
		profesor.setIdDepartamento(optionalDepartamento.get());
		
		this.profesorRepository.saveAndFlush(profesor);
	}

}
