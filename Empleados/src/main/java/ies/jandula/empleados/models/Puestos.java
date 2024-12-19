package ies.jandula.empleados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Puestos {
	
	@Id
	@Column(length = 10)
	private String idPuesto;
	
	@Column(length = 50)
	private String tituloPuesto;
	
	@Column(length = 6)
	private Float salarioMin;
	
	@Column(length = 6)
	private Float salarioMax;

}
