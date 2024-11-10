package ies.jandula.Ejercicio1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empresa {
	
	@Id
	@Column(length = 9, nullable = false)
	private String nif;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 100)
	private String direccion;
	
	@OneToMany(mappedBy = "empresa")
	private List<Evento> evento;

}
