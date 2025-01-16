package ies.jandula.empleados.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta97 {
	
	private String nombreDepartamento;
	
    private Integer anio;
    
    private Long cantidadCambios;
}
