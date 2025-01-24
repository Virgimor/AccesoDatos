package es.iesjandula.examen_ud2.dtos_clase;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta77 {
	
	private String nombreEmpleado;
	
	private String nombrePais;

	private Date fechaGerente;

	private Date fechaEmpleado;

	
}
