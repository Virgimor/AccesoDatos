package ies.jandula.Concesionario.iml;

import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.interfaces.IParseoCoche;
import ies.jandula.Concesionario.models.Coche;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoCocheIml implements IParseoCoche {

	@Override
	public Coche parsearCoche(String[] valores) {
		// TODO Auto-generated method stub
		Coche coche = new Coche();

		coche.setMatricula(valores[0]);
		coche.setColor(valores[1]);
		coche.setMarca(valores[2]);
		coche.setModelo(valores[3]);

		log.info("Nuevo coche creado {}", coche) ;
		
		return coche;
	}

}
