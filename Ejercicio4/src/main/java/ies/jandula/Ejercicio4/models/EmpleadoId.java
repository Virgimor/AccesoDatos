package ies.jandula.Ejercicio4.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EmpleadoId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1205339145799537775L;
	
	private int idEmpleado;
	
	@Column(length = 9)
	private String dniEmpleado;

}
