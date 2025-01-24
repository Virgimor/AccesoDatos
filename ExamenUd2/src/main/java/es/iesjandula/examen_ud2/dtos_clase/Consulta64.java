package es.iesjandula.examen_ud2.dtos_clase;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta64 {
	
	private BigDecimal idEmpleado;

	private Date fechaInicio;

	private Date fechaFin;
	
	private BigDecimal idDepartamento;

	private String nombrePuesto;
	
}
