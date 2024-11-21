package ies.jandula.Concesionario.iml;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IGestorParseo;
import ies.jandula.Concesionario.interfaces.IParseoCliente;
import ies.jandula.Concesionario.interfaces.IParseoCoche;
import ies.jandula.Concesionario.interfaces.IParseoMecanico;
import ies.jandula.Concesionario.interfaces.IParseoReparar;
import ies.jandula.Concesionario.interfaces.iParseoDescuento;
import ies.jandula.Concesionario.utils.Costantes;

@Service
public class GestorParseo implements IGestorParseo{
	
	/*@Autowired
	private IParseoCocheNuevo iParseoCocheNuevo;
	
	@Autowired
	private IParseoCocheSeminuevo iParseoCocheSeminuevo;*/
	
	@Autowired
	private IParseoCoche iParseoCoche;
	
	@Autowired
	private IParseoCliente iParseoCliente;
	
	@Autowired
	private iParseoDescuento iParseoDescuento;
	
	@Autowired
	private IParseoMecanico iParseroMecanico;
	
	@Autowired
	private IParseoReparar iParseoReparar;

	@Override
	public void parseoFichero(String nombreFichero) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		switch(nombreFichero) {
		case Costantes.FICHERO_CLIENTE:
				Scanner scannerCliente = this.abrirFichero(nombreFichero);
				
				this.iParseoCliente.parsearFichero(scannerCliente);
				
				scannerCliente.close();
				break;
				
			/*case Costantes.FICHERO_COCHE_NUEVO:
				Scanner scannerCocheNuevo = this.abrirFichero(nombreFichero);
				
				this.iParseoCocheNuevo.parsearFichero(scannerCocheNuevo);
				
				scannerCocheNuevo.close();
				break;
				
			case Costantes.FICHERO_COCHE_SEMINUEVO:
				Scanner scannerCocheSeminuevo = this.abrirFichero(nombreFichero);
				
				this.iParseoCocheSeminuevo.parsearFichero(scannerCocheSeminuevo);
				
				scannerCocheSeminuevo.close();
				break;*/
				
			case Costantes.FICHERO_DESCUENTO:
				Scanner scannerDescuento = this.abrirFichero(nombreFichero);
				
				this.iParseoDescuento.parsearFichero(scannerDescuento);
				
				scannerDescuento.close();
				break;
				
			case Costantes.FICHERO_MECANICO:
				Scanner scannerMecanico = this.abrirFichero(nombreFichero);
				
				this.iParseroMecanico.parsearFichero(scannerMecanico);
				
				scannerMecanico.close();
				break;
				
			case Costantes.FICHERO_REPARAR:
				Scanner scannerReparaciones = this.abrirFichero(nombreFichero);
				
				this.iParseoReparar.parsearFichero(scannerReparaciones);
				
				scannerReparaciones.close();
				break;
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
	
	private Scanner abrirFichero(String nombreFichero) throws ConcesionarioException{
		try
		{
			// Get file from resource Coje el fichero de la clase anterior
			File fichero = this.getFileFromResource(nombreFichero) ;
			//Devuelve el fechero escaneado
			return new Scanner(fichero) ;
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			throw new ConcesionarioException("Fichero " + nombreFichero + " no encontrado!", fileNotFoundException) ;
		}
		catch (URISyntaxException uriSyntaxException)
		{
			throw new ConcesionarioException("Fichero " + nombreFichero + " no encontrado!", uriSyntaxException) ;
		}
		
	}

}
