package ies.jandula.empleados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Regiones {
	
	@Id
	@Column(length = 10)
	private Float idRegion;
	
	@Column(length = 25)
	private String nombreRegion;

}
