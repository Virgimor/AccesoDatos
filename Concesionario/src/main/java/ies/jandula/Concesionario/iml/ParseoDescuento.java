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


@Service
public class ParseoDescuento implements iParseoDescuento{
	
	@Autowired
	private DescuentoRepository descuentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub
		
		scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String lineaDelFichero = scanner.nextLine();
			
			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			Descuento descuento = new Descuento();
			
			int anio= Integer.valueOf(lineaDelFicheroTroceada[0]);
			
			String nif= String.valueOf(lineaDelFicheroTroceada[1]);
			
			DescuentoId descuentoId = new DescuentoId(anio, nif);
			
			descuentoId.setAnio(anio);
			
			descuento.setDescuentoId(descuentoId);
			descuento.setImporteDescuento(Double.valueOf(lineaDelFicheroTroceada[2]));
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(lineaDelFicheroTroceada[1]);
			
			descuento.setNifCliente(optionalCliente.get());
			
			this.descuentoRepository.saveAndFlush(descuento);
			
		}
		
	}

}
