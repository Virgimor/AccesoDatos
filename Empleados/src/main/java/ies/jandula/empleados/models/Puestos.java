package ies.jandula.empleados.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Puestos {
	
	@Id
	@Column(length = 10)
	private String idPuesto;
	
	@Column(length = 50, nullable = false)
	private String tituloPuesto;
	
	@Column(precision = 6, scale = 0)
	private BigDecimal salarioMin;
	
	@Column(precision = 6, scale = 0)
	private BigDecimal salarioMax;

}
