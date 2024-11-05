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
public class AsignaturaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7293791064438845820L;
	
	private int curso;
	
	@Column(length = 50)
	private String etapa;
	
	@Column(length = 2)
	private String grupo;
	
	@Column(length = 100)
	private String nombre;

}
