package es.jandula.MatriculasHorarios.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profesor {
	
	@Id
	@Column(length = 100)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_nombre", referencedColumnName = "nombre")
	private Departamento departamento;
	
	//@OneToMany(mappedBy = "profesor")
	//private List<ProfesorReduccionId> profesorReduccionId;

}
