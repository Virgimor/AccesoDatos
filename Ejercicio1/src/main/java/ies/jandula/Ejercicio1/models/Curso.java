package ies.jandula.Ejercicio1.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
	
	@EmbeddedId
	private CursoId cursoId;
	
	@Column(length = 50)
	private String nombreTutor;
	
	

}
