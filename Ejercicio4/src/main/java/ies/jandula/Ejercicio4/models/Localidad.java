package ies.jandula.Ejercicio4.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Localidad {
	
	@Id
	@Column(nullable = false)
	private Integer codigoLocalidad;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "localidad")
	private List<Empleado> empleado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Provincia provincia;

}
