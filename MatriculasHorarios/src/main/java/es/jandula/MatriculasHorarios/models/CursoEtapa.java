package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso_etapa")
public class CursoEtapa {
	
	@EmbeddedId
	private CursoEtapaId cursoEtapaId;
	

	public CursoEtapa() {
		super();
	}

	public CursoEtapaId getCursoEtapaId() {
		return cursoEtapaId;
	}

	public void setCursoEtapaId(CursoEtapaId cursoEtapaId) {
		this.cursoEtapaId = cursoEtapaId;
	}
		

}
