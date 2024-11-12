package ies.jandula.Ejercicio4.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;
import ies.jandula.Ejercicio4.interfaces.IParseoLocalidad;
import ies.jandula.Ejercicio4.models.Localidad;
import ies.jandula.Ejercicio4.models.Provincia;
import ies.jandula.Ejercicio4.repository.LocalidadRepository;
import ies.jandula.Ejercicio4.repository.ProvinciaRepository;

@Service
public class ParseoLocalidadIml implements IParseoLocalidad{
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws Ejercicio4Excepcion {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Localidad localidad = new Localidad();
			
			localidad.setCodigoLocalidad(Integer.valueOf(lineaDelFicheroTroceada[0]));
			localidad.setNombre(lineaDelFicheroTroceada[1]);
			
			Optional<Provincia> optionalProvicional = this.provinciaRepository.findById(Integer.valueOf(lineaDelFicheroTroceada[2]));
			
			localidad.setProvincia(optionalProvicional.get());
			
			this.localidadRepository.saveAndFlush(localidad);
		}
		
	}

}
