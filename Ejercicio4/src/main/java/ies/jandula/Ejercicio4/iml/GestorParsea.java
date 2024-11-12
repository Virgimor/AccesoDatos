package ies.jandula.Ejercicio4.iml;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio4.costantes.Costantes;
import ies.jandula.Ejercicio4.exception.Ejercicio4Excepcion;
import ies.jandula.Ejercicio4.interfaces.IGestorParseo;
import ies.jandula.Ejercicio4.interfaces.IParseoLocalidad;
import ies.jandula.Ejercicio4.interfaces.IParseoProvincia;
import ies.jandula.Ejercicio4.interfaces.IParseoRegion;

@Service
public class GestorParsea implements IGestorParseo{
	
	@Autowired
	private IParseoLocalidad iParseoLocalidad;
	
	@Autowired
	private IParseoProvincia iParseoProvincia;
	
	@Autowired
	private IParseoRegion iParseoRegion;

	@Override
	public void parseaFichero(String nombreFichero) throws Ejercicio4Excepcion {
		// TODO Auto-generated method stub
		
		switch (nombreFichero) {
			case Costantes.FICHERO_lOCALIDAD: 
				Scanner scannerLocalidad = this.abrirFichero(nombreFichero);
				
				this.iParseoLocalidad.parseaFichero(scannerLocalidad);
				
				scannerLocalidad.close();
				break;
				
			case Costantes.FICHERO_PROVINCIA:
				Scanner scannerProvincia = this.abrirFichero(nombreFichero);
				
				this.iParseoProvincia.parseaFichero(scannerProvincia);
				
				scannerProvincia.close();
				break;
				
			case Costantes.FICHERO_REGION:
				Scanner scannerRegion = this.abrirFichero(nombreFichero);
				
				this.iParseoRegion.parseaFichero(scannerRegion);
				
				scannerRegion.close();
				break;
				
			default:
				throw new Ejercicio4Excepcion("Unexpected value: " + nombreFichero);
		}
	}
		private File getFileFromResource(String nombreFichero) throws URISyntaxException{
			
			ClassLoader classLoader = getClass().getClassLoader() ;
	        
	        URL resource = classLoader.getResource(nombreFichero) ;
	        
	        if (resource == null)
	        {
	            throw new IllegalArgumentException("Fichero no encontrado! " + nombreFichero) ;
	        }

	        return new File(resource.toURI()) ;
			
		}
		
		private Scanner abrirFichero(String nombreFichero) throws Ejercicio4Excepcion{
			try
			{
				// Get file from resource
				File fichero = this.getFileFromResource(nombreFichero) ;
				
				return new Scanner(fichero) ;
			}
			catch (FileNotFoundException fileNotFoundException)
			{
				throw new Ejercicio4Excepcion("Fichero " + nombreFichero + " no encontrado!", fileNotFoundException) ;
			}
			catch (URISyntaxException uriSyntaxException)
			{
				throw new Ejercicio4Excepcion("Fichero " + nombreFichero + " no encontrado!", uriSyntaxException) ;
			}
			
		}

	
}
