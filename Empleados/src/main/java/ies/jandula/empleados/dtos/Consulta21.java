package ies.jandula.empleados.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta21 {
	
	private String nombreEmpleado;
	
	private BigDecimal salario;
	
	private String nombreDepartamento;

}
