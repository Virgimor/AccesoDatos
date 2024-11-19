package ies.jandula.Concesionario.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Mecanico {
	
	@Id
	@Column(length = 9)
	private String dni;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@Column
	private Double salario;
	
	@Column 
	private Date fechaContratacion;

}
