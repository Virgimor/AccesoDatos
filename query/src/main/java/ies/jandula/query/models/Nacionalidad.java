package ies.jandula.query.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "listaAlumno")
public class Nacionalidad {
	
	@Id// "Española"
	@Column(length = 50)
	private String nombre;
	
	@Column//"España"
	private String pais;
	
	@OneToMany(mappedBy = "nacionalidad")
	List<Alumno> listaAlumno;

}
