package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class AsignaturaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7293791064438845820L;
	
	private int curso;
	
	private String etapa;
	
	private String grupo;
	
	private String nombre;

	public AsignaturaId() {
		super();
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}


	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
