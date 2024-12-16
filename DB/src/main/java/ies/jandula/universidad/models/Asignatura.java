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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "matriculas")
public class Asignatura {
	
	@Id
	@Column(length = 10)
	private Integer id;
	
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
	private List<Matricula> matriculas;


}
