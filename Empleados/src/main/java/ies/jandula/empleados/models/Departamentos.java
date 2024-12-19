package ies.jandula.empleados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Departamentos {
	
	@Id
	@Column(length = 4)
	private Float idDepartamento;
	
	@Column(length = 30)
	private String nombreDepartamento;
	
	@Column(length = 6)
	private Float idGerente;

}
