package ies.jandula.Ejercicio1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
	
	@Id
	@Column(length = 9, nullable = false)
	private String dni;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 100)
	private String apellidos;

}
