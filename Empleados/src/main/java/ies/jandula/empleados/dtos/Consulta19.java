package ies.jandula.empleados.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta19 {
	
	private String nombreEmpleado;
	
	private BigDecimal comision;
	
	private String nombreDepartamento;

}
