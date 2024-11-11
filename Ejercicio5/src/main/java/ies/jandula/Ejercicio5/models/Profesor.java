package ies.jandula.Ejercicio5.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profesor {
	
	@Id
	@Column(nullable = false)
	private Integer idProfesor;
	
	@Column(length = 9, unique = true)
	private String dni;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String especialidad;
	
	@Column
	private Integer telefono;
	
	@OneToMany(mappedBy = "profesor")
	private List<Asignatura> asignatura;

}
