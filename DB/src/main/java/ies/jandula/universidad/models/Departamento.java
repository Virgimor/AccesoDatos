package ies.jandula.universidad.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departamento {
	
	@Id
	@Column(length=10)
	private Integer id;
	
	@Column(length=45)
	private String nombre;
	
	/*@OneToMany(mappedBy="idDepartamento")
	private List<Profesor> profesor;*/


}
