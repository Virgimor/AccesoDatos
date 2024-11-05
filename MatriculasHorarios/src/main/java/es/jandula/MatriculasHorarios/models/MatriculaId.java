package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MatriculaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8190860470095335301L;
	
	@Column(name = "asignatura_curso", insertable=false, updatable=false)
	private int asignaturaCurso;
	
	@Column(name = "asignatura_etapa",length = 50, insertable=false, updatable=false)
	private String asignaturaEtapa;
	
	@Column(name = "asignatura_grupo" ,length = 2, insertable=false, updatable=false)
	private String asignaturaGrupo;
	
	@Column(name = "asignatura_nombre" ,length = 100, insertable=false, updatable=false)
	private String asignaturaNombre;
	
	private int alumnoId;


}
