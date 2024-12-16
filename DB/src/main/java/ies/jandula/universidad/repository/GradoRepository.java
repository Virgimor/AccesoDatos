package ies.jandula.universidad.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.universidad.dtos.GradoDto;
import ies.jandula.universidad.models.Grado;

public interface GradoRepository extends JpaRepository<Grado, Integer>{
	
	@Query("SELECT new ies.jandula.universidad.dtos.GradoDto(g.nombre, COUNT(m)) "
			+ "FROM Grado g JOIN Asignatura a ON a.idGrado.id = g.id JOIN Matricula m ON m.idAsignatura.id = a.id GROUP BY g")
	Page<GradoDto> encontrarGradoConNumeroAprobados(Pageable pageable);
	
}
