package ies.jandula.Ejercicio6.models;

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
public class Trabajar {
	
	@EmbeddedId
	private TrabajarId trabajarId;
	
	@Column
	private Date fechaIncorporacion;
	
	@Column
	private Boolean funcionCoordinacion;
	
	@ManyToOne
	@MapsId("codigo")
	@JoinColumn(name = "codigo_proyecto", referencedColumnName = "codigo")
	private Proyectos proyectos;
	
	@ManyToOne
	@MapsId("nif")
	@JoinColumn(name = "nif_empleado", referencedColumnName = "nif")
	private Empleado empleado;

}
