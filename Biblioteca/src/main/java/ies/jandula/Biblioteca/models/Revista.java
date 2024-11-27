package ies.jandula.Biblioteca.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Revista {
	
	@EmbeddedId
	private RevistaId revistaId;
	
	@Column
	private String frecuencia_publicacion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_usuario", referencedColumnName = "email", nullable = false)
	private Usuario usuario;

}
