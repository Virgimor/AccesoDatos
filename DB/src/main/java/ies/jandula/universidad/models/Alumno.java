package ies.jandula.universidad.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumno {
	
	@Id
	@Column(length= 10)
	private Long id;
	
	@Column(length =45)
	private String apellido1;
	
	@Column(length =45)
	private String apellido2;
	
	@Column(length =45)
	private String ciudad;
	
	@Column(length =45)
	private String direccion;
	
	@Column(length =45)
	private Date fechaNacimiento;
	
	@Column(length =45)
	private String nif;
	
	@Column(length =45)
	private String nombre;
	
	@Column(length =45)
	private String sexo;
	
	@Column(length =45)
	private String telefono;
	
	@OneToMany(mappedBy = "idAlumno")
	private List<Matricula> matricula;

}
