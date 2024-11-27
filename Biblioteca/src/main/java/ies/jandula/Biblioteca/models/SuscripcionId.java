package ies.jandula.Biblioteca.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class SuscripcionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7416920931645895646L;
	
	@ManyToOne
	@JoinColumn(name = "email_usuario", referencedColumnName = "email")
	private Usuario emailUsuario;
	
	@ManyToOne
	private Revista revista;
	
	
	private Date fechaInicio;

}
