package ies.jandula.empleados.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta24 {
	
	private String nombreEmpleado;
	
	private Date fechaContrato;
	
	private BigDecimal salario;
	
	

}
