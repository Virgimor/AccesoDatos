package ies.jandula.Biblioteca.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Biblioteca.interfaces.IParseoUsuario;
import ies.jandula.Biblioteca.models.Usuario;
import ies.jandula.Biblioteca.repository.UsuarioRepository;
import ies.jandula.Biblioteca.utils.BibliotecaException;
import ies.jandula.Biblioteca.utils.DatesUtil;

@Service
public class ParseoUsuario implements IParseoUsuario{
	
	@Autowired(required = true)
	private UsuarioRepository usuarioRepository;

	@Override
	public void parseaFichero(Scanner scanner) {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");	
			Usuario usuario = new Usuario();
			
			usuario.setEmail(lineaDelFicheroTroceada[0]);
			usuario.setNombre(lineaDelFicheroTroceada[1]);
			
			try {
				usuario.setFecha(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[2]));
			} catch (BibliotecaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.usuarioRepository.saveAndFlush(usuario);
			
		}
		
	}

}
