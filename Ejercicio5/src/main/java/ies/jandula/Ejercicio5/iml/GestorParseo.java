package ies.jandula.Ejercicio5.iml;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Ejercicio5.exception.Ejercicio5Exception;
import ies.jandula.Ejercicio5.interfaces.IGersorParseo;
import ies.jandula.Ejercicio5.interfaces.IParseoAlumno;
import ies.jandula.Ejercicio5.interfaces.IParseoAsignatura;
import ies.jandula.Ejercicio5.interfaces.IParseoPertenece;
import ies.jandula.Ejercicio5.interfaces.IParseoProfesor;
import ies.jandula.Ejercicio5.utils.Costantes;

@Service
public class GestorParseo implements IGersorParseo{
	
	@Autowired
	private IParseoProfesor iParseoProfesor;
	
	@Autowired 
	private IParseoAlumno iParseoAlumno;
	
	@Autowired
	private IParseoAsignatura iParseoAsignatura;
	
	@Autowired
	private IParseoPertenece iParseoPertenece;
	

	@Override
	public void parseaFichero(String nombreFichero) throws Ejercicio5Exception {
		// TODO Auto-generated method stub
		
		switch (nombreFichero) {
			case Costantes.FICHERO_PROFESOR:
				Scanner scannerProfesor = this.abrirFichero(nombreFichero);
				
				this.iParseoProfesor.parseaFicheros(scannerProfesor);
				
				scannerProfesor.close();
				break;
				
			case Costantes.FICHERO_ALUMNO:
				Scanner scannerAlumno = this.abrirFichero(nombreFichero);
				this.iParseoAlumno.parseaFicheros(scannerAlumno);
				
				scannerAlumno.close();
				break;
				
			case Costantes.FICHERO_ASIGNATURA:
				Scanner scannerAsignatura= this.abrirFichero(nombreFichero);
				this.iParseoAsignatura.parseaFicheros(scannerAsignatura);
				
				scannerAsignatura.close();
				break;
				
			case Costantes.FICHERO_PERTENECE:
				Scanner scannerPertenece = this.abrirFichero(nombreFichero);
				this.iParseoPertenece.parseaFicheros(scannerPertenece);
				
				scannerPertenece.close();
				break;
				
			default:
				throw new Ejercicio5Exception("Unexpected value:" + nombreFichero);
		}
		
	}
	//Coge el archivo del recurso
	private File getFileFromResource (String nombreFichero) throws URISyntaxException{
		// Carga una clase
		ClassLoader classLoader = getClass().getClassLoader();
		// mete el nombre del fichero un una url
		URL resource = classLoader.getResource(nombreFichero);
		
		if(resource == null) {
			throw new IllegalArgumentException("Fichero no encontrado " + nombreFichero);
		}
		//devuelve un archivo con la direccion del archivo que queremos
		return new File(resource.toURI());
	}
	
	private Scanner abrirFichero(String nombreFichero) throws Ejercicio5Exception{
		
		try {
			//Coge el fichero de la clase anterior
			File fichero = this.getFileFromResource(nombreFichero);
			
			return new Scanner(fichero);
					
		} catch (FileNotFoundException fileNotFoundException) {
			// TODO: handle exception
			throw new Ejercicio5Exception("Fichero " + nombreFichero + " no encontrado!", fileNotFoundException);
		}catch (URISyntaxException uriSyntaxException) {
			
			throw new Ejercicio5Exception("Fichero " + nombreFichero + " no encontrado", uriSyntaxException);
		}
		
		
	}

}
