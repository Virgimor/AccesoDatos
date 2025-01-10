package ies.jandula.empleados.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class HistorialPuestosId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5726856051806586730L;
	
	private Date fechaInicio;

	private BigDecimal empleados;

}
