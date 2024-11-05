package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CursoEtapaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4359842401873675090L;
	
	private Integer curso;
	
	private String etapa;

}
