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
@ToString(exclude = "matriculas")
public class Curso {
	
	@Id
	@Column(length = 10)
	private Integer id;
	
	@Column
	private int anyoFin;
	
	@Column
	private int anyoInicio;
	
	@OneToMany(mappedBy = "idCurso")
	private List<Matricula> matriculas;

}
