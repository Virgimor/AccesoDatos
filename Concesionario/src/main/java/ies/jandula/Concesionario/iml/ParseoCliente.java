package ies.jandula.Concesionario.iml;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoCliente;
import ies.jandula.Concesionario.models.Cliente;
import ies.jandula.Concesionario.repository.ClienteRepository;

@Service
public class ParseoCliente implements IParseoCliente{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		//Nos saltamos la cabecera
		scanner.nextLine();
		
		//Empezamos el bucle
		while(scanner.hasNextLine()){
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Cliente cliente = new Cliente();
			
			cliente.setNif(lineaDelFicheroTroceada[0]);
			cliente.setNombre(lineaDelFicheroTroceada[1]);
			cliente.setApellidos(lineaDelFicheroTroceada[2]);
			cliente.setDireccion(lineaDelFicheroTroceada[3]);
			cliente.setTelefono(lineaDelFicheroTroceada[4]);
			
			this.clienteRepository.saveAndFlush(cliente);
		}
		
	}

}
