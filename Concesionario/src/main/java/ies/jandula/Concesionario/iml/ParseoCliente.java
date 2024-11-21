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
	
	// Inyección automática del repositorio de clientes.
	@Autowired
	private ClienteRepository clienteRepository;

	// Implementación del método definido en la interfaz IParseoCliente.
	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		//Nos saltamos la cabecera
		scanner.nextLine();
		
		//Inicia un bucle para procesar cada línea del fichero.
		while(scanner.hasNextLine()){
			
			// Lee una línea completa del fichero.
			String lineaDelFichero = scanner.nextLine();
			
			// Divide la línea en partes, separadas por comas
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			// Crea un nuevo objeto Cliente.
			Cliente cliente = new Cliente();
			
			//setea el nif del cliente obtenidos de la primera posicion de array
			cliente.setNif(lineaDelFicheroTroceada[0]);
			//setea el nombre del cliente obtenidos de la segunda posicion de array
			cliente.setNombre(lineaDelFicheroTroceada[1]);
			//setea los apellidos del cliente obtenidos de la tercera posicion de array
			cliente.setApellidos(lineaDelFicheroTroceada[2]);
			//setea la direccion del cliente obtenidos de la cuarta posicion de array
			cliente.setDireccion(lineaDelFicheroTroceada[3]);
			//setea el telefono del cliente obtenidos de la quinta posicion de array
			cliente.setTelefono(lineaDelFicheroTroceada[4]);
			
			//guarda el cliente en base de datos y actualiza su estado inmediatamente.
			this.clienteRepository.saveAndFlush(cliente);
		}
		
	}

}
