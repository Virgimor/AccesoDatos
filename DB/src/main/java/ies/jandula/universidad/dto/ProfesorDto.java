package ies.jandula.universidad.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {
	
	private Integer id;
	
	private String apellido1;
	
	private String apellido2;
	
	private String ciudad;
	
	private String direccion;
	
	private Date fechaNacimiento;
	
	private String nif;
	
	private String nombre;
	
	private String sexo;
	
	private String telefono;

}
