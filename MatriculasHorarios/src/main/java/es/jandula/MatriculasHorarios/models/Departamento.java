package es.jandula.MatriculasHorarios.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
	@Column(length = 100)
	private String nombre;
	
	@OneToMany(mappedBy = "departamentoPropietario")
	private List<Asignatura> asignaturaPropietario;
	
	@OneToMany(mappedBy = "departamentoReceptor")
	private List<Asignatura> asignaturaReceptor;

	public Departamento() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
