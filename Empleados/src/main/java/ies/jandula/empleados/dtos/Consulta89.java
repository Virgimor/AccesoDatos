package ies.jandula.empleados.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta89 {
	
	private String nombreEmpleado;

	private String tituloPuesto;
	
	private BigDecimal salario;
}
