package ies.jandula.Biblioteca.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Sala {
	
	@Id
	private String nombre;
	
	@Column
	private Integer capacidad;
	
	@OneToMany(mappedBy = "sala") 
	private List<Libro> libros;

}
