package ies.jandula.empleados.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta70 {
	
	private BigDecimal cantidadEmpleado;

	private String nombreDepartamento;

	private String nombreGerente;

	
}
