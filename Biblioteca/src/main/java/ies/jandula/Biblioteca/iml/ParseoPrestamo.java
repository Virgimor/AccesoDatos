package ies.jandula.Biblioteca.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IParseoPrestamo;
import ies.jandula.Biblioteca.models.Libro;
import ies.jandula.Biblioteca.models.LibroId;
import ies.jandula.Biblioteca.models.Prestamo;
import ies.jandula.Biblioteca.models.PrestamoId;
import ies.jandula.Biblioteca.models.Usuario;
import ies.jandula.Biblioteca.repository.LibroRepository;
import ies.jandula.Biblioteca.repository.PrestamoRepository;
import ies.jandula.Biblioteca.repository.UsuarioRepository;
import ies.jandula.Biblioteca.utils.BibliotecaException;
import ies.jandula.Biblioteca.utils.DatesUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoPrestamo implements IParseoPrestamo{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	BibliotecaException bibliotecaException = new BibliotecaException();

	@Override
	public void parseaFichero(Scanner scanner) throws BibliotecaException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			PrestamoId prestamoId = new PrestamoId();
			
			try {
				prestamoId.setFechaPrestamo(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[0]));
			} catch (BibliotecaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			LibroId libroId = new LibroId();
			
			libroId.setTitulo(lineaDelFicheroTroceada[1]);
			libroId.setAutor(lineaDelFicheroTroceada[2]);
			libroId.setAnioPublicacion(Integer.valueOf(lineaDelFicheroTroceada[3]));
			
			Libro libro= new Libro();
			libro.setLibroId(libroId);
			
			Optional<Libro> optionalLibro = this.libroRepository.findById(libro);
			
			if(!optionalLibro.isPresent()) {
				
				log.error("No existe el profesor");
				throw new BibliotecaException("2", bibliotecaException);
			}
			
			prestamoId.setLibro(optionalLibro.get());
			
			Optional<Usuario> optionalUsuario = this.usuarioRepository.findById(lineaDelFicheroTroceada[4]);
			
			if(!optionalUsuario.isPresent()) {
				
				log.error("No existe el profesor");
				throw new BibliotecaException("2", bibliotecaException);
			}
			
			prestamoId.setUsuario(optionalUsuario.get());
			
			Prestamo prestamo = new Prestamo();
			
			prestamo.setPrestamoId(prestamoId);
			prestamo.setEstado(lineaDelFicheroTroceada[5]);
			
			this.prestamoRepository.saveAndFlush(prestamo);
		}
		
	}

}
