package ies.jandula.Concesionario.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoMecanico;
import ies.jandula.Concesionario.models.Mecanico;
import ies.jandula.Concesionario.repository.MecanicoRepository;
import ies.jandula.Concesionario.utils.DatesUtil;

@Service
public class ParseoMecanico implements IParseoMecanico{
	
	// Inyección automática del repositorio de mecánicos.
	@Autowired
	private MecanicoRepository mecanicoRepository;

	// Implementación del método definido en la interfaz IParseoMecanico.
	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		//Nos saltamos la cabecera
		scanner.nextLine();
		
		//Inicia un bucle para procesar cada línea del fichero.
		while(scanner.hasNextLine()) {
			
			// Lee una línea completa del fichero.
			String lineaDelFichero = scanner.nextLine();
			
			// Divide la línea en partes, separadas por comas
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			// Crea un nuevo objeto Mecanico.
			Mecanico mecanico = new Mecanico();
			
			// Setea el dni del mecanico obtenido de la primera posicion de arrya
			mecanico.setDni(lineaDelFicheroTroceada[0]);
			// Setea el nombre del mecanico obtenido de la segunda posicion de arrya
			mecanico.setNombre(lineaDelFicheroTroceada[1]);
			// Setea el apellidos del mecanico obtenido de la tercera posicion de arrya
			mecanico.setApellidos(lineaDelFicheroTroceada[2]);
			// Setea el salario del mecanico obtenido de la cuarta posicion de arrya
			mecanico.setSalario(Double.valueOf(lineaDelFicheroTroceada[3]));
			
			// Convierte la fecha de contratación desde una cadena de texto al formato de fecha.
			try {
				mecanico.setFechaContratacion(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[4]));
			}
			catch (ConcesionarioException concesionarioException) {
				
				// Maneja la excepción si la conversión de la fecha falla.
				concesionarioException.printStackTrace();
			}
			
			//Guarda el mecanico en base de datos y actualiza su estado inmediatamente
			this.mecanicoRepository.saveAndFlush(mecanico);
			
		}
		
	}

}
