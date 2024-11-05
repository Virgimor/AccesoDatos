package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Alumno")
public class Alumno {
	
	@Id
	private int id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100, nullable = false)
	private String apellidos;

}
