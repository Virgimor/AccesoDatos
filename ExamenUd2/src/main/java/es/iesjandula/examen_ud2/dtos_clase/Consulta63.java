package es.iesjandula.examen_ud2.dtos_clase;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta63 {
	
	private String nombreEmpleado;

	private Date fechaInicio;

	private Date fechaFin;
	
	private String idPuesto;
	
	private BigDecimal idDepartamento;

	
}
