package ies.jandula.universidad.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradoDto {
	
	private String nombre;
	
	private long numeroMatriculas;

}
