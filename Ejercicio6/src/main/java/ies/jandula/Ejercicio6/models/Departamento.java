package ies.jandula.Ejercicio6.models;

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
public class Departamento {
	
	@Id
	private Integer codigo;
	
	@Column(length = 50)
	private String nombre;
	
	@OneToMany(mappedBy = "departamento")
	private List<Empleado> empleados;

}
