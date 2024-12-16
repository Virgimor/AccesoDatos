package ies.jandula.universidad.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoAsignaturasDto {
	
	private String nombreDepartamento;
	
	private long nAsignaturas;

}
