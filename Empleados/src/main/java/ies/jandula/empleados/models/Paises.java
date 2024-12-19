package ies.jandula.empleados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Paises {
	
	@Id
	private Character idRegion;
	
	@Column(length = 40)
	private String nombrePais;

}
