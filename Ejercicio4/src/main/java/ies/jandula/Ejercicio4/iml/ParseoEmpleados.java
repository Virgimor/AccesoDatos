package ies.jandula.Ejercicio4.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;
import ies.jandula.Ejercicio4.interfaces.IParseoEmpeados;
import ies.jandula.Ejercicio4.models.Empleado;
import ies.jandula.Ejercicio4.models.EmpleadoId;
import ies.jandula.Ejercicio4.models.Localidad;
import ies.jandula.Ejercicio4.repository.EmpleadosRepository;
import ies.jandula.Ejercicio4.repository.LocalidadRepository;

@Service
public class ParseoEmpleados implements IParseoEmpeados{
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Autowired
	private LocalidadRepository localidadRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws Ejercicio4Excepcion {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Empleado empleados = new Empleado();
			Optional<EmpleadoId> optionalIdEmpleado = Optional.ofNullable(this.empleadosRepository.findByIdEmpleadoAndDniEmpleado(Integer.valueOf(lineaDelFicheroTroceada[0]) , lineaDelFicheroTroceada[1]));
			empleados = optionalIdEmpleado.orElse(new Empleado());
			empleados.setEmpleadoId(optionalIdEmpleado);
			empleados.setNombre(lineaDelFicheroTroceada[2]);
			empleados.setTelefono(Integer.valueOf(lineaDelFicheroTroceada[3]));
			empleados.setSalario(Double.valueOf(lineaDelFicheroTroceada[4]));
			Optional<Localidad> optionalLocalidad = this.localidadRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[5]));
			
			empleados.setLocalidad(optionalLocalidad.get());
			
			this.empleadosRepository.saveAndFlush(empleados);
			
		}
	}

}
