package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
@Embeddable
public class CursoEtapaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4359842401873675090L;
	
	private Integer curso;
	
	private String etapa;
	

	public CursoEtapaId() {
		super();
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	
	

}
