package es.iesjandula.examen_ud2.dtos_clase;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta45 {
	
	private String tituloPuesto;
	
	private BigDecimal salarioMin;
	
	private long numeroEmpleados;

}
