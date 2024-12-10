package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.models.Nacionalidad;

public interface NacionalidadRepository extends JpaRepository<Nacionalidad, String>{

	@Query("SELECT n FROM Nacionalidad n JOIN n.listaAlumno alu WHERE alu.nif = :nif AND alu.tutor is null AND alu.mentor is not null")
	List<Nacionalidad> encontrarNacionalidad(@Param("nif") String nif);
}
