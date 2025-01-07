package ies.jandula.empleados.models;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Empleados {
	
	@Id
	@Column(precision = 6)
	private BigDecimal idEmpleado;
	
	@Column(length = 20)
	private String nombre;
	
	@Column(length = 25, nullable = false)
	private String apellidos;
	
	@Column(length = 25, nullable = false)
	private String email;
	
	@Column(length = 20)
	private String telefono;
	
	@Column(nullable = false)
	private Date fechaContrato;
	
	@Column(precision = 8, scale = 2)
	private BigDecimal salario;
	
	@Column(precision = 2, scale = 2)
	private BigDecimal comisionPct;
	
	@ManyToOne
	@JoinColumn(name = "id_gerente", referencedColumnName = "idEmpleado")
	private Empleados gerente;
	
	@ManyToOne
	@JoinColumn(name = "id_puesto", referencedColumnName = "idPuesto")
	private Puestos puestos;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento")
	private Departamentos departamentos;
	
}
