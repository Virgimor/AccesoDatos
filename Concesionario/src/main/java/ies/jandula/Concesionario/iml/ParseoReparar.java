package ies.jandula.Concesionario.iml;

import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.jandula.Concesionario.exception.ConcesionarioException;
import ies.jandula.Concesionario.interfaces.IParseoReparar;
import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.models.Mecanico;
import ies.jandula.Concesionario.models.Reparar;
import ies.jandula.Concesionario.models.RepararId;
import ies.jandula.Concesionario.repository.CocheRepository;
import ies.jandula.Concesionario.repository.MecanicoRepository;
import ies.jandula.Concesionario.repository.RepararRepository;
import ies.jandula.Concesionario.utils.DatesUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ParseoReparar implements IParseoReparar {

	@Autowired
	private RepararRepository repararRepository;

	@Autowired
	private CocheRepository cocheRepository;

	@Autowired
	private MecanicoRepository mecanicoRepository;

	ConcesionarioException concesionarioException = new ConcesionarioException();

	@Override
	public void parsearFichero(Scanner scanner) throws ConcesionarioException {
		// TODO Auto-generated method stub

		scanner.nextLine();

		while (scanner.hasNextLine()) {

			String lineaDelFichero = scanner.nextLine();

			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

			Reparar reparar = new Reparar();

			String matriculaCoche = String.valueOf(lineaDelFicheroTroceada[0]);

			String dniMecanico = String.valueOf(lineaDelFicheroTroceada[1]);

			Date fechaReparacion = DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[2]);

			RepararId repararId = new RepararId(fechaReparacion);

			repararId.setFechaReparacion(fechaReparacion);

			reparar.setRepararId(repararId);
			Optional<Coche> optionalCoche = this.cocheRepository.findById(lineaDelFicheroTroceada[0]);

			if (!optionalCoche.isPresent()) {

				log.error("No existe el curso");
				throw new ConcesionarioException("1", concesionarioException);
			}

			reparar.setMatriculaCoche(optionalCoche.get());

			Optional<Mecanico> optionalMecanico = this.mecanicoRepository.findById(lineaDelFicheroTroceada[1]);

			if (!optionalMecanico.isPresent()) {

				log.error("No existe el curso");
				throw new ConcesionarioException("1", concesionarioException);
			}

			reparar.setDniMecanico(optionalMecanico.get());

			reparar.setHorasEnArreglar(Double.valueOf(lineaDelFicheroTroceada[3]));

			this.repararRepository.saveAndFlush(reparar);

		}

	}

}
