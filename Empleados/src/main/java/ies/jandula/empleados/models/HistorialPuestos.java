package ies.jandula.empleados.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class HistorialPuestos {
	
	@EmbeddedId
	private HistorialPuestosId historialPuestosId;
	
	@Column(nullable = false)
	private Date fechaFin;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento")
	private Departamentos departamentos;
	
	@ManyToOne
	@JoinColumn(name = "id_puesto", referencedColumnName = "idPuesto")
	private Puestos puestos;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "idEmpleado")
	@MapsId("empleados")
	private Empleados empleados;

}
