package ies.jandula.universidad.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.dtos.DepartamentoAsignaturasDto;
import ies.jandula.universidad.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	Page<DepartamentoAsignaturasDto> nombreDepartamenconYNAsignaturas(Pageable pageable);

}
