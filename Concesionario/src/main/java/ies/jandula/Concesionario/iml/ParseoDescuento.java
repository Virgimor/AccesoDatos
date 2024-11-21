package ies.jandula.Concesionario.iml;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.iParseoDescuento;
import ies.jandula.Concesionario.models.Cliente;
import ies.jandula.Concesionario.models.Descuento;
import ies.jandula.Concesionario.models.DescuentoId;
import ies.jandula.Concesionario.repository.ClienteRepository;
import ies.jandula.Concesionario.repository.DescuentoRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoDescuento implements iParseoDescuento{
	
	@Autowired
	private DescuentoRepository descuentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	ConcesionarioException concesionarioException= new ConcesionarioException();

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Descuento descuento = new Descuento();
			
			// Obtenemos el año del descuento a traves del primer elemento del array
			int anio= Integer.valueOf(lineaDelFicheroTroceada[0]);
			
			// Crear un objeto DescuentoId que representa la clave primaria compuesta.
			DescuentoId descuentoId = new DescuentoId(anio);
			
			// Setea el año en el objeto DescuentoId
			descuentoId.setAnio(anio);
			// Asignar el identificador al descuento.
			descuento.setDescuentoId(descuentoId);
			descuento.setImporteDescuento(Double.valueOf(lineaDelFicheroTroceada[2]));
			
			// Buscar al cliente asociado al descuento usando su NIF
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(lineaDelFicheroTroceada[1]);
			
			// Si el cliente no está presente, registrar un error y lanzar una excepción.
			if(!optionalCliente.isPresent()) {
				
				log.error("No existe el curso");
				throw new ConcesionarioException("1", concesionarioException);
			}
			descuento.setNifCliente(optionalCliente.get());
			
			this.descuentoRepository.saveAndFlush(descuento);
			
		}
		
	}

}
