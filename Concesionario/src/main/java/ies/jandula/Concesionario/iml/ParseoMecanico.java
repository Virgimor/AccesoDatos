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
	
	@Autowired
	private MecanicoRepository mecanicoRepository;

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Mecanico mecanico = new Mecanico();
			
			mecanico.setDni(lineaDelFicheroTroceada[0]);
			mecanico.setNombre(lineaDelFicheroTroceada[1]);
			mecanico.setApellidos(lineaDelFicheroTroceada[2]);
			mecanico.setSalario(Double.valueOf(lineaDelFicheroTroceada[3]));
			try {
				mecanico.setFechaContratacion(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[4]));
			}
			catch (ConcesionarioException concesionarioException) {
				// TODO: handle exception
				concesionarioException.printStackTrace();
			}
			this.mecanicoRepository.saveAndFlush(mecanico);
			
		}
		
	}

}
