package ies.jandula.Ejercicio6.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Proyectos {
	
	@Id
	private Integer codigo;
	
	@Column(length = 100)
	private String descripcion;

}
