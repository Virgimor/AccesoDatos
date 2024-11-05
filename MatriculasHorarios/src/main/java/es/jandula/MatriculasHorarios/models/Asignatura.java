package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Asignatura")
public class Asignatura {
	
	@EmbeddedId
	private AsignaturaId asignaturaId;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_propietario", referencedColumnName = "nombre", nullable = false)
	private Departamento departamentoPropietario;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_receptor", referencedColumnName = "nombre", nullable = false)
	private Departamento departamentoReceptor;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Bloque bloque;
	
	
}
