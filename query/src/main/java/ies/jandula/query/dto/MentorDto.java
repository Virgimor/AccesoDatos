package ies.jandula.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {
	
	private Long id;
	
	private String nif;
	
	private Integer edad;
	
	private String direccion;
	
	private Boolean aprobado;
	
}
