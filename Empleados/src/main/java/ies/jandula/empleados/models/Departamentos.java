package ies.jandula.empleados.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Departamentos {
	
	@Id
	@Column(precision = 4)
	private BigDecimal idDepartamento;
	
	@Column(length = 30, nullable = false)
	private String nombreDepartamento;
	
	@Column(precision = 6)
	private BigDecimal idGerente;
	
	@ManyToOne
	@JoinColumn(name = "id_ubicacion", referencedColumnName = "idUbicacion")
	private Ubicaciones ubicaciones;

}
