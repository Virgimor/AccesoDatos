package es.jandula.MatriculasHorarios.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reduccion {
	
	@Id
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column
	private int horas;
	
	@Column
	private boolean decideDireccion;
	
	//@OneToMany(mappedBy = "reduccion")
	//private List<ProfesorReduccionId> profesorReduccionId;

}
