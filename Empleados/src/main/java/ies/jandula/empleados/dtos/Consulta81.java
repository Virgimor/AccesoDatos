package ies.jandula.empleados.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta81 {
	
	private BigDecimal idEmpleado;
	
	private String nombreEmpleado;
	
	private String nombrePuesto;
	
	private String nombreDepartamento;

	private Date fechaInicio;

	private Date fechaFin;
	
}
