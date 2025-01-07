package ies.jandula.empleados.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class HistorialPuestosId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5726856051806586730L;
	
	private Date fechaInicio;

	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "idEmpleado")
	private Empleados empleados;

}
