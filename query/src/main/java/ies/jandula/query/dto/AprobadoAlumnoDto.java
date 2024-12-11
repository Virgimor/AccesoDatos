package ies.jandula.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AprobadoAlumnoDto {
	
	private String pais;
	private Long aprobados;

}
