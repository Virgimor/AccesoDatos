package ies.jandula.universidad.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "asignaturas")
public class Grado {
	
	@Id
	@Column(length = 10)
	private Integer id;
	
	@Column(length = 100)
	private String nombre;
	
	@OneToMany(mappedBy = "idGrado")
	private List<Asignatura> asignaturas;

}
