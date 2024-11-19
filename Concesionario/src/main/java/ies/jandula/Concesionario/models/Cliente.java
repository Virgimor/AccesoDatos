package ies.jandula.Concesionario.models;

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
public class Cliente {
	
	@Id
	@Column(length = 9)
	private String nif;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@Column(length = 50, nullable = false)
	private String direccion;
	
	@Column(length = 12, nullable = false)
	private String telefono;
	
	@OneToMany(mappedBy = "cliente")
	private List<Coche> coches;
	

}
