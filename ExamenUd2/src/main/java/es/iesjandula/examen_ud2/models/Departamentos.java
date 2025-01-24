package es.iesjandula.examen_ud2.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Departamentos {
	
	@Id
	@Column(precision = 4)
	private BigDecimal idDepartamento;
	
	@Column(length = 30, nullable = false)
	private String nombreDepartamento;
	
	@ManyToOne
	@JoinColumn(name = "id_gerente", referencedColumnName = "idEmpleado")
	private Empleados idGerente;
	
	@ManyToOne
	@JoinColumn(name = "id_ubicacion", referencedColumnName = "idUbicacion")
	private Ubicaciones ubicaciones;
	
	@OneToMany(mappedBy = "departamentos")
	List<Empleados> listaEmpleados;
	
	@OneToMany(mappedBy = "departamentos")
	private List<HistorialPuestos> listaHistorialPuestos;

}
