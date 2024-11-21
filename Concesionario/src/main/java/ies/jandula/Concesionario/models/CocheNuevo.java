package ies.jandula.Concesionario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class CocheNuevo extends Coche{
	
	@Column
	private Integer unidadesExistentes;	
	
	public CocheNuevo(Coche coche) {
		super(coche);
	}

}
