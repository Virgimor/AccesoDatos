package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfesorReduccion {
	
	@EmbeddedId
	private ProfesorReduccionId profesorReduccionId;

}
