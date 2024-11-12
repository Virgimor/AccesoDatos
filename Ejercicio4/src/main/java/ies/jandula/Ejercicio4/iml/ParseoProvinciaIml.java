package ies.jandula.Ejercicio4.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;
import ies.jandula.Ejercicio4.interfaces.IParseoProvincia;
import ies.jandula.Ejercicio4.models.Provincia;
import ies.jandula.Ejercicio4.models.Region;
import ies.jandula.Ejercicio4.repository.ProvinciaRepository;
import ies.jandula.Ejercicio4.repository.RegionRepository;

@Service
public class ParseoProvinciaIml implements IParseoProvincia{
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public void parseaFichero(Scanner scanner) throws Ejercicio4Excepcion {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Provincia provincia = new Provincia();
			provincia.setCodigoProvincia(Integer.valueOf(lineaDelFicheroTroceada[0]));
			provincia.setNombreProvinica(lineaDelFicheroTroceada[1]);
			Optional<Region> optionalRegion = this.regionRepository.findById(lineaDelFicheroTroceada[2]);
			
			provincia.setRegion(optionalRegion.get());
			
			this.provinciaRepository.saveAndFlush(provincia);
		}
		
	}

}
