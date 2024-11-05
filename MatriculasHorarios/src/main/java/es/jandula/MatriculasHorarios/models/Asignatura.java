package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {
	
	@EmbeddedId
	private AsignaturaId asignatura;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_propietario", referencedColumnName = "nombre")
	private Departamento departamentoPropietario;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_receptor", referencedColumnName = "nombre")
	private Departamento departamentoReceptor;
	
	

	public Asignatura() {
		super();
	}

	public AsignaturaId getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaId asignatura) {
		this.asignatura = asignatura;
	}

	public Departamento getDepartamentoPropietario() {
		return departamentoPropietario;
	}

	public void setDepartamentoPropietario(Departamento departamentoPropietario) {
		this.departamentoPropietario = departamentoPropietario;
	}

	public Departamento getDepartamentoReceptor() {
		return departamentoReceptor;
	}

	public void setDepartamentoReceptor(Departamento departamentoReceptor) {
		this.departamentoReceptor = departamentoReceptor;
	}

	
}
