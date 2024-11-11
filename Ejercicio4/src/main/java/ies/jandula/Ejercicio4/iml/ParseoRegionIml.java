package ies.jandula.Ejercicio4.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;
import ies.jandula.Ejercicio4.interfaces.IParseoRegion;
import ies.jandula.Ejercicio4.models.Region;
import ies.jandula.Ejercicio4.repository.RegionRepository;

public class ParseoRegionIml implements IParseoRegion{
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws Ejercicio4Excepcion {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Region region = new Region();
			region.setNombreRegion(lineaDelFicheroTroceada[0]);
			
			this.regionRepository.saveAndFlush(region);
		
		}
		
	}

}
