package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Matricula")
public class Matricula {
	
	@EmbeddedId
	private MatriculaId matriculaId;

}
