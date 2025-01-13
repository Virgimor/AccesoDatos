package ies.jandula.empleados.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta64 {
	
	private BigDecimal nombreEmpleado;

	private Date fechaInicio;

	private Date fechaFin;
	
	private BigDecimal idDepartamento;

	private String nombrePuesto;
	
}
