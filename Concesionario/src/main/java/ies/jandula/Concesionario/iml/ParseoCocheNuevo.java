package ies.jandula.Concesionario.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.repository.ClienteRepository;
import ies.jandula.Concesionario.repository.CocheRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ParseoCocheNuevo {
	
	@Autowired
	private CocheRepository cocheRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	ConcesionarioException concesionarioException = new ConcesionarioException();

	

}
