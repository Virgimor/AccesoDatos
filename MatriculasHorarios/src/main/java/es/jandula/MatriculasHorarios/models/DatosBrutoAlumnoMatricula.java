package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_bruto_alumno_matricula")
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
	

	public DatosBrutoAlumnoMatricula() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	

}
