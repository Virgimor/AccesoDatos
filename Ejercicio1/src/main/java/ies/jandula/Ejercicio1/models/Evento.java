package ies.jandula.Ejercicio1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
	
	@Id
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column
	private Integer duracion;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Empresa empresa;
	

}
