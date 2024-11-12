package ies.jandula.Ejercicio6.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Empleado {
	
	@Id
	@Column(length = 9, nullable = false)
	private String nif;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 100)
	private String apellidos;
	
	@Column
	private Date fechaNacimiento;
	
	@Column(length = 12, unique = true)
	private String telefono;
	
	@Column(length = 50)
	private String titulacion;
	
	@ManyToOne
	private Departamento departamento;

}
