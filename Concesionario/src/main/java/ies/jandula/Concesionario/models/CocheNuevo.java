package ies.jandula.Concesionario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class CocheNuevo extends Coche{
	
	@Column
	private Integer unidadesExistentes;

	public Integer getUnidadesExistentes() {
		return unidadesExistentes;
	}

	public void setUnidadesExistentes(Integer unidadesExistentes) {
		this.unidadesExistentes = unidadesExistentes;
	}
	

}
