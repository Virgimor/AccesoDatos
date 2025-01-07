package ies.jandula.empleados.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta28 {
	
	private String nombreEmpleado;
	
	private Character idPais;
	
	private BigDecimal salario;

}
