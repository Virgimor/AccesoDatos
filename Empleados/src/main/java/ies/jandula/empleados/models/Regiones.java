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
public class Regiones {
	
	@Id
	@Column(precision =  10)
	private BigDecimal idRegion;
	
	@Column(length = 25)
	private String nombreRegion;

}
