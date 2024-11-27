package ies.jandula.Biblioteca.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IParseoRevista;
import ies.jandula.Biblioteca.models.Revista;
import ies.jandula.Biblioteca.models.RevistaId;
import ies.jandula.Biblioteca.models.Usuario;
import ies.jandula.Biblioteca.repository.RevistaRepository;
import ies.jandula.Biblioteca.repository.UsuarioRepository;
import ies.jandula.Biblioteca.utils.BibliotecaException;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoRevista implements IParseoRevista{
	
	@Autowired
	private RevistaRepository revistaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	BibliotecaException bibliotecaException = new BibliotecaException();

	@Override
	public void parseaFichero(Scanner scanner) throws BibliotecaException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			RevistaId revistaId=new RevistaId();
			revistaId.setTitulo(lineaDelFicheroTroceada[0]);
			revistaId.setEditorial(lineaDelFicheroTroceada[1]);
			
			Revista revista = new Revista();
			revista.setRevistaId(revistaId);
			revista.setFrecuencia_publicacion(lineaDelFicheroTroceada[2]);
			
			Optional<Usuario> optionalUsuario = this.usuarioRepository.findById(lineaDelFicheroTroceada[3]);
			if(!optionalUsuario.isPresent()) {
				
				log.error("No existe el profesor");
				throw new BibliotecaException("2", bibliotecaException);
			}
			revista.setUsuario(optionalUsuario.get());
			
			this.revistaRepository.saveAndFlush(revista);
			
		}
		
	}

}
