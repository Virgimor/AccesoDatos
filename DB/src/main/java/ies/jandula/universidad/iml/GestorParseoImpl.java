package ies.jandula.universidad.iml;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.universidad.exception.UniversidadException;
import ies.jandula.universidad.interfaces.IGestorParseo;
import ies.jandula.universidad.interfaces.IParseoAlumno;
import ies.jandula.universidad.interfaces.IParseoAsignatura;
import ies.jandula.universidad.interfaces.IParseoCurso;
import ies.jandula.universidad.interfaces.IParseoDepartamento;
import ies.jandula.universidad.interfaces.IParseoGrado;
import ies.jandula.universidad.interfaces.IParseoMatricula;
import ies.jandula.universidad.interfaces.IParseoProfesor;
import ies.jandula.universidad.utils.Costantes;

@Service
public class GestorParseoImpl implements IGestorParseo{
	
	@Autowired
	private IParseoAlumno parseoAlumno;
	
	@Autowired
	private IParseoAsignatura parseoAsignatura;
	
	@Autowired
	private IParseoCurso parseoCurso;
	
	@Autowired
	private IParseoDepartamento parseoDepartamento;
	
	@Autowired
	private IParseoGrado parseoGrado;
	
	@Autowired
	private IParseoMatricula parseoMatricula;
	
	@Autowired
	private IParseoProfesor pareoProfesor;

	@Override
	public void parseaFichero(String nombreFichero) throws UniversidadException {
		// TODO Auto-generated method stub
		
		switch(nombreFichero) {
			case Costantes.NOMBRE_FICHERO_ASIGNATURA:
				Scanner scannerAsignatura = this.abrirFichero(nombreFichero);
				
				this.parseoAsignatura.parseaFichero(scannerAsignatura);
				
				scannerAsignatura.close();
				break;
			
			case Costantes.NOMBRE_FICHERO_CURSO:
				Scanner scannerCurso = this.abrirFichero(nombreFichero);
				this.parseoCurso.parseaFichero(scannerCurso);
				
				scannerCurso.close();
				break;
			
			case Costantes.NOMBRE_FICHERO_ALUMNO:
				Scanner scannerAlumno = this.abrirFichero(nombreFichero);
				this.parseoAlumno.parseaFichero(scannerAlumno);
				
				scannerAlumno.close();
				break;
				
			case Costantes.NOMBRE_FICHERO_DEPARTAMENTO:
				Scanner scannerDepartamento = this.abrirFichero(nombreFichero);
				this.parseoDepartamento.parseaFichero(scannerDepartamento);
				
				scannerDepartamento.close();
				break;
				
			case Costantes.NOMBRE_FICHERO_GRADO:
				Scanner scannerGrado = this.abrirFichero(nombreFichero);
				this.parseoGrado.parseaFichero(scannerGrado);
				
				scannerGrado.close();
				break;
			
			case Costantes.NOMBRE_FICHERO_MATRICULA:
				Scanner scannerMatricula = this.abrirFichero(nombreFichero);
				this.parseoMatricula.parseaFichero(scannerMatricula);
								
				scannerMatricula.close();
				break;
				
			case Costantes.NOMBRE_FICHERO_PROFESOR:
				Scanner scannerProfesor = this.abrirFichero(nombreFichero);
				this.pareoProfesor.parseaFichero(scannerProfesor);
				
				scannerProfesor.close();
				break;
				
			default:
				throw new UniversidadException(4, "Fichero" + nombreFichero + "no encontrado");
		}
	}
	
	private Scanner abrirFichero(String nombreFichero) throws UniversidadException{
		try
		{
			// Get file from resource
			File fichero = this.getFileFromResource(nombreFichero) ;
			
			return new Scanner(fichero) ;
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			throw new UniversidadException(5, "Fichero " + nombreFichero + " no encontrado!", fileNotFoundException) ;
		}
		catch (URISyntaxException uriSyntaxException)
		{
			throw new UniversidadException(6, "Fichero " + nombreFichero + " no encontrado!", uriSyntaxException) ;
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
