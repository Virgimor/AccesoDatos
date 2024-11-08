package ies.jandula.universidad.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asignatura {
	
	@Id
	@Column(length = 10)
	private Long id;
	
	@Column
	private Double creditos;
	
	@Column
	private int cuatrimestre;
	
	@Column
	private int curso;
	
	@Column(length = 80, nullable = false)
	private String nombre;
	
	@Column(length = 45, nullable = false)
	private String tipo;
	
	@ManyToOne
	private Grado idGrado;
	
	@ManyToOne
	private Profesor idProfesor;
	
	@OneToMany(mappedBy = "idAsignatura")
	private List<Matricula> matricula;


}
