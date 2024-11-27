package ies.jandula.Biblioteca.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IParseoLibro;
import ies.jandula.Biblioteca.models.Libro;
import ies.jandula.Biblioteca.models.LibroId;
import ies.jandula.Biblioteca.models.Sala;
import ies.jandula.Biblioteca.repository.LibroRepository;
import ies.jandula.Biblioteca.repository.SalaRepository;
import ies.jandula.Biblioteca.utils.BibliotecaException;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoLibro implements IParseoLibro{
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	BibliotecaException bibliotecaException = new BibliotecaException();

	@Override
	public void parseaFichero(Scanner scanner) throws BibliotecaException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			LibroId libroId = new LibroId();
			
			libroId.setTitulo(lineaDelFicheroTroceada[0]);
			libroId.setAutor(lineaDelFicheroTroceada[1]);
			libroId.setAnioPublicacion(Integer.valueOf(lineaDelFicheroTroceada[2]));
			
			Libro libro= new Libro();
			libro.setLibroId(libroId);
			
			Optional<Sala> optionalLibro = this.salaRepository.findById(lineaDelFicheroTroceada[3]);
			
			if(!optionalLibro.isPresent()) {
				
				log.error("No existe el profesor");
				throw new BibliotecaException("2", bibliotecaException);
			}
			
			libro.setSala(optionalLibro.get());
			
			this.libroRepository.saveAndFlush(libro);
			
		}
		
	}

}
