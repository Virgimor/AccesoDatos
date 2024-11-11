package ies.jandula.universidad.models;

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
public class Departamento {
	
	@Id
	@Column(length=10)
	private Long id;
	
	@Column(length=45)
	private String nombre;
	
	@OneToMany(mappedBy="idDepartamento")
	private List<Profesor> profesor;


}