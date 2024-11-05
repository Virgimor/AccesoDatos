package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Datos_bruto_alumno_matricula")
public class DatosBrutoAlumnoMatricula {
	
	@Id
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@Column(length = 100, nullable = false)
	private String asignatura;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso", referencedColumnName = "curso"),
		@JoinColumn(name = "etapa", referencedColumnName = "etapa"),
	})
	private CursoEtapa cursoEtapa;	
	

}
