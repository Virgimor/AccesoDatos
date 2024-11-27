package ies.jandula.Biblioteca.iml;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IGestorParseo;
import ies.jandula.Biblioteca.interfaces.IParseoLibro;
import ies.jandula.Biblioteca.interfaces.IParseoPrestamo;
import ies.jandula.Biblioteca.interfaces.IParseoRevista;
import ies.jandula.Biblioteca.interfaces.IParseoSala;
import ies.jandula.Biblioteca.interfaces.IParseoUsuario;
import ies.jandula.Biblioteca.utils.BibliotecaException;
import ies.jandula.Biblioteca.utils.Costantes;

@Service
public class GestorParseo implements IGestorParseo{
	
	@Autowired
	private IParseoUsuario iParseoUsuario;
	
	@Autowired
	private IParseoSala iParseoSala;
	
	@Autowired
	private IParseoRevista iParseoRevista;
	
	@Autowired
	private IParseoLibro iParseoLibro;
	
	@Autowired
	private IParseoPrestamo iParseoPrestamo;

	@Override
	public void parseaFichero(String nombreFichero) throws BibliotecaException {
		// TODO Auto-generated method stub
		
		switch(nombreFichero) {
			case Costantes.NOMBRE_FICHERO_USUARIO:
				Scanner scannerUsuario = this.abrirFichero(nombreFichero);
				
				this.iParseoUsuario.parseaFichero(scannerUsuario);
				
				scannerUsuario.close();
				break;
			case Costantes.NOMBRE_FICHERO_SALA:
				Scanner scannerSala = this.abrirFichero(nombreFichero);
				
				this.iParseoSala.parseaFichero(scannerSala);
				
				scannerSala.close();
				break;
				
			case Costantes.NOMBRE_FICHERO_REVISTA:
				Scanner scannerRevista = this.abrirFichero(nombreFichero);
				
				this.iParseoRevista.parseaFichero(scannerRevista);
				
				scannerRevista.close();
				break;
				
			case Costantes.NOMBRE_FICHERO_LIBRO:
				Scanner scannerLibro = this.abrirFichero(nombreFichero);
				
				this.iParseoLibro.parseaFichero(scannerLibro);
				
				scannerLibro.close();
				break;
			case Costantes.NOMBRE_FICHERO_PRESTAMO:
				Scanner scannerPrestamo = this.abrirFichero(nombreFichero);
				
				this.iParseoPrestamo.parseaFichero(scannerPrestamo);
				
				scannerPrestamo.close();
				break;
			default:
				throw new BibliotecaException(0, "Fichero" + nombreFichero + "no encontrado");
		}
		
	}
	
	private Scanner abrirFichero(String nombreFichero) throws BibliotecaException{
		try
		{
			// Get file from resource
			File fichero = this.getFileFromResource(nombreFichero) ;
			
			return new Scanner(fichero) ;
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			throw new BibliotecaException("Fichero " + nombreFichero + " no encontrado!", fileNotFoundException) ;
		}
		catch (URISyntaxException uriSyntaxException)
		{
			throw new BibliotecaException("Fichero " + nombreFichero + " no encontrado!", uriSyntaxException) ;
		}
		
	}
	
	private File getFileFromResource(String nombreFichero) throws URISyntaxException
	{
        ClassLoader classLoader = getClass().getClassLoader() ;
        
        URL resource = classLoader.getResource(nombreFichero) ;
        
        if (resource == null)
        {
            throw new IllegalArgumentException("Fichero no encontrado! " + nombreFichero) ;
        }

        return new File(resource.toURI()) ;
    }

}
